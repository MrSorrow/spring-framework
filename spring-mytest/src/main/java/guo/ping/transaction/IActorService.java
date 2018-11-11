package guo.ping.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/21 19:02
 * @project: spring
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface IActorService {
	void save(Actor actor) throws RuntimeException;
	List<Actor> getUsers();
	List<Actor> getAllUsers();
	Integer getActorsCount();
}
