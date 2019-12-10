package cn.com.trueway.sys.service;

import cn.com.trueway.sys.entity.User;

/**
 * 
 * @author King1995
 * @date 2019年5月27日
 *
 */

public interface IUserService {
	
	/**	
	 * @param loginName
	 * @return User
	 */
	User findUserByLoginname(String loginName);
	
}
