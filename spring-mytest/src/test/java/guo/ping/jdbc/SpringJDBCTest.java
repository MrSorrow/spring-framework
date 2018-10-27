package guo.ping.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @description: 测试Spring的JDBC
 * @author: guoping wang
 * @date: 2018/10/21 19:41
 * @project: spring
 */
public class SpringJDBCTest {

	@Test
	public void testSpringJDBC() {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-Test.xml");
		IActorService actorService = (IActorService) context.getBean("actorService");
		Actor actor = new Actor(null, "guoping", "wang", new Date());
		actorService.save(actor);

		int actorsCount = actorService.getActorsCount();
		System.out.println(actorsCount);

		List<Actor> users = actorService.getUsers();
		for (Actor user : users) {
			System.out.println(user);
		}

		List<Actor> allUsers = actorService.getAllUsers();
		for (Actor user : allUsers) {
			System.out.println(user);
		}
	}
}
