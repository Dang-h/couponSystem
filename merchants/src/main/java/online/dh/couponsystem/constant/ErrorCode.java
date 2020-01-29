package online.dh.couponsystem.constant;

/**
 * <h2>错误码枚举定义</h2>
 */
public enum ErrorCode {

	SUCCESS(0, ""),
	DUPLICATE_BUSINESS_NAME(1, "商户名称重复"),
	EMPTY_LOGO(2, "商户logo为空"),
	EMPTY_BUSINESS_LICENCE(3, "商户营业执照为空"),
	ERROR_PHONE(4, "商户联系电话为空"),
	EMPTY_ADDRESS(5, "商户地址为空"),
	MERCHANTS_NOT_EXIST(6, "商户不存在");

	private final int code;
	private final String desc;

	ErrorCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
