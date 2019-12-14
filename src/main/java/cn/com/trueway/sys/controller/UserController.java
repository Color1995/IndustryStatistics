package cn.com.trueway.sys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.trueway.sys.entity.User;
import cn.com.trueway.sys.service.IUserService;
import cn.com.trueway.sys.util.BaseController;
import cn.com.trueway.sys.util.ResponseResult;

/**
 * @author Color1995
 * @email midwayking@163.com
 * @time 2019.12.15 01:16
 * @notes 重写
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * 此Controller共有四个方法。
	 * 登录、注册、修改密码、注销
	 *
	 */

	@Autowired
	private IUserService userService;

	/**
	 *
	 * @param account
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login.do", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseResult<Void> login(
			@RequestParam("account") String account,
			@RequestParam("password") String password,
			HttpSession session) {

		// 声明返回值
		ResponseResult<Void> result = new ResponseResult<Void>();

		System.out.println("----------login check-----------");
		// 获取用户名账号和密码
		String user_account = account;
		String user_password = password;
		try {
			User user = userService.findUserByAccount(account);
			// 判断密码是否相同
			if(password.equals(user.getPassword())) {
				result.setState(1);
				// 将用户唯一id和账户名存入session
				session.setAttribute("user_id", user.getGuid());
				session.setAttribute("user_account", user.getAccount());
			}else {
				result.setState(0);
				result.setMessage("用户名或密码不正确！");
			}
		} catch (Exception e) {
			result.setState(ResponseResult.STATE_ERROR);
			result.setMessage("用户名或密码不正确！");
		}
		return result;
	}

	@RequestMapping(value="/index-all.do")
	private String showHomePage() {

		return "index-all";
	}

}