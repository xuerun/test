package com.rxue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author RunXuee
 * @create 2022-03-01 19:04
 * @Description
 */
@Component
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0代表女  1代表男
    private Department department;
    private Date birth;

    public Employee(int id, String lastName, String email, int gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认的日期
        this.birth = new Date();
    }
}
