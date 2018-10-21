package guo.ping.aop.jdk;

/**
 * @description: User的数据库持久层
 * @author: guoping wang
 * @date: 2018/10/12 10:45
 * @project: spring
 */
public interface UserDao {

	int saveUser(User user);

	User getUserByName(String userName);
}
