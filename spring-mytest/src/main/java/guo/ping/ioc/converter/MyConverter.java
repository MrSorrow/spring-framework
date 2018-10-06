package guo.ping.ioc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 自定义String2Date转换器
 * @author: guoping wang
 * @date: 2018/10/6 8:44
 * @project: spring
 */
public class MyConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		Date date = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
