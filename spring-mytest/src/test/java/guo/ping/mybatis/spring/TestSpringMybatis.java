package guo.ping.mybatis.spring;

import guo.ping.mybatis.Actor;
import guo.ping.mybatis.IActorMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/28 11:27
 * @project: spring
 */
public class TestSpringMybatis {

	@Test
	public void testSpringAndMybatis() {
		ApplicationContext context = new ClassPathXmlApplicationContext("mybatisSpring-Test.xml");
		IActorMapper actorMapper = (IActorMapper) context.getBean("IActorMapper");
		Actor actor = actorMapper.getActorById(200);
		System.out.println(actor);
		Actor newActor = new Actor(null, "java", "hello wold", new Timestamp(System.currentTimeMillis()));
		actorMapper.insertActor(newActor);
	}
}
