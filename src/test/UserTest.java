import cn.com.trueway.sys.entity.User;
import cn.com.trueway.sys.service.IMenuService;
import cn.com.trueway.sys.service.IUserService;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:all_xml/spring/applicationContext.xml"})
public class UserTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMenuService menuService;

    @Test
    public void findUserByAccount(){
        User user= userService.findUserByAccount("admin");
        System.out.println(user);
    }

    @Test
    public void findIdByAccount(){
        System.out.println("before_time: " + System.currentTimeMillis());
        String id = userService.findUserIdByAccount("admin");
//        User user = userService.findUserByAccount("admin");
        System.out.println("after_time: " + System.currentTimeMillis());
        System.out.println(id);
    }

    @Test
    public void findMenus(){
        Map<String, Object> result = menuService.getMenusById("99545017B7465021E055000000000001", "99FD34ADC6C9090AE055000000000001");
        System.out.println(result.size());
    }
}
