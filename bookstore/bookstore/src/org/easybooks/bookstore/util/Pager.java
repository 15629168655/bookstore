package org.easybooks.bookstore.util;

public class Pager {
	private int currentPage;//当前页面
	private int pageSize = 3;//每页的记录数，此处赋了一个初始值
	private int totalSize;//总的记录数
	private int totalPage;//总的页数，由总的记录数除以每页的记录数得到
	
	private boolean hasFirst;//是否有第一页
	private boolean hasPrevious;//是否有上一页
	private boolean hasNext;//是否有下一页
	private boolean hasLast;//是否有最后一页
	public Pager(int currentPage, int totalSize) {
		this.currentPage = currentPage;
		this.totalSize = totalSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getTotalPage() {
		totalPage = totalSize/pageSize;
		if(totalSize%pageSize!=0)
			totalPage++;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	//判断当前页是否为1，若是，则没有首页
	public boolean isHasFirst(){
		if(currentPage==1){
			return false;
		}
		return true;
	}
	public void setHasFirst(boolean hasFirst){
		this.hasFirst=hasFirst;
	}
	
	public boolean isHasPrevious() {
		if(isHasFirst()){
			return true;
		}
		else{
			return false;
		}
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public boolean isHasNext() {
		if(isHasLast())
			return true;
		else
			return false;
	}
	public void setHasNext(boolean hasnext) {
		this.hasNext = hasnext;
	}
	public boolean isHasLast() {
		if(currentPage==getTotalPage())
			return false;
		else
			return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
}
