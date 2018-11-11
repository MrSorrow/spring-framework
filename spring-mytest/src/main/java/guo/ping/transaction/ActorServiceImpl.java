package guo.ping.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/3 10:40
 * @project: spring
 */
public class ActorServiceImpl implements IActorService {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Actor actor) throws RuntimeException {
		jdbcTemplate.update("insert into actor(first_name, last_name, last_update) values (?, ?, ?)",
				new Object[]{actor.getFirstName(), actor.getLastName(), actor.getLastDate()},
				new int[]{Types.VARCHAR, Types.VARCHAR, Types.DATE});
//		throw new RuntimeException("发生异常....");
	}

	@Override
	public List<Actor> getUsers() {
		return jdbcTemplate.query("select * from actor where actor_id < ?",
				new Object[]{10}, new int[]{Types.INTEGER}, new ActorRowMapper());
	}

	@Override
	public List<Actor> getAllUsers() {
		return jdbcTemplate.query("select * from actor", new ActorRowMapper());
	}

	@Override
	public Integer getActorsCount() {
		return jdbcTemplate.queryForObject("select count(*) from actor", Integer.class);
	}
}
