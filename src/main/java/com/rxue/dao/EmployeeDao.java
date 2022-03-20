package com.rxue.dao;

import com.rxue.pojo.Department;
import com.rxue.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RunXue
 * @create 2022-03-01 19:23
 * @Description
 */
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "AA", "A15664654@qq.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "B15664654@qq.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "C15664654@qq.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "D15664654@qq.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "E15664654@qq.com", 1, new Department(105, "后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;

    public void add(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
