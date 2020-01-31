package online.dh.couponsystem.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import online.dh.couponsystem.constant.Constants;
import online.dh.couponsystem.constant.ErrorCode;
import online.dh.couponsystem.dao.MerchantsDao;
import online.dh.couponsystem.entity.Merchants;
import online.dh.couponsystem.service.IMerchantsServe;
import online.dh.couponsystem.valueObject.CouponTemplate;
import online.dh.couponsystem.valueObject.CreateMerchantsRequest;
import online.dh.couponsystem.valueObject.CreateMerchantsResponse;
import online.dh.couponsystem.valueObject.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <h2>商家接口服务实现</h2>
 */
@Slf4j
@Service  //JavaBean的注解
public class MerchantsServeImpl implements IMerchantsServe {

	/**
	 * merchants数据库接口
	 */
	private final MerchantsDao merchantsDao;

	/**
	 * kafka客户端
	 */
	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	public MerchantsServeImpl(MerchantsDao merchantsDao, KafkaTemplate<String, String> kafkaTemplate) {
		this.merchantsDao = merchantsDao;
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	@Transactional  // 启动事务，保存成功提交，失败回滚
	public Response createMerchants(CreateMerchantsRequest request) {

		Response response = new Response();
		CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

		// 校验商户的请求是否合法
		ErrorCode validate = request.validate(merchantsDao);

		if (validate != ErrorCode.SUCCESS) {
			// 出错信息
			merchantsResponse.setId(-1);
			response.setErrorCode(validate.getCode());
			response.setErrorMsg(validate.getDesc());
		} else {
			// 成功，返回值为商户在平台生成的数据的主键id
			// save方法，保存merchants对象（请求对象转换为商户对象）返回merchants对象，
			// 读取merchants对象表中的主键id
			merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
		}

		response.setData(merchantsResponse);
		return response;
	}

	@Override
	public Response buildMerchantsInfoId(Integer id) {

		Response response = new Response();

		Merchants merchantsById = merchantsDao.findById(id);
		if (merchantsById == null) {
			response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
			response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
		}

		response.setData(merchantsById);
		return response;
	}

	@Override
	public Response dropCouponTemplate(CouponTemplate template) {

		Response response = new Response();

		ErrorCode validate = template.validate(merchantsDao);
		if (validate != ErrorCode.SUCCESS) {
			response.setErrorCode(validate.getCode());
			response.setErrorMsg(validate.getDesc());
		} else {
			// 将couponTemplate进行序列化以便于日志打印和投放
			String couponTemplate = JSON.toJSONString(template);
			kafkaTemplate.send(
					// 设置kafka Topic，不设置会自动创建
					Constants.TEMPLATE_TOPIC,
					// key
					Constants.TEMPLATE_TOPIC,
					// data
					couponTemplate
			);
			log.info("DropCouponTemplate: {}", couponTemplate);
		}
		return response;
	}
}
