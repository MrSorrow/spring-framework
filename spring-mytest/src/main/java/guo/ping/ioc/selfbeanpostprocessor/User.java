package guo.ping.ioc.selfbeanpostprocessor;

/**
 * @description: 自定义 BeanPostProcessor 的 user
 * @author: guoping wang
 * @date: 2018/10/5 16:47
 * @project: spring
 */
public class User {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				'}';
	}
}
