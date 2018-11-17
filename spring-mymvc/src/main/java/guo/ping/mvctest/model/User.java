package guo.ping.mvctest.model;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/16 12:48
 * @project: mvc-test
 */
public class User {

    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
