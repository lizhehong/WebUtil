package cn.ITHong.convertor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConvertor extends DefaultTypeConverter {
/**
 * 解決時間 如在查看時出現 91/08/07
 * 而我們需要的是1991/08/07
 * */
	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
		DateFormat df = new SimpleDateFormat("y-M-d");
		if (toType == Date.class) {
			//条件符合字符串转化为日期
			// 转化成日期 value 是數組 String[]
			String s = ((String[]) value)[0];
			try {
				// 解析字符串中的文本，以生成一个 Date
				return df.parseObject(s);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		} else {
			Date d = (Date) value;
			// 将一个 Date 格式化为日期/时间字符串。
			return df.format(d);
		}
	}

}
