package Dao;
import Entity.Category;
import com.oracle.jdbc.util.Dao;

import java.util.List;


public class CategoryDao {

    public List<Category>selectAll(){
        String sql = "select * from tb_category";
        return Dao.queryList(sql,Category.class,new Object[]{});
    }
}
