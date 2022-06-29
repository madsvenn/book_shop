package Service;

import Dao.CategoryDao;
import Entity.Category;

import java.util.List;


public class CategoryService {
    CategoryDao dao = new CategoryDao();

    public List<Category> getAll(){

        return dao.selectAll();
    }
}
