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
	 * @param account
	 * @return User
	 */
	User findUserByAccount(String account);
	
}
