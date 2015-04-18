package cn.ITHong.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class StringUtil {
	public static String encode(String message) {
		try {
			String as = Base64.encodeBase64String(message.getBytes());
			return as;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static String decode(String message) {
		String as;
		try {
			as = new String(Base64.decodeBase64(message), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return as;
	}
}
