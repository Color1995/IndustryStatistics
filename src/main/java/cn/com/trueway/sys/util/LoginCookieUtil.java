package cn.com.trueway.sys.util;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
 
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * 用户登陆cookie加密操作工具类
 * @author wdq
 *
 */
public class LoginCookieUtil {
	

	private static final byte[] DESIV = new byte[] { 0x12, 0x34, 0x56, 120, (byte) 0x90, (byte) 0xab, (byte) 0xcd, (byte) 0xef };// 向量
	 
	private static AlgorithmParameterSpec iv = null;// 加密算法的参数接口
	private static Key key = null;
	
	private static String jiami = "9ba45bfd500642328ec03ad8ef1b6e75";
	
	private static String charset = "utf-8";
	static{
		DESKeySpec keySpec = null;
		try {
			keySpec = new DESKeySpec(jiami.getBytes(charset));
		} catch (Exception e) {
			e.printStackTrace();
		}// 设置密钥参数
		iv = new IvParameterSpec(DESIV);// 设置向量
		SecretKeyFactory keyFactory = null;
		try {
			keyFactory = SecretKeyFactory.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 获得密钥工厂
		try {
			key = keyFactory.generateSecret(keySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 得到密钥对象
	}
	
	/**
	 * 加密
	 * @author ershuai
	 * @date 2017年4月19日 上午9:40:53
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
		enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
		byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
		BASE64Encoder base64Encoder = new BASE64Encoder();
		return base64Encoder.encode(pasByte);
	}
	
	/**
	 * 解密
	 * @author ershuai
	 * @date 2017年4月19日 上午9:41:01
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {
		Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		deCipher.init(Cipher.DECRYPT_MODE, key, iv);
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));
		return new String(pasByte, "UTF-8");
	}

	
	
	public static void main(String[] args) {
		try {
			String test = "weqqwew,ewe,23213";
			System.out.println("加密前的字符：" + test);
			System.out.println("加密后的字符：" + LoginCookieUtil.encode(test));
			System.out.println("解密后的字符：" + LoginCookieUtil.decode(LoginCookieUtil.encode(test)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}
}
