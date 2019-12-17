package cn.com.trueway.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.com.trueway.sys.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.trueway.sys.entity.User;
import cn.com.trueway.sys.service.IUserService;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author Color1995
 * @email midwayking@163.com
 * @time 2019.12.15 01:16
 * @notes 重写
 */

@Slf4j
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
	 * 项目登录页
	 * @param account
	 * @param password
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login.do", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseResult<Void> loginOld(
			@RequestParam("account") String account,
			@RequestParam("password") String password,
			HttpSession session, HttpServletRequest request) {

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
				result.setFlag(true);
				result.setMessage("登录成功！");
				// 将用户唯一id和账户名存入session
				session.setAttribute("user_id", user.getGuid());
				session.setAttribute("user_account", user.getAccount());
				log.debug("登录成功");
			}else {
				result.setFlag(false);
				result.setMessage("用户名或密码不正确！");
				log.debug("用户名或密码不正确！");
			}
		} catch (Exception e) {
			result.setFlag(false);
			result.setMessage("用户名或密码不正确！");
		} finally {
			// 记录Ip模块
			try {
				Properties properties = PropertiesUtil.readPropertiesFile("application.properties");
				String OpenIpSer = properties.getProperty("OpenIpSer");
				if (OpenIpSer.equals("true")){
					String IP = IPUtil2.getIpAddress(request);
					String PIP = IPUtil2.getPublicIp();
					System.out.println("IP: " + IP);
					System.out.println("PIP: " + PIP);
				}
			} catch (FileNotFoundException e){
				// TODO log 未发现 application.properties
				System.out.println("未发现 application.properties");
			}
			// 获取session中所有的键值
			Enumeration<?> enumeration = session.getAttributeNames();
			// 遍历enumeration
			while (enumeration.hasMoreElements()) {
				// 获取session的属性名称
				String name = enumeration.nextElement().toString();
				// 根据键值取session中的值
				Object value = session.getAttribute(name);
				// 打印结果
				System.out.println("name:" + name + ",value:" + value );
			}
		}
		return result;
	}


	//用于退出页面
	@RequestMapping("tologout")
	public String toLogOut(HttpServletRequest request){
		// 销毁session中的值
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}


	/**
	 * 项目首页
	 * @return
	 */
	@RequestMapping(value="/index.do")
	private String showHomePage() {

		return "index";
	}

}