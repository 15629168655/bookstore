package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.IBookDAO;
import org.easybooks.bookstore.service.IBookService;
import org.easybooks.bookstore.vo.Book;

public class BookService implements IBookService{
	private IBookDAO bookDAO;      //Ϊ��ʹ��DAO��������õ�����
	//ͨ��ͼ�����id�ţ��õ���Ӧ����ͼ��
	public List getBookbyCatalogid(Integer catalogid) {
		return bookDAO.getBookbyCatalogid(catalogid);
	}
	//����ͼ��������id�õ���ҳͼ��
	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize) {
		return bookDAO.getBookbyCatalogidPaging(catalogid, currentPage, pageSize);
	}
	//����ͼ������õ�����ͼ�����Ŀ
	public int getTotalbyCatalog(Integer catalogid) {
		return bookDAO.getTotalbyCatalog(catalogid);
	}
	//����ͼ��
	public List getRequiredBookbyHql(String hql) {
		return bookDAO.getRequiredBookbyHql(hql);
	}
	public Book getBookbyId(Integer bookid) {
		return bookDAO.getBookbyId(bookid);
	}
	public IBookDAO getBookDAO() {
		return bookDAO;
	}
	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
}
