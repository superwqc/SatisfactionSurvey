package satisfactionSurvey.domain;

import java.util.List;

public class Page {
	private int p;//当前页
	private int prev;//上一页
	private int next;//下一页
	private int rowCount;//总行数
	private int maxPage;//总页数
	private int size;//每页行数
	private int startPage;//起始页
	private int endPage;//结束页
	private int startLine;//起始行
	private List list;//分页数据
	
	public Page(int p_,int rowCount_,int size_) {
		p=p_;
		rowCount=rowCount_;
		size=size_;
		
		maxPage=(int) Math.ceil(rowCount*1.0 / size);
		
		if(p>maxPage)p=maxPage;
		if(p<1)p=1;
		
		prev=p-1;
		next=p+1;
		
		startLine=(p-1)*size;
		
	}
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
 	

}
