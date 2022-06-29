package Dao;

import com.oracle.jdbc.util.Dao;
import Entity.User;

import java.util.List;

public class UserDao {

    public List<User> selectAll(){
        String sql="SELECT * FROM TB_USER";
        return Dao.query(sql,User.class);
    }

    public void insert(User user){
        String sql="INSERT INTO TB_USER(USER_NAME,REAL_NAME,PASSWORD,PHONE,REMAIN,OPERATOR,CREATE_TIME) VALUES(?,?,?,?,?,?,now())";
        System.out.println("插入中");
        Dao.executeSql(sql,user.getUserName(),user.getRealName(),user.getPassword(),user.getPhone(),user.getRemain(),user.getOperator());
    }
    public void delete(Integer id){
        String sql="DELETE FROM TB_USER WHERE USER_ID=?";
        Dao.executeSql(sql,id);
    }
}
