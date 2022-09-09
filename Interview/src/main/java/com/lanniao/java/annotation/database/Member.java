package com.lanniao.java.annotation.database;

@DBTable(name = "member")
public class Member {
    @SQLString(name = "id",value = 50,constraint = @Constraint(primaryKey = true))
    private String id;
    @SQLString(name = "name",value = 30)
    private String name;
    @SQLInteger(name = "age")
    private int age;
    @SQLString(name = "description",value = 200,constraint = @Constraint(allowNull = true))
    private String description;
}
