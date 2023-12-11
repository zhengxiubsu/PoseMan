package SuperPose;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db("pose", "postgres", "7249");
        // 创建表
        db.createUsersTable(conn);
        db.createExerciseLogsTable(conn);
        // 插入用户信息
        for (int i = 1; i <= 10; i++) {
            db.insertUser(conn, "user" + i, "password" + i, "user" + i + "@example.com", 20 + i, "male");
        }

        // 插入运动记录
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            db.insertExerciseLog(conn, i, "push-ups", random.nextInt(50), random.nextInt(180), new Timestamp(System.currentTimeMillis()));
        }

        // 更新一条用户信息
        db.updateUser(conn, 1, "updatedUser", "updatedPassword", "updatedEmail@example.com", 25, "female");

        // 搜索一条用户信息
        db.searchByUserId(conn, 1);

        // 删除一条用户信息
        db.deleteUser(conn, 10);

        // 更新一条运动记录
        db.updateExerciseLog(conn, 1, 1, "plank", 30, 300, new Timestamp(System.currentTimeMillis()));

        // 删除一条运动记录
        db.deleteExerciseLog(conn, 10);

        // 读取所有用户信息
        db.readUsers(conn);

        // 读取所有运动记录
        db.readExerciseLogs(conn);

        db.delete_table(conn,"exercise_logs"); // 首先删除 exercise_logs 表
        db.delete_table(conn,"users");         // 然后删除 users 表
    }
}
