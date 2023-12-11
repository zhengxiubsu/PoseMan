package SuperPose;

import java.sql.*;

public class DbFunctions {
    public Connection connect_to_db(String dbname,String user,String pass){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:7249/"+dbname,user,pass);
            if(conn!=null){
                System.out.println("Connection Established");
            }
            else{
                System.out.println("Connection Failed");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
    public void createUsersTable(Connection conn) {
        Statement statement;
        try {
            String query = "CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY, " +
                    "username VARCHAR(50) UNIQUE NOT NULL, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL, " +
                    "age INT, " +
                    "gender VARCHAR(10) NOT NULL);";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Users Table Created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createExerciseLogsTable(Connection conn) {
        Statement statement;
        try {
            String query = "CREATE TABLE IF NOT EXISTS exercise_logs (" +
                    "log_id SERIAL PRIMARY KEY, " +
                    "user_id INT NOT NULL, " +
                    "exercise_type VARCHAR(50) NOT NULL, " +
                    "count INT, " +
                    "duration INT, " +
                    "log_date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP, " +
                    "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE);";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Exercise Logs Table Created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void insertUser(Connection conn, String username, String password, String email, int age, String gender) {
        PreparedStatement statement;
        try {
            String query = "INSERT INTO users (username, password, email, age, gender) VALUES (?, ?, ?, ?, ?);";
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password); // 注意: 密码应该加密处理
            statement.setString(3, email);
            statement.setInt(4, age);
            statement.setString(5, gender);
            statement.executeUpdate();
            System.out.println("User Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void insertExerciseLog(Connection conn, int userId, String exerciseType, int count, int duration, Timestamp logDate) {
        PreparedStatement statement;
        try {
            String query = "INSERT INTO exercise_logs (user_id, exercise_type, count, duration, log_date) VALUES (?, ?, ?, ?, ?);";
            statement = conn.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setString(2, exerciseType);
            statement.setInt(3, count);
            statement.setInt(4, duration);
            statement.setTimestamp(5, logDate);
            statement.executeUpdate();
            System.out.println("Exercise Log Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void readUsers(Connection conn) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM users;";
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id") + ", ");
                System.out.print("Username: " + rs.getString("username") + ", ");
                System.out.print("Email: " + rs.getString("email") + ", ");
                System.out.print("Age: " + rs.getInt("age") + ", ");
                System.out.println("Gender: " + rs.getString("gender"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void readExerciseLogs(Connection conn) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM exercise_logs;";
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print("Log ID: " + rs.getInt("log_id") + ", ");
                System.out.print("User ID: " + rs.getInt("user_id") + ", ");
                System.out.print("Exercise Type: " + rs.getString("exercise_type") + ", ");
                System.out.print("Count: " + rs.getInt("count") + ", ");
                System.out.print("Duration: " + rs.getInt("duration") + ", ");
                System.out.println("Log Date: " + rs.getTimestamp("log_date"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateUser(Connection conn, int id, String username, String password, String email, int age, String gender) {
        PreparedStatement statement;
        try {
            String query = "UPDATE users SET username = ?, password = ?, email = ?, age = ?, gender = ? WHERE id = ?;";
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password); // 注意: 密码应该加密处理
            statement.setString(3, email);
            statement.setInt(4, age);
            statement.setString(5, gender);
            statement.setInt(6, id);
            statement.executeUpdate();
            System.out.println("User Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void updateExerciseLog(Connection conn, int logId, int userId, String exerciseType, int count, int duration, Timestamp logDate) {
        PreparedStatement statement;
        try {
            String query = "UPDATE exercise_logs SET user_id = ?, exercise_type = ?, count = ?, duration = ?, log_date = ? WHERE log_id = ?;";
            statement = conn.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setString(2, exerciseType);
            statement.setInt(3, count);
            statement.setInt(4, duration);
            statement.setTimestamp(5, logDate);
            statement.setInt(6, logId);
            statement.executeUpdate();
            System.out.println("Exercise Log Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void searchByUserId(Connection conn, int userId) {
        PreparedStatement statement;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM users WHERE id = ?;";
            statement = conn.prepareStatement(query);
            statement.setInt(1, userId);
            rs = statement.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.print("ID: " + rs.getInt("id") + ", ");
                System.out.print("Username: " + rs.getString("username") + ", ");
                System.out.print("Email: " + rs.getString("email") + ", ");
                System.out.print("Age: " + rs.getInt("age") + ", ");
                System.out.println("Gender: " + rs.getString("gender"));
            }

            if (!found) {
                System.out.println("No user found with ID: " + userId);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchByEmail(Connection conn, String email) {
        PreparedStatement statement;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM users WHERE email = ?;";
            statement = conn.prepareStatement(query);
            statement.setString(1, email);
            rs = statement.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.print("ID: " + rs.getInt("id") + ", ");
                System.out.print("Username: " + rs.getString("username") + ", ");
                System.out.print("Email: " + rs.getString("email") + ", ");
                System.out.print("Age: " + rs.getInt("age") + ", ");
                System.out.println("Gender: " + rs.getString("gender"));
            }

            if (!found) {
                System.out.println("No user found with Email: " + email);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void deleteUser(Connection conn, int id) {

        PreparedStatement statement;
        try {
            String query = "DELETE FROM users WHERE id = ?;";
            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User Deleted with ID: " + id);
            } else {
                System.out.println("No user found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void deleteExerciseLog(Connection conn, int logId) {
        PreparedStatement statement;
        try {
            String query = "DELETE FROM exercise_logs WHERE log_id = ?;";
            statement = conn.prepareStatement(query);
            statement.setInt(1, logId);
            statement.executeUpdate();
            System.out.println("Exercise Log Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void delete_table(Connection conn, String table_name){
        Statement statement;
        try {
            String query= String.format("drop table %s",table_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }


}

