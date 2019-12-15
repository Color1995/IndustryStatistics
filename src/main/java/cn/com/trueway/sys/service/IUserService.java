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
	 * 根据账号查找出User
	 * @param account
	 * @return User
	 */
	User findUserByAccount(String account);

	/**
	 * 为loginFilter准备,优化代码
	 * @param account
	 * @return user_id
	 */
	String findUserIdByAccount(String account);
}
