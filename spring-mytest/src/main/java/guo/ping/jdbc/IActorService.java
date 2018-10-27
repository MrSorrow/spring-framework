package guo.ping.jdbc;

import java.util.List;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/21 19:02
 * @project: spring
 */
public interface IActorService {
	void save(Actor actor);
	List<Actor> getUsers();
	List<Actor> getAllUsers();
	Integer getActorsCount();
}
