package cn.com.trueway.sys.util;

import javax.servlet.http.HttpSession;

/**
 * 所有控制器类的基类
 * @author Administrator
 *
 */
public abstract class BaseController {
	/**
	 * 
	 * @param session
	 * @return user.id
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		
		return Integer.valueOf(session.getAttribute("user_id").toString());
	}
}
