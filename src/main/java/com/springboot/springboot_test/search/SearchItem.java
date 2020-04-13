package com.springboot.springboot_test.search;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Setter
@Getter
public class SearchItem {
    private String column;
    private SearchType type;
    private boolean isMinDate;
    private boolean isMaxDate;

    public SearchItem(String column, SearchType type) {
        this.column = column;
        this.type = type;
        this.isMinDate = false;
        this.isMaxDate = false;
    }

    public SearchItem(String column, SearchType type, boolean isMinDate, boolean isMaxDate) {
        this.column = column;
        this.type = type;
        this.isMinDate = isMinDate;
        this.isMaxDate = isMaxDate;
    }
}
