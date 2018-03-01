package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Book;

public interface IBookService {
	//ͨ��ͼ�����id�ţ��õ���Ӧ����ͼ��
	public List getBookbyCatalogid(Integer catalogid);
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	public int getTotalbyCatalog(Integer catalogid);
	public List getRequiredBookbyHql(String hql);
	//����ͼ��ŵõ�ͼ��
	public Book getBookbyId(Integer bookid);
}
