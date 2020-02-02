package online.dh.couponsystem.coupon.constant;

/**
 * <h2>评论类型</h2>
 */
public enum FeedbackType {

	PASS(1, "针对优惠券的评论"),
	APP(2, "针对卡包App的评论");

	/** 评论类型编码 */
	private int code;

	/** 评论类型描述 */
	private String desc;

	FeedbackType(int code, String desc) {

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
