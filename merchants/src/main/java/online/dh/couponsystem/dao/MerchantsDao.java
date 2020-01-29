package online.dh.couponsystem.dao;

import online.dh.couponsystem.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h2>Merchants Dao接口</h2>
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

	/**
	 * <h3>根据id获取商户对象</h3>
	 * @param id 商户 id
	 * @return {@link Merchants}
	 */
	Merchants findById(Integer id);

	/**
	 * <h3>根据商户名称获取商户对象</h3>
	 * @param name 商户名称
	 * @return {@link Merchants}
	 */
	Merchants findByName(String name);
}
