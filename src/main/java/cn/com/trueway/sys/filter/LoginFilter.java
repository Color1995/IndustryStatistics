package cn.com.trueway.sys.filter;

import cn.com.trueway.sys.entity.User;
import cn.com.trueway.sys.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录拦截器
 * 还有另一种方法 HandlerInterceptor
 */

public class LoginFilter implements Filter {

    private IUserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath();
        String url = request.getRequestURI();
        HttpSession session = request.getSession();

        System.out.println("path: " + path);
        System.out.println("url: " + url);
        // 如果不需要过滤的静态文件，直接放行。
        /**
         *  其他参数：
         *  path.endsWith(".css") || path.endsWith(".js")
         *  || url.indexOf("resource") > 0 || url.indexOf("note") > 0
         */
        if (path.contains("login.do")) {
//            System.out.println("filter！");
            filterChain.doFilter(request, response); // 放行
            return;
        }

        // 判断用户账号和id是否正确
        String user_id = (String) session.getAttribute("user_id");
        String user_account = (String) session.getAttribute("user_account");
        System.out.println(user_id + user_account);
        if(StringUtils.isNotEmpty(user_account)){
            // 自定义加载 IUserService
            ServletContext context = request.getServletContext();
            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
            userService = ctx.getBean(IUserService.class);
            // 建议用新方法值查出一个Id值 优化
            String id = userService.findUserIdByAccount(user_account);
            try {
                if (id.equals(user_id)) {
                    filterChain.doFilter(request,response);
                } else {
                    // 未登录，重定向到404，message:未登录, 界面两秒后跳出未登录。
                    response.sendRedirect(request.getContextPath() + "/statics/error/404.html");
                }
            }catch (NullPointerException e){
                // TODO 插入log记录
                response.sendRedirect(request.getContextPath() + "/statics/error/404.html");
            }
        } else {
            // 未登录，重定向到404，message:未登录, 界面两秒后跳出未登录。
            response.sendRedirect(request.getContextPath() + "/statics/error/404.html");
        }

    }

    @Override
    public void destroy() {

    }
}
