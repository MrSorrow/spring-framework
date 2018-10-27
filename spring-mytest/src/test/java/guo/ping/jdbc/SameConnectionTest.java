package guo.ping.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/27 9:29
 * @project: spring
 */
public class SameConnectionTest {

	@Test
	public void testUseDifferentConnection() {
		Connection connection1 = null;
		Connection connection2 = null;
		Connection connection3 = null;
		PreparedStatement preparedStatement = null;

		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");

			// 获取数据库连接
			connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "1234");
			connection2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "1234");
			connection3 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "1234");

			connection1.setAutoCommit(false);
			connection1.setAutoCommit(false);
			preparedStatement = connection1.prepareStatement("insert into actor(first_name, last_name, last_update) values (?, ?, ?)");
			preparedStatement.setString(1, "郑七");
			preparedStatement.setString(2, "郑七");
			preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.executeUpdate();

			connection2.setAutoCommit(false);
			preparedStatement = connection2.prepareStatement("insert into actor(first_name, last_name, last_update) values (?, ?, ?)");
			preparedStatement.setString(1, "张三");
			preparedStatement.setString(2, "张三");
			preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.executeUpdate();
			connection2.commit();

			connection3.setAutoCommit(false);
			preparedStatement = connection3.prepareStatement("insert into actor(first_name, last_name, last_update) values (?, ?, ?)");
			preparedStatement.setString(1, "李四");
			preparedStatement.setString(2, "李四");
			preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.executeUpdate();
			int i = 5 / 0;
			connection3.commit();

			connection1.commit();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			if (connection1 != null) {
				try {
					connection1.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection1 != null) {
				try {
					connection1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection2 != null) {
				try {
					connection1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection3 != null) {
				try {
					connection1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	@Test
	public void testUseSameConnection() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");

			// 获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "1234");
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement("insert into actor(first_name, last_name, last_update) values (?, ?, ?)");
			preparedStatement.setString(1, "赵六");
			preparedStatement.setString(2, "赵六");
			preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.executeUpdate();

			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement("insert into actor(first_name, last_name, last_update) values (?, ?, ?)");
			preparedStatement.setString(1, "王五");
			preparedStatement.setString(2, "王五");
			preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.executeUpdate();
			connection.commit();

			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement("insert into actor(first_name, last_name, last_update) values (?, ?, ?)");
			preparedStatement.setString(1, "李四");
			preparedStatement.setString(2, "李四");
			preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.executeUpdate();
			int i = 5 / 0;
			connection.commit();

			connection.commit();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
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
