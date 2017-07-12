package com.mvictorl.dao;

import com.mvictorl.entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mvictorl on 7/11/17.
 */
public interface EmployeeDao {
    void add(Employee employee) throws SQLException;
    List<Employee> getAll() throws SQLException;
    Employee getById(Long id) throws SQLException;
    void update(Employee employee) throws SQLException;
    void remove(Employee employee) throws SQLException;
}
