package com.springboot.springboot_test.anno;

import com.springboot.springboot_test.query.QueryBuild;
import com.springboot.springboot_test.search.SearchItem;
import com.springboot.springboot_test.search.SearchType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Query {
    SearchType type() default SearchType.EQUAL_QUERY_TYPE;
    String column() default "";
    boolean isMinDate() default false;
    boolean isMaxDate() default false;
}
