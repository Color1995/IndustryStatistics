package cn.com.trueway.sys.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;



/**
 * 对Controller层的一些重复代码的封装
 * 
 * @author 顾熙
 */
public abstract class ControllerUtils {
	/**
	 * 对文本进行Url解码，使用UTF-8编码进行解码，文本本身为null或者解码失败均返回null
	 * @param text
	 * @return
	 */
	public static String urlDecode(String text) {
		if (text == null || "".equals(text)) {
			return text;
		}
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 参数快速封装到Map
	 * @param params 参数格式为key,value,key,value.... 参数必须是偶数，否则返回Null
	 * @return
	 */
	public static Map<String, Object> paramater2Map(Object ... params){
		if (params.length%2 == 1) {
			System.err.println("cn.com.trueway.cms.core.util.ControllerUtils#paramater2Map: 参数必须是偶数！");
			return null;
		}
		Map<String, Object> map = new TreeMap<String, Object>();
		for (int i=0;i<params.length;i++) {
			map.put((String) params[i], params[i+1]);
			i++;
		}
		return map;
	}
	
	/**
	 * 从request中读取key值并按原key设置回attribute
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getParamater(HttpServletRequest request, String key) {
		String value = request.getParameter(key);
		request.setAttribute(key, value);
		return value;
	}
	
	/**
	 * 从request中读取key值并按原key设置回attribute，如果value为空则设置并返回默认值
	 * @param request
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String getParamater(HttpServletRequest request, String key, String defValue) {
		String value = request.getParameter(key);
		if (StringUtils.isBlank(value)) {
			value = defValue;
		}
		request.setAttribute(key, value);
		return value;
	}

	/**
	 * 把List<Map<String,Object>> 转换为 List<Map<String, String>>，blob字段不参与转换，日期字段转为yyyy-MM-dd HH:mm:ss格式
	 * @param list
	 * @return
	 * @throws SQLException 
	 */
	public static List<Map<String, String>> listMapObject2listMapString(List<Map<String, Object>> list) throws SQLException {
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Map<String, Object> map : list) {
			Map<String, String> m = new TreeMap<String, String>();
			for (Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				String key = entry.getKey();
				if (value == null) {
					m.put(key, null);
				} else {
					if (Date.class.isAssignableFrom(value.getClass())) {
						m.put(key, sdf.format(value));
					} else if (Blob.class.isAssignableFrom(value.getClass())) {
						// 忽视BLOB字段
					} else if (Clob.class.isAssignableFrom(value.getClass())) {
						Clob c = (Clob) value;
						m.put(key, c.getSubString(0, (int)c.length())); // int足够存储2GB的文字，如果不够用考虑到内存占用应该不使用这个方法人工重写
					} else {
						m.put(key, value.toString());
					}
				}
			}
			result.add(m);
		}
		return result;
	}
	
	/**
	 * 把List<Object[]> 转换为 List<Map<String, String>>，blob字段不参与转换，日期字段转为yyyy-MM-dd HH:mm:ss格式
	 * （注：已设定忽略下标为0的字段）
	 * @param list
	 * @return wdq
	 * @throws SQLException 
	 */
	public static List<Map<String, String>> listObjectToListMap(List<Object[]> list,String[] columns) throws SQLException {
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Object[] objs : list) {
			Map<String, String> m = new TreeMap<String, String>();
			//使用中第一个字段一般为id字段，所以导出时自动忽略
			for (int i = 1;i<objs.length;i++) {
				Object value = objs[i];
				if (value == null) {
					m.put(columns[i-1], null);
				} else {
					if (Date.class.isAssignableFrom(value.getClass())) {
						m.put(columns[i-1], sdf.format(value));
					} else if (Blob.class.isAssignableFrom(value.getClass())) {
						// 忽视BLOB字段
					} else if (Clob.class.isAssignableFrom(value.getClass())) {
						Clob c = (Clob) value;
						m.put(columns[i-1], c.getSubString(0, (int)c.length())); // int足够存储2GB的文字，如果不够用考虑到内存占用应该不使用这个方法人工重写
					} else {
						m.put(columns[i-1], value.toString());
					}
				}
			}
			result.add(m);
		}
		return result;
	}
}
