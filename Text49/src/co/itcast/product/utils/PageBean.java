package co.itcast.product.utils;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
	
	//起始索引（计算得来）
	private int startIndex;
	
	//数据以几条显示在页面（前端给定的一般都是规定好的数据）
	private int pageSeiz;
	
	//网页传递的查询第几页信息
	private int pageNumber;
	
	//数据库一共几条该类的信息
	private int pageCount;
	
	//页面中总共显示几个分页（计算的来）
	private int totalPage;
	
	//将查询出来的信息保存到集合中
	private List<T> list;

	public int getStartIndex() {
		return (this.getPageNumber()-1)*this.getPageSeiz();
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSeiz() {
		return pageSeiz;
	}

	public void setPageSeiz(int pageSeiz) {
		this.pageSeiz = pageSeiz;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalPage() {
		return this.getPageCount() % this.getPageSeiz()==0 ? (this.getPageCount()/this.getPageSeiz()):
				(this.getPageCount()/this.getPageSeiz()+1);
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public PageBean() {

	}
}
