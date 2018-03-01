package org.easybooks.bookstore.dao;

import java.util.List;

import org.easybooks.bookstore.vo.Book;

public interface IBookDAO {
	//ͨ��ͼ�����id�ţ��õ���Ӧ����ͼ��
	public List getBookbyCatalogid(Integer catalogid);
	//��ҳ��ʾͼ��
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	//�õ�ĳ������ͼ�����Ŀ
	public int getTotalbyCatalog(Integer catalogid);
	//����ͼ��
	public List getRequiredBookbyHql(String hql);
	//����ͼ��ŵõ�ͼ��
	public Book getBookbyId(Integer bookid);
}
