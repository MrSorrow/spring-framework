package guo.ping.jdbc;

import java.util.Date;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/21 18:47
 * @project: spring
 */
public class Actor {

	private Integer id;
	private String firstName;
	private String lastName;
	private Date lastDate;

	public Actor(Integer id, String firstName, String lastName, Date lastDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastDate = lastDate;
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

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	@Override
	public String toString() {
		return "Actor{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", lastDate=" + lastDate +
				'}';
	}
}
