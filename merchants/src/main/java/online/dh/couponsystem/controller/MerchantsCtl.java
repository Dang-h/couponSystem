package online.dh.couponsystem.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import online.dh.couponsystem.service.IMerchantsServe;
import online.dh.couponsystem.valueObject.CouponTemplate;
import online.dh.couponsystem.valueObject.CreateMerchantsRequest;
import online.dh.couponsystem.valueObject.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商户服务Controller
 */
@Slf4j
@RestController // Rest：用到Rest风格的API；Controller：注册为JavaBean
@RequestMapping("/merchants")  // 商户都以merchants开头，以merchants开头url的http请求都需要拦截处理
public class MerchantsCtl {

	/**
	 * 商户服务接口
	 */
	private final IMerchantsServe merchantsServe;

	@Autowired
	public MerchantsCtl(IMerchantsServe merchantsServe) {
		this.merchantsServe = merchantsServe;
	}

	@ResponseBody
	@PostMapping("/create")
	public Response createMerchants(@RequestBody CreateMerchantsRequest request) {

		log.info("CreateMerchants: {}", JSON.toJSONString(request));

		return merchantsServe.createMerchants(request);
	}

	@ResponseBody
	@GetMapping("/{id}")
	public Response buildMerchantsInfo(@PathVariable Integer id) {

		log.info("BuildMerchantsInfo: {}", id);

		return merchantsServe.buildMerchantsInfoId(id);
	}

	@ResponseBody
	@PostMapping("/drop")
	public Response dropCouponTemplate(@RequestBody CouponTemplate couponTemplate) {

		log.info("DropCouponTemplate: {}", couponTemplate);

		return merchantsServe.dropCouponTemplate(couponTemplate);
	}
}
