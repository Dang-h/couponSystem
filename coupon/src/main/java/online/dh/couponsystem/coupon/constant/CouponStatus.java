package online.dh.couponsystem.coupon.constant;

/**
 * <h2>优惠券状态</h2>
 * 优惠券使用状态枚举
 */
public enum CouponStatus {

	UNUSED(1, "未被使用"),
	USED(2, "已使用"),
	ALL(3, "全部领取的");

	/**
	 * 状态码
	 */
	private int code;
	/**
	 * 状态描述
	 */
	private String desc;

	CouponStatus(int code, String desc) {

		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
