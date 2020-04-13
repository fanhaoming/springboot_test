package com.springboot.springboot_test.query;


import com.springboot.springboot_test.base.BaseCondition;

/**
 * @author fanhaoming
 * @Description TODO
 * @Version
 **/
public class PageHelp {

	private static final int DEFAULT_PAGE_SIZE = 15;

	public static int getPageSize(BaseCondition condition) {
		int pageSize = 0;
		if (condition.getPageSize() == null || condition.getPageSize() == 0) {
			pageSize = DEFAULT_PAGE_SIZE;
		} else {
			pageSize = condition.getPageSize();
		}
		return pageSize;
	}

	public static int getStartIndex(BaseCondition condition) {
		int pageSize = getPageSize(condition);
		int start = 0;
		if (condition.getPage() == null || condition.getPage() == 0) {
			start = 0;
		} else {
			start = (condition.getPage() - 1) * pageSize;
		}
		
		if (condition.getNoPage()) {
			start = -1;
		}
		
		return start;
	}

	public static int getPageIndex(BaseCondition condition) {
		int pageIndex = 0;
		if (condition.getPage() == null || condition.getPage() == 0) {
			pageIndex = 1;
		} else {
			pageIndex = condition.getPage();
		}
		return pageIndex;
	}
}
