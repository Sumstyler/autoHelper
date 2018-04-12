package base;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private int page = 1;// 当前页数
	private long pageCount;// 总记录数
	@SuppressWarnings("unused")
	private int pages;// 总页数
	private int pageSize = 10;// 每页显示的记录数
	private List<T> rows = new ArrayList<T>();// 每页显示数据的集合

	@SuppressWarnings("unused")
	private int start;
	private int end;

	public PageBean() {

	}

	public PageBean(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page <= 0 ? 1 : page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getPages() {
		long t = pageCount % pageSize;
		if (t == 0) {
			return pageCount / pageSize;
		} else {
			return pageCount / pageSize + 1;
		}
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageSize() {
		return pageSize < 1 ? 10 : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getStart() {
		return (getPage() - 1) * this.pageSize;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
