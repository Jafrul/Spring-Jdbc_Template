/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.impl.EmployeeDaoImpl;
import java.util.List;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class EmployeeService {
    
    
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;
    
    public boolean addEmployee(Employee employee) throws Exception {

        boolean success = false;

        boolean employeeAlreadyExists = checkIfEmployeeAlreadyExists(employee.getEmployeeId());

        if (employeeAlreadyExists) {

            throw new Exception(" Employee Id : " + employee.getEmployeeId() + " already exists !");
        }

        success = employeeDaoImpl.insertEmployeeInToDB(employee);

        return success;
    }

    public boolean editEmployee(Employee employee) throws Exception {
        boolean success = false;
        Employee employee_old;
        employee_old = employeeDaoImpl.getEmployeeByIdFromDB(employee.getEmployeeId());
        if (employee_old == null) {
            throw new Exception("Employee Id : " + employee.getEmployeeId() + " not found !");
        }
        success = employeeDaoImpl.updateEmployeeInDB(employee);

        return success;
    }

    public boolean deleteEmployee(String employeeID) throws Exception {
        boolean success = false;

        Employee employee_old;

        employee_old = employeeDaoImpl.getEmployeeByIdFromDB(employeeID);

        if (employee_old == null) {
            throw new Exception("Employee Id : " + employee_old.getEmployeeId() + " not found !");

        } else {
            success = employeeDaoImpl.removeEmployeeFromDB(employee_old);
        }
        return success;

    }

    public List<Employee> listEmployees() {
        System.out.println("==== result =====");

        List<Employee> employees = employeeDaoImpl.getAllEmployeeFromDB();

        return employees;

//        for (Employee employee : employees) {
//            System.out.println("employee id : " + employee.getEmployeeId());
//            System.out.println("employee name : " + employee.getName());
//            System.out.println("employee address : " + employee.getAddress());
//            System.out.println("employee salary : " + employee.getSalary());
//            System.out.println("===================================");
//        }
    }

    public List<Employee> searchEmployees(String searchParameter) {

        List<Employee> employees = employeeDaoImpl.getEmployeesByNameFromDB(searchParameter);

//        System.out.println("==== result =====");
//
//        for (Employee employee : employees) {
//
//            System.out.println("employee id : " + employee.getEmployeeId());
//            System.out.println("employee name : " + employee.getName());
//            System.out.println("employee address : " + employee.getAddress());
//            System.out.println("employee salary : " + employee.getSalary());
//            System.out.println("===================================");
//
//        }
        return employees;
    }

    public double totalSalary() {

        double totalSalary = employeeDaoImpl.countTotalSalaryFromDB();

        return totalSalary;

    }

    private boolean checkIfEmployeeAlreadyExists(String employeeId) {

        boolean employeeAlreadyExists = false;

        Employee employee = null;

        employee = employeeDaoImpl.getEmployeeByIdFromDB(employeeId);

        if (employee != null) {

            employeeAlreadyExists = true;
        }

        return employeeAlreadyExists;
    }

   
}
