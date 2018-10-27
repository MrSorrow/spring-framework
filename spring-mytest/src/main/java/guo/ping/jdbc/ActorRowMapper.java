package guo.ping.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/21 18:53
 * @project: spring
 */
public class ActorRowMapper implements RowMapper<Actor> {

	@Override
	public Actor mapRow(ResultSet set, int rowNum) throws SQLException {
		System.out.println(rowNum);
		return new Actor(set.getInt("actor_id"), set.getString("first_name"),
				set.getString("last_name"), set.getDate("last_update"));
	}
}
