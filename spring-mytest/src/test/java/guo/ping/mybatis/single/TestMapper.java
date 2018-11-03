package guo.ping.mybatis.single;

import guo.ping.mybatis.Actor;
import guo.ping.mybatis.IActorMapper;
import guo.ping.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/28 10:17
 * @project: spring
 */
public class TestMapper {

	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	}

	@Test
	public void testInsertActor() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			IActorMapper actorMapper = sqlSession.getMapper(IActorMapper.class);
			actorMapper.insertActor(new Actor(null,"王老五", "嘻嘻", new Timestamp(System.currentTimeMillis())));
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void getActorById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			IActorMapper actorMapper = sqlSession.getMapper(IActorMapper.class);
			Actor actor = actorMapper.getActorById(100);
			System.out.println(actor);
		} finally {
			sqlSession.close();
		}
	}
}
