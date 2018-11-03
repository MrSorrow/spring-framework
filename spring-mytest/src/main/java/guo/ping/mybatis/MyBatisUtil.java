package guo.ping.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @description: 用户获取单例的SqlSessionFactory
 * @author: guoping wang
 * @date: 2018/10/28 10:02
 * @project: spring
 */
public class MyBatisUtil {
	private static final SqlSessionFactory sqlSessionFactory;
	static {
		String resouce = "single-mybatis-config.xml";
		Reader reader = null;

		try {
			reader = Resources.getResourceAsReader(resouce);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
