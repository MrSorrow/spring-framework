package guo.ping.transaction;

import java.sql.Timestamp;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/3 10:38
 * @project: spring
 */
public class Actor {

	private Integer id;
	private String firstName;
	private String lastName;
	private Timestamp lastUpdate;

	public Actor(Integer id, String firstName, String lastName, Timestamp lastDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastDate() {
		return lastUpdate;
	}

	public void setLastDate(Timestamp lastDate) {
		this.lastUpdate = lastDate;
	}

	@Override
	public String toString() {
		return "Actor{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", lastDate=" + lastUpdate +
				'}';
	}
}
