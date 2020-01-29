package online.dh.couponsystem.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h2>商户相应对象</h2>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantsResponse {

	/** 商户id， 创建失败返回 -1 */
	// TODO ？为什么创建失败为 -1
	private Integer id;
}
