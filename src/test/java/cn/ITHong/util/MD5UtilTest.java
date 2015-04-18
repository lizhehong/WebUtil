package cn.ITHong.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class MD5UtilTest {

	@Test
	public void test() {
		System.out.println(StringUtil.encode("a8922993"));

		System.out.println(StringUtil.decode("YTg5MjI5OTM="));
	}

}
