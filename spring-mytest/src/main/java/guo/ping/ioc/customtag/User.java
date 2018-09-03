package guo.ping.ioc.customtag;

/**
 * @description: User实体类
 * @author: guoping wang
 * @date: 2018/9/2 13:48
 * @project: spring
 */
public class User {
	private String userName;
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
