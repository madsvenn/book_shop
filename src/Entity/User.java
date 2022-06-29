package Entity;

public class User {

    Integer userId;
    String userName;
    String realName;
    String password;
    String phone;
    Integer remain;
    String operator;
    String createTime;

    public User() {
    }

    public User(Integer userId, String userName, String realName, String password, String phone, Integer remain, String operator, String createTime) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.password = password;
        this.phone = phone;
        this.remain = remain;
        this.operator = operator;
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", remain=" + remain +
                ", operator='" + operator + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
