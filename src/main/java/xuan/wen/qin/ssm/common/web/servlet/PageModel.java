package xuan.wen.qin.ssm.common.web.servlet;

import java.io.Serializable;
import java.util.List;

/**
 * PageModel<br>
 * 
 * @Remark 计算分页
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月27日下午3:59:18
 * @Version 1.0
 * @Address by siShangJie
 */
public class PageModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 定义默认每页显示的记录数 */
	private static final int PAGE_SIZE = 12;
	/** 当前页数 */
	private Integer pageIndex = 1;
	/** 分页条数 */
	private Integer pageSize = 0;
	/** 总页数 */
	private Integer pageTotal;
	/** 总条数 */
	private Integer total;
	/** 结果集 **/
	private List<T> dataColl;

	/** constructor */
	public PageModel() {
		super();
	}

	/** proeprties */
	public Integer getPageIndex() {
		/** 当前页码不能小于1,小于1取第一页 */
		this.pageIndex = pageIndex <= 1 ? 1 : pageIndex;
		/** 当前页码不能大于总页数 , 大于总页数 , 取最后一页 */
		return (this.pageIndex > this.getPageTotal()) ? this.getPageTotal()
				: this.pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return (this.pageSize <= 0) ? PAGE_SIZE : this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		/** 计算总页数 */
		boolean falg = (0 == (this.getTotal() % this.getPageSize()));
		int temp = this.getTotal() / this.getPageSize();
		this.pageTotal = (falg ? temp : (temp + 1));
		return this.pageTotal;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getDataColl() {
		return dataColl;
	}

	public void setDataColl(List<T> dataColl) {
		this.dataColl = dataColl;
	}

	/** limit第一个问号的值 */
	public int getStartRow() {
		return (this.getPageIndex() - 1) * this.getPageSize();
	}

	@Override
	public String toString() {
		return "PageModel [pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", pageTotal=" + pageTotal + ", total=" + total
				+ ", dataColl=" + dataColl + "]";
	}
}
