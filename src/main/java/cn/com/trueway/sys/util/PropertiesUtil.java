/**
 * 文件名称:PropertiesUtil.java
 * 作者:陈静<br>
 * 邮箱:c_jing1984@163.com<br>
 * 创建时间:2014-2-26 上午08:55:51
 * CopyRight (c)2009-2011:江苏中威科技软件系统有限公司<br>
 */
package cn.com.trueway.sys.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 描述：TODO 配置文件工具类<br>
 * 作者：陈静<br>
 * 邮箱:c_jing1984@163.com<br>
 * 创建时间：2014-2-26 上午08:55:51<br>
 * 修改人：<修改人中文名或拼音缩写><br>
 * 修改时间：<修改日期，格式：同创建时间><br>
 * 修改原因及地方：<修改原因描述><br>
 * 版本：v1.0<br>
 * JDK版本：JDK1.6<br>
 */
public class PropertiesUtil {

	// 配置文件根目录
	public final static String DIR_PATH = "config";

	/**
	 * 
	 * 描述：读取配置文件<br>
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 *             Properties 作者:陈静<br>
	 *             邮箱:c_jing1984@163.com<br>
	 *             创建时间:2014-2-26 上午09:17:07
	 */
	public static Properties readPropertiesFile(String fileName)
			throws FileNotFoundException {

		Properties prop = new Properties();
		InputStream stream = null;
		// 读取config下的的properties文件
		// String filePath = DIR_PATH + Filee.separator + fileName;
		// stream = new BufferedInputStream(new FileInputStream(new File(filePath)));
		stream = PropertiesUtil.class.getResourceAsStream("/" + fileName);
		try {
			prop.load(stream);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * 描述：测试<br>
	 * 
	 * @param args
	 *            void 作者:陈静<br>
	 *            邮箱:c_jing1984@163.com<br>
	 *            创建时间:2014-2-26 上午08:55:51
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Properties p = PropertiesUtil.readPropertiesFile("jdbc.properties");
		System.out.println(p.getProperty("jdbc.password"));
	}

}
