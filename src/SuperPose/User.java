package SuperPose;

import java.sql.Timestamp;

public class User {
    private int id;
    private String username;
    private String password; // 注意: 实际应用中密码应该进行加密处理
    private String email;
    private int age;
    private String gender; // 'male', 'female', 'other'

    // 构造函数
    public User() {
        // 默认构造函数
    }

    public User(int id, String username, String password, String email, int age, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    // Getter和Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
