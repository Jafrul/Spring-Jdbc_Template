/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Scanner;

/**
 *
 * @author User
 */
public interface EmployeeDAO {


    public void addEmployee(Scanner scanner);

    public void editEmployee(Scanner scanner);

    public void listEmployees(Scanner scanner);

    public void searchEmployees(Scanner scanner);

    public void totalSalary(Scanner scanner);

    public void deleteEmployee(Scanner scanner);

}
