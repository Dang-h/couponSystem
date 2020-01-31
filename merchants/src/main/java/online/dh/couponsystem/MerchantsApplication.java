package online.dh.couponsystem;

import online.dh.couponsystem.security.AuthCheckInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootApplication
public class MerchantsApplication extends WebMvcConfigurerAdapter {

	// 注入自定义拦截器
	@Resource
	private AuthCheckInterceptor authCheckInterceptor;

	public static void main(String[] args) {

		SpringApplication.run(MerchantsApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 先注册拦截器，再配置拦截器拦截哪些请求
		registry.addInterceptor(authCheckInterceptor).addPathPatterns("/merchants/**");
		super.addInterceptors(registry);
	}
}
