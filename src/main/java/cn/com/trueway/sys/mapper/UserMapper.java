package cn.com.trueway.sys.mapper;

import cn.com.trueway.sys.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Mybatis的处理用户数据的持久层接口
 * @author jiuge
 *
 */
@Repository
public interface UserMapper {
	
	/**
	 * 根据登录名查找用户是否已存在
	 * @param account
	 * @return User 如果存在返回User对象，不存在返回null
	 */
	User findUserByAccount(String account);

	/**
	 * 为loginFilter准备,优化代码
	 * @param account
	 * @return user_id
	 */
	String findUserIdByAccount(String account);
}
