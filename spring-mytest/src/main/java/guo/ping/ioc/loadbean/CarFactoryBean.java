package guo.ping.ioc.loadbean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @description: 实现FactoryBean接口创建Car对象
 * @author: guoping wang
 * @date: 2018/9/5 10:44
 * @project: spring
 */
public class CarFactoryBean implements FactoryBean<Car> {

	private String carInfo;

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] splitInfo = carInfo.split(",");
		car.setBrand(splitInfo[0]);
		car.setMaxSpeed(Integer.valueOf(splitInfo[1]));
		car.setPrice(Double.valueOf(splitInfo[2]));
		return car;
	}

	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
