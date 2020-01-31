package online.dh.couponsystem.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import online.dh.couponsystem.valueObject.CouponTemplate;
import online.dh.couponsystem.valueObject.CreateMerchantsRequest;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
//	@Transactional
	public void testCreateMerchants() {
		CreateMerchantsRequest merchantsRequest = new CreateMerchantsRequest();
		merchantsRequest.setName("测试2");
		merchantsRequest.setLogoUrl("www.d-h.online");
		merchantsRequest.setAddress("云南");
		merchantsRequest.setPhone("1234567890");
		merchantsRequest.setBusinessLicenseUrl("www.d-h.online");

		System.out.println(JSON.toJSONString(merchantsServe.createMerchants(merchantsRequest)));;
	}

	@Test
	public void testBuildMerchantsInfoId(){
		//{"data":{"address":"北京","businessLicenseUrl":"www.d-h.online","id":26,"isAudit":false,
		// "logoUrl":"www.d-h.online","name":"测试","phone":"1234567890"},
		// "errorCode":0,"errorMsg":""}
		System.out.println(JSON.toJSONString(merchantsServe.buildMerchantsInfoId(26)));
		//{"errorCode":6,"errorMsg":"商户不存在"}
		System.out.println(JSON.toJSONString(merchantsServe.buildMerchantsInfoId(25)));
	}

	@Test
	public void testDropCouponTemplate(){
		CouponTemplate couponTemplate = new CouponTemplate();
		couponTemplate.setId(27);
		couponTemplate.setTitle("测试2");
		couponTemplate.setSummary("测试2");
		couponTemplate.setDesc("测试2");
		couponTemplate.setBackground(3);
		couponTemplate.setHasToken(false);
		couponTemplate.setStart(new Date());
		couponTemplate.setEnd(DateUtils.addDays(new Date(), 10));

		System.out.println(JSON.toJSONString(merchantsServe.dropCouponTemplate(couponTemplate)));
	}
}
