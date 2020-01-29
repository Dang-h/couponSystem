package online.dh.couponsystem.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import online.dh.couponsystem.valueObject.CreateMerchantsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <h2>商户服务测试类</h2>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class MerchantsServeTest {

	@Autowired
	private IMerchantsServe merchantsServe;

	@Test
	@Transactional
	public void testCreateMerchants() {
		CreateMerchantsRequest merchantsRequest = new CreateMerchantsRequest();
		merchantsRequest.setName("测试");
		merchantsRequest.setLogoUrl("www.d-h.online");
		merchantsRequest.setAddress("北京");
		merchantsRequest.setPhone("1234567890");
		merchantsRequest.setBusinessLicenseUrl("www.d-h.online");

		System.out.println(JSON.toJSONString(merchantsServe.createMerchants(merchantsRequest)));;
	}
}
