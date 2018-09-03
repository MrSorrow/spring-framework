package guo.ping.ioc.customtag;

/**
 * @description: 订单类
 * @author: guoping wang
 * @date: 2018/9/3 9:12
 * @project: spring
 */
public class Order {

	private String orderId;
	private String item;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId='" + orderId + '\'' +
				", item='" + item + '\'' +
				'}';
	}
}
