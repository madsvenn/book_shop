1.������jar���ŵ����̵�web-info/lib�£�
2.��db.properties���õ�src�£�
3.ʹ��Dao�ľ�̬�����������ݿ���в�����

Service��ʾ��
public class BookService {

	BookDao dao=new BookDao();
	@Transactional
	public void save() {
		dao.save("�ҵ���", 12);
		dao.save("�ҵ���3", 123);
	}
}

������ʾ��
BookService s=ServiceFactory.getObject(BookService.class);
s.save();