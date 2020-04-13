package com.springboot.springboot_test.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.springboot_test.anno.Query;
import com.springboot.springboot_test.query.QueryBuild;
import com.springboot.springboot_test.query.SimpleDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author fanhaoming
 * @Description TODO
 * @Version
 **/
public abstract class BaseCondition {

	private Boolean noPage = true;

	private Integer page;

	private Integer pageSize;

	@Query(isMinDate = true, column = "create_time", type = QueryBuild.GREATER_EQUAL_QUERY_TYPE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonSerialize(using = SimpleDateSerializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;

	@Query(isMaxDate = true, column = "create_time", type = QueryBuild.LESS_EQUAL_QUERY_TYPE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonSerialize(using = SimpleDateSerializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;

	@Query(isMinDate = true, column = "update_time", type = QueryBuild.GREATER_EQUAL_QUERY_TYPE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonSerialize(using = SimpleDateSerializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateStart;

	@Query(isMaxDate = true, column = "update_time", type = QueryBuild.LESS_EQUAL_QUERY_TYPE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonSerialize(using = SimpleDateSerializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateEnd;

	public Boolean getNoPage() {
		return noPage;
	}

	public void setNoPage(Boolean noPage) {
		this.noPage = noPage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	public Date getUpdateStart() {
		return updateStart;
	}

	public void setUpdateStart(Date updateStart) {
		this.updateStart = updateStart;
	}

	public Date getUpdateEnd() {
		return updateEnd;
	}

	public void setUpdateEnd(Date updateEnd) {
		this.updateEnd = updateEnd;
	}

	private List<String> sortColumn;

	public List<String> getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(List<String> sortColumn) {
		this.sortColumn = sortColumn;
	}

	public void setSearchUpdateTime(){
		
		this.updateStart = this.start;
		this.updateEnd = this.end;
		
		this.start = null;
		this.end = null;
	}
	
}
