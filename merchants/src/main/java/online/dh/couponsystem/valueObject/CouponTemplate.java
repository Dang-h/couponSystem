package online.dh.couponsystem.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.dh.couponsystem.constant.ErrorCode;
import online.dh.couponsystem.dao.MerchantsDao;

import java.util.Date;

/**
 * <h2>商户投放优惠券对象定义</h2>
 * 封装了优惠券的一些基本信息
 */
@Data // 利用Lombok实现set/get方法
@AllArgsConstructor
@NoArgsConstructor
public class CouponTemplate {

	/** 所属商户id */
	private Integer id;

	/** 优惠券标题 */
	private  String title;

	/** 优惠券摘要 */
	private String summary;

	/** 优惠券详情 */
	private String desc;

	/** 优惠券上限数量 */
	private Long limit;

	/** 优惠券是否有token */
	private Boolean hasToken;

	/** 优惠券背景颜色 */
	private Integer background;

	/** 优惠券有效开始时间 */
	private Date start;

	/** 优惠券最后有效时间 */
	private Date end;

	/**
	 * <h3>校验优惠券对象有效性</h3>
	 * @param merchantsDao {@link MerchantsDao}
	 * @return {@link ErrorCode}
	 */
	public ErrorCode validate(MerchantsDao merchantsDao) {

		if (null == merchantsDao.findById(id)) {
			return ErrorCode.MERCHANTS_NOT_EXIST;
		}

		return ErrorCode.SUCCESS;
	}
}
