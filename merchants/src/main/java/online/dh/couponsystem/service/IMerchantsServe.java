package online.dh.couponsystem.service;

import online.dh.couponsystem.valueObject.CouponTemplate;
import online.dh.couponsystem.valueObject.CreateMerchantsRequest;
import online.dh.couponsystem.valueObject.Response;

/**
 * <h2>商家服务接口定义</h2>
 */
public interface IMerchantsServe {

	/**
	 * <h3>创建商户服务</h3>
	 *
	 * @param request {@link CreateMerchantsRequest} 创建商户请求
	 * @return {@link Response}
	 */
	Response createMerchants(CreateMerchantsRequest request);

	/**
	 * <h3>根据商户id构建商户信息</h3>
	 *
	 * @param id 商户id
	 * @return {@link Response}
	 */
	Response buildMerchantsInfoId(Integer id);

	/**
	 * <h3>优惠券投放</h3>
	 * 商户子系统核心
	 * @param template {@link CouponTemplate} 优惠券对象
	 * @return {@link Response}
	 */
	Response dropCouponTemplate(CouponTemplate template);
}
