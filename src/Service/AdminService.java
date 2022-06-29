package Service;

import Dao.AdminDao;
import Entity.Admin;
import com.oracle.jdbc.util.Transactional;

import java.util.List;

public class AdminService {

    AdminDao aDao=new AdminDao();
    @Transactional
    public Admin login(String adminName, String password){

        Admin admin=aDao.selectAdminByPassword(adminName,password);
        if(admin!=null){
            aDao.updateLoginInfo(admin.getAdminID());
        }
        return admin;
    }

    @Transactional
    public void save(Admin admin){
        aDao.insert(admin);
    }

    @Transactional
    public void delete(Integer adminId){
        aDao.delete(adminId);
    }

    @Transactional
    public List<Admin> getAll(){
        return aDao.select();
    }


}
