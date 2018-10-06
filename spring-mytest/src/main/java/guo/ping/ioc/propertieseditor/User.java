package guo.ping.ioc.propertieseditor;

import java.util.Date;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/3 21:42
 * @project: spring
 */
public class User {

	private String userName;
	private Date date;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", date=" + date +
				'}';
	}
}
