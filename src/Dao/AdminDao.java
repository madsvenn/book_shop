package Dao;

import com.oracle.jdbc.util.Dao;
import Entity.Admin;

import java.util.List;

public class AdminDao {

    public Admin selectAdminByPassword(String adminName, String password){

        String sql="SELECT * FROM TB_ADMIN WHERE ADMIN_NAME=? AND PASSWORD=md5(?)";
        Admin admin= Dao.queryOne(sql,Admin.class,new Object[]{adminName,password});
        return admin;
    };

    public void updateLoginInfo(Integer adminID){

        String sql="UPDATE TB_ADMIN SET ACCESS_COUNT=ACCESS_COUNT+1,LAST_ACCESS_TIME=NOW() WHERE ADMIN_ID=?";
        Dao.executeSql(sql,adminID);
    }

    public List<Admin> select(){
        String sql="SELECT * FROM TB_ADMIN";
        return Dao.query(sql,Admin.class);
    }

    public void insert(Admin admin){
        String sql="INSERT INTO TB_ADMIN(ADMIN_NAME,REAL_NAME,PASSWORD,ACCESS_COUNT,OPERATOR,CREATE_TIME) VALUES(?,?,md5(?),?,?,now())";
        Dao.executeSql(sql,admin.getAdminName(),admin.getRealName(),admin.getPassword(),0,admin.getOperator());
    }
    public void delete(Integer id){
        String sql="DELETE FROM TB_ADMIN WHERE ADMIN_ID = ?";
        Dao.executeSql(sql,id);
    }
}
