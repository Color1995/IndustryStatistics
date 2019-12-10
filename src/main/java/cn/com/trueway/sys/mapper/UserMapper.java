package cn.com.trueway.sys.mapper;

import cn.com.trueway.sys.entity.User;

/**
 * Mybatis的处理用户数据的持久层接口
 * @author jiuge
 *
 */

public interface UserMapper {
	
	/**
	 * 根据登录名查找用户是否已存在
	 * @param loginName
	 * @return User 如果存在返回User对象，不存在返回null
	 */
	User findUserByLoginname(String loginName);
	
	
}
