1.将三个jar包放到工程的web-info/lib下；
2.将db.properties放置到src下；
3.使用Dao的静态方法来对数据库进行操作；

Service类示例
public class BookService {

	BookDao dao=new BookDao();
	@Transactional
	public void save() {
		dao.save("我的书", 12);
		dao.save("我的书3", 123);
	}
}

测试类示例
BookService s=ServiceFactory.getObject(BookService.class);
s.save();