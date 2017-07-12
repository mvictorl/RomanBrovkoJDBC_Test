package com.mvictorl.main;

import com.mvictorl.entity.Address;
import com.mvictorl.entity.EmplProj;
import com.mvictorl.entity.Employee;
import com.mvictorl.entity.Project;
import com.mvictorl.service.AddressService;
import com.mvictorl.service.EmplProjService;
import com.mvictorl.service.EmployeeService;
import com.mvictorl.service.ProjectService;
import com.mvictorl.utilities.Util;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mvictorl on 7/11/17.
 */
public class main {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjService emplProjService = new EmplProjService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham street 1");
        address.setPostCode(123456);

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddressId(address.getId());

        Project project = new Project();
        project.setId(1L);
        project.setTitle("Gotham City Police Department Commissioner");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(project.getId());

        try {
            addressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
            emplProjService.add(emplProj);

//            List<Address> addressList = addressService.getAll();
//            List<Employee> employeeList = employeeService.getAll();
//            for (Employee e : employeeList) {
//                System.out.println(e);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
