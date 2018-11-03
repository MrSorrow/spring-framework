package guo.ping.mybatis;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/28 9:42
 * @project: spring
 */
public interface IActorMapper {
	void insertActor(Actor actor);
	Actor getActorById(Integer id);
}
