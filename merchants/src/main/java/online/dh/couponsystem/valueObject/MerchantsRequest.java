package online.dh.couponsystem.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.dh.couponsystem.constant.ErrorCode;
import online.dh.couponsystem.dao.MerchantsDao;
import online.dh.couponsystem.entity.Merchants;

/**
 * <h2>商户请求对象</h2>
 * 封装了商户的一些信息以及验证请求的有效性及将商户请求对象转换为商户对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantsRequest {

	private String name;

	private String logoUrl;

	private String businessLicenseUrl;

	private String address;

	private String phone;

	/**
	 * <h3>验证请求的有效性</h3>
	 *
	 * @param merchantsDao {@link MerchantsDao}
	 * @return {@link ErrorCode}
	 */
	public ErrorCode validate(MerchantsDao merchantsDao) {

		// TODO 什么时候触发
		if (merchantsDao.findByName(this.name) != null) {
			return ErrorCode.DUPLICATE_BUSINESS_NAME;
		}

		if (null == this.logoUrl) {
			return ErrorCode.EMPTY_LOGO;
		}

		if (null == this.businessLicenseUrl) {
			return ErrorCode.EMPTY_BUSINESS_LICENCE;
		}

		if (null == this.address) {
			return ErrorCode.EMPTY_ADDRESS;
		}

		if (null == this.phone) {
			return ErrorCode.ERROR_PHONE;
		}

		return ErrorCode.SUCCESS;
	}

	/**
	 * <h3>将请求对象转换为商户对象</h3>
	 * @return {@link Merchants}
	 */
	public Merchants toMerchants() {
		Merchants merchants = new Merchants();
		merchants.setName(name);
		merchants.setLogoUrl(logoUrl);
		merchants.setBusinessLicenseUrl(businessLicenseUrl);
		merchants.setAddress(address);
		merchants.setPhone(phone);

		return merchants;
	}
}
