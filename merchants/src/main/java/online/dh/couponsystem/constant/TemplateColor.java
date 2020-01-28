package online.dh.couponsystem.constant;

/**
 * <h2>优惠券背景颜色枚举定义</h2>
 */
public enum TemplateColor {

	RED(1, "红色"),
	GREEN(2, "绿色"),
	BLUE(3, "蓝色");

	private final int code;
	private final String color;

	TemplateColor(int code, String color) {
		this.code = code;
		this.color = color;
	}

	public Integer getCode() {
		return code;
	}

	public String getColor() {
		return color;
	}
}
