package guo.ping.ioc.propertieseditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 注册Spring自带日期的属性编辑器
 * @author: guoping wang
 * @date: 2018/10/4 11:16
 * @project: spring
 */
public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
