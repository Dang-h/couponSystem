package online.dh.couponsystem.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h2>通用响应结果</h2>
 * http请求相应结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

	/** 返回值对象 */
	private final Object data;

	/** 错误码， 执行成功返回0 */
	private Integer errorCode = 0;

	/** 错误信息， 执行成功返回空字符串 */
	private String msg = "";

	/**
	 * <h3>响应正确的构造函数</h3>
	 * 执行成功返回一个值对象
	 * @param data 返回值对象
	 */
	public Response(Object data) {
		this.data = data;
	}
}
