package SuperPose;
import java.sql.Timestamp;
public class ExerciseLog {
    private int logId;
    private int userId;
    private String exerciseType; // 'push-ups', 'plank'
    private int count; // 用于次数型运动
    private int duration; // 用于时间型运动，单位为秒
    private Timestamp logDate;

    // 构造函数
    public ExerciseLog() {
        // 默认构造函数
    }

    public ExerciseLog(int logId, int userId, String exerciseType, int count, int duration, Timestamp logDate) {
        this.logId = logId;
        this.userId = userId;
        this.exerciseType = exerciseType;
        this.count = count;
        this.duration = duration;
        this.logDate = logDate;
    }

    // Getter和Setter方法
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getLogDate() {
        return logDate;
    }

    public void setLogDate(Timestamp logDate) {
        this.logDate = logDate;
    }
}
