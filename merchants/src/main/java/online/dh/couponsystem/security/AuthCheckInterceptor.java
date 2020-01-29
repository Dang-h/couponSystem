package online.dh.couponsystem.security;

import online.dh.couponsystem.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h2>权限拦截器</h2>
 * 用于http的权限校验防止恶意http访问请求
 */

@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

	//http请求之前进行逻辑校验，用于对http请求拦截
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

		String token = httpServletRequest.getHeader(Constants.TOKEN_STRING);

		if(StringUtils.isEmpty(token)){
			throw new Exception("Header 中缺少" + Constants.TOKEN_STRING + "!");
		}

		if (!token.equals(Constants.TOKEN)){
			throw new Exception("Header 中" + Constants.TOKEN_STRING + "错误！");
		}

		AccessContext.setToken(token);

		return true;
	}

	// http请求处理完成后再处理
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	// 确认http处理完成之后执行，多用于清理工作
	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

		AccessContext.clearAccesskey();

	}
}
