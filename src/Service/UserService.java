package Service;

import Dao.UserDao;
import Entity.User;
import com.oracle.jdbc.util.Transactional;

import java.util.List;

public class UserService {
    UserDao dao=new UserDao();
    public List<User> getUser(){
        return dao.selectAll();
    }

    @Transactional
    public void insert(User user){
        dao.insert(user);
    }

    @Transactional
    public void delete(Integer ID){
        dao.delete(ID);
    }
}
