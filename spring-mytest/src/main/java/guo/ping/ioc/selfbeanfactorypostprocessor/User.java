package guo.ping.ioc.selfbeanfactorypostprocessor;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/4 21:18
 * @project: spring
 */
public class User {

	private String username;
	private String password;
	private String message;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
