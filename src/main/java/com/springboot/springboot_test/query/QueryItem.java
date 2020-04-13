package com.springboot.springboot_test.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author fanhaoming
 * @Description TODO
 * @Version
 **/
@Setter
@Getter
public class QueryItem {

	private String column;
	private Object value;
	private String type;
	private boolean isMinDate;
	private boolean isMaxDate;
	
	public QueryItem(String column, Object value, String type){
		this.column = column;
		this.value = value;
		this.type = type;
		this.isMinDate = false;
		this.isMaxDate = false;
	}

	public QueryItem(String column, Object value, String type,boolean isMinDate,boolean isMaxDate){
		this.column = column;
		this.value = value;
		this.type = type;
		this.isMinDate = isMinDate;
		this.isMaxDate = isMaxDate;
	}


}
