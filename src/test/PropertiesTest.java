import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class)
public class PropertiesTest {
    //方法一
    @Test
    public void readProperty1() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config/jdbc");
        System.out.println(resourceBundle.getString("jdbc.password"));

        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("config/jdbc.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.get("jdbc.password"));
    }

}
