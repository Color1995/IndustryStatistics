import cn.com.trueway.sys.entity.User;
import cn.com.trueway.sys.service.IUserService;
import cn.com.trueway.sys.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:pocket_xml/spring/applicationContext.xml"})
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void findUserByAccount(){
        User user= userService.findUserByAccount("admin");
        System.out.println(user);
    }

    @Test
    public void findIdByAccount(){
        String id = userService.findUserIdByAccount("admin");
        System.out.println(id);
    }
}
