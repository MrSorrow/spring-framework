package guo.ping.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Date;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/25 15:01
 * @project: spring
 */
public class JdbcTest {

	@Test
	public void testJDBC() {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");

			// 获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila",
					"root", "1234");

			// 利用SQL创建PreparedStatement
			preparedStatement = connection.prepareStatement("select * from actor where actor_id > ? and actor_id < ?");
			// 设置PreparedStatement参数
			preparedStatement.setInt(1, 5);
			preparedStatement.setInt(2, 11);

			// 执行PreparedStatement获取结果集ResultSet
			resultSet = preparedStatement.executeQuery();

			// 遍历结果集封装成Actor
			while (resultSet.next()) {
				Integer id = resultSet.getInt("actor_id");
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				Date date = resultSet.getDate("last_update");
				System.out.println(new Actor(id, first_name, last_name, date));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
