package online.dh.couponsystem.security;

/**
 * <h2>使用 ThreadLocal 单独存储每一个线程携带的 Token 信息</h2>
 * ThreadLocal 适用于每个线程需要自己独立的实例且该实例需要在多个方法中使用，当线程结束时能被实例能被回收
 */
public class AccessContext {

	private static final ThreadLocal<String> token = new ThreadLocal<String>();

	public static String getToken() {
		return token.get();
	}

	public static void setToken(String tokenStr) {
		token.set(tokenStr);
	}

	/**
	 * 线程清理
	 */
	public static void clearAccesskey() {
		token.remove();
	}
}
