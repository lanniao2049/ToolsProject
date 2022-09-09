package com.lanniao.java.annotation.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据注解生成相关的sql语言
 */
public class TableCreator {

    public static String createSql(String className){
        try {
            Class<?> clazz = Class.forName(className);
            DBTable dbTable = clazz.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("tableName is null");
                return null;
            }
            String dbName = dbTable.name();
            if (dbName.length()<1){
                dbName = clazz.getName().toUpperCase();
            }
            List<String> columnList = new ArrayList<>();

            for (Field field : clazz.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length<1){
                    continue;
                }
                // 解析注解Integer类型
                if (annotations[0] instanceof SQLInteger){
                    SQLInteger sqlIntegers = (SQLInteger) annotations[0];
                    if(sqlIntegers.name().length()<1){
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlIntegers.name();
                    }
                    columnList.add(columnName+ " int "+getConstraint(sqlIntegers.constraint()));
                }
                // 解析注解String类型
                if (annotations[0] instanceof SQLString){
                    SQLString sqlStrings = (SQLString) annotations[0];
                    if (sqlStrings.name().length()<1){
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlStrings.name();
                    }
                    columnList.add(columnName+" varchar("+sqlStrings.value()+") "+getConstraint(sqlStrings.constraint()));
                }

            }
            StringBuilder sb = new StringBuilder();
            sb.append("create table "+dbName+"(");
            for (String s : columnList) {
                sb.append("\n"+s+",");
            }
            String sql = sb.substring(0,sb.length()-1)+")";
            return sql;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getConstraint(Constraint constraint){
        String cons = "";
        if (!constraint.allowNull()){
            cons += " not null";
        }
        if (constraint.primaryKey()){
            cons += " primary key";
        }
        if (constraint.unique()){
            cons += " unique";
        }
        return cons;
    }

    public static void main(String[] args) {
        String[] arg = {"com.lanniao.java.annotation.database.Member"};
        for (String s : arg) {
            String sql = createSql(s);
            System.out.println(sql);
        }
    }

}
