package cn.com.trueway.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.trueway.sys.entity.User;
import cn.com.trueway.sys.mapper.UserMapper;
import cn.com.trueway.sys.service.IUserService;
import cn.com.trueway.sys.service.exception.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author King1995
 * @Date 2019/05/27
 *
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByAccount(String account) throws UsernameNotFoundException{
		// 判断用户是否存在
		User user = userMapper.findUserByAccount(account);
		System.out.println(user);
		if(user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("用户名不存在！");
		}
		
	}

}
