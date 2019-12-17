package cn.com.trueway.zdcy.util;

import com.sun.mail.util.BASE64EncoderStream;

public class Encryption {
	/*
	public static String getEncryption(String Plaintext) {
		if (Plaintext !=null && Plaintext != "") {
			char[] c = Plaintext.toCharArray();

			// 使用for循环给字符数组加密
			for (int i = 0; i < c.length; i++) {

				c[i] = (char) (c[i] ^ 20000);

			}
			return new String(c);
		} else {
			return Plaintext;
		}
		

	}
	
	public static void main(String[] args) {
		String mw =Encryption.getEncryption("select count(1) from new_start t where t.b like '____HAGY___' and t.p like '%开发区%'");
		String xx =Encryption.getEncryption(mw);
		String xw =Encryption.getEncryption(xx);
		System.out.println(mw);
		System.out.println(xx);
	}
	*/
}
