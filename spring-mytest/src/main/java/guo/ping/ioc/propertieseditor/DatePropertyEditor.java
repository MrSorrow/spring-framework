package guo.ping.ioc.propertieseditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 自定义日期的属性编辑器
 * @author: guoping wang
 * @date: 2018/10/4 10:25
 * @project: spring
 */
public class DatePropertyEditor extends PropertyEditorSupport {

	private String format = "yyyyMMdd";

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("text: " + text);
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			Date d = sdf.parse(text);
			this.setValue(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
