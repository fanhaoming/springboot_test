package com.springboot.springboot_test.search;

import com.springboot.springboot_test.anno.Query;
import com.springboot.springboot_test.query.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

public class SearchBuild {

    private static Map<String,SearchItem> createBuild(Class clazz) {
        Map<String,SearchItem> map = new HashMap<>();

        Field[] fields = clazz.getDeclaredFields();
        String column = "";
        for (Field field : fields) {
            field.setAccessible(true);
            Query annotation = field.getAnnotation(Query.class);
            if (annotation != null) {
                column = annotation.column();
                if (StringHelper.IsNullOrEmpty(column)) {
                    column = PropertyNameConvert.propertyToColumn(field.getName());
                }
                map.put(field.getName(),new SearchItem(column,annotation.type(),annotation.isMaxDate(),annotation.isMinDate()));
            }
        }

        while(true){
            clazz = clazz.getSuperclass();
            if(clazz.equals(Object.class)){
                break;
            }

            fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Query annotation = field.getAnnotation(Query.class);
                if (annotation != null) {
                    column = annotation.column();
                    if (StringHelper.IsNullOrEmpty(column)) {
                        column = PropertyNameConvert.propertyToColumn(field.getName());
                    }
                    map.put(field.getName(),new SearchItem(column,annotation.type(),annotation.isMaxDate(),annotation.isMinDate()));
                }
            }
        }
        if(map.isEmpty())
            map = null;
        return map;
    }
}
