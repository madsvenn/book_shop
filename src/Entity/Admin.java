package Entity;

import java.util.Date;

public class Admin {
    Integer adminID;
    String adminName;
    String realName;
    String password;
    String role;

    String operator;
    Integer accessCount;
    Date last_access_time;
    Date create_time;

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public Date getLast_access_time() {
        return last_access_time;
    }

    public void setLast_access_time(Date last_access_time) {
        this.last_access_time = last_access_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminName='" + adminName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", operator='" + operator + '\'' +
                ", accessCount=" + accessCount +
                ", last_access_time=" + last_access_time +
                ", create_time=" + create_time +
                '}';
    }
}
