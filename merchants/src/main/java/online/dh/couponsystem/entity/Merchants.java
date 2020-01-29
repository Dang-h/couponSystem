package online.dh.couponsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <h2>商户对象模型</h2>
 * 表的Java对象定义
 */

@Data //实现get/set方法
@AllArgsConstructor //全参构造器
@NoArgsConstructor //无参构造器
@Entity //表明它是一个实体对象
@Table(name = "merchants") //实体对象属性定义，指定定义的表
public class Merchants {

	/** 商户id，主键，自增，不为null*/
	@Id //表明这个属性是指定表的主键
	@GeneratedValue //主键自增，不需要手动设置
	@Column(name = "id", nullable = false) //指定表对应列字段，以及字段属性
	private Integer id;

	/** 商户名称，全局唯一 */
	@Basic //表明该属性为表的基本列
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	/** 商户logo，不为null */
	@Basic
	@Column(name = "logo_url", nullable = false)
	private String logo_url;

	/** 商户营业执照， 不为null*/
	@Basic
	@Column(name = "business_license_url", nullable = false)
	private String businessLicenseUrl;

	/** 商户联系电话 */
	@Basic
	@Column(name = "phone", nullable = false)
	private String phone;

	/** 商户地址 */
	@Basic
	@Column(name = "address", nullable = false)
	private String address;

	/** 商家是否通过审核 */
	@Basic
	@Column(name = "is_audit", nullable = false)
	private Boolean isAudit = false;
}
