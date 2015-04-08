package cn.ITHong.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;



public class MD5Util {
	public static String encode(String message) {
		try {
			String as = new Base64().encodeAsString(DigestUtils.md5(message));
			//String to = new Base64().encodeToString(DigestUtils.md5(message));
			//return "結果="+as.equals(to);
			return as;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
