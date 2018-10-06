package guo.ping.ioc.propertyplaceholder;

/**
 * @description: PropertyPlaceholderConfigure示例所用bean
 * @author: guoping wang
 * @date: 2018/10/4 19:40
 * @project: spring
 */
public class HelloMessage {

	private String message;
	private String time;

	@Override
	public String toString() {
		return "HelloMessage{" +
				"message='" + message + '\'' +
				", time='" + time + '\'' +
				'}';
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
