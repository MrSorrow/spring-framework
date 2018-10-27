package guo.ping.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/21 19:04
 * @project: spring
 */
public class ActorServiceImpl implements IActorService {

	protected final Log logger = LogFactory.getLog(getClass());

	private JdbcTemplate jdbcTemplate;

	// 设置数据源
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Actor actor) {
		logger.info("haha");
		jdbcTemplate.update("insert into actor(first_name, last_name, last_update) values (?, ?, ?)",
				new Object[]{actor.getFirstName(), actor.getLastName(), actor.getLastDate()},
				new int[]{Types.VARCHAR, Types.VARCHAR, Types.DATE});
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
