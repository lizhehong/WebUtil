package cn.ITHong.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtil {
	private static DataSource ds;
	static {
		try {
			InputStream in = DBCPUtil.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);
			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static DataSource getDataSource() {
		return ds;
	}
}
