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

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * @author Color1995
	 * @email midwayking@163.com
	 *
	 */

	@Autowired
	private IUserService userService;

	@RequestMapping(value="/login.do", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseResult<Void> login(
			@RequestParam("account") String account,
			@RequestParam("password") String password,
			HttpSession session) {

		// 声明返回值
		ResponseResult<Void> rr = new ResponseResult<Void>();

		System.out.println("--------------login in-----------");
		String user_account = account;
		try {
			User user = userService.findUserByLoginname(account);
			//		System.out.println("pp" + password);
			if(password.equals(user.getPassword())) {
				rr.setState(1);
				session.setAttribute("Id", user.getGuid());
				session.setAttribute("username", user.getAccount());
			}else {
				rr.setState(0);
				rr.setMessage("用户名或密码不正确！");
			}
		} catch (Exception e) {
			rr.setState(ResponseResult.STATE_ERROR);
			rr.setMessage("用户名或密码不正确！");
		}
		return rr;
	}

	@RequestMapping(value="/index-all.do")
	private String showHomePage() {

		return "index-all";
	}

}