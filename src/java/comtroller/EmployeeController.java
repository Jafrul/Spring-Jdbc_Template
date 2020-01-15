/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comtroller;

import java.util.List;
import model.Employee;
import static org.apache.tomcat.jni.Buffer.address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.EmployeeService;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/add_employee_form")
    public String showform(Model m) {
        m.addAttribute("command", new Employee());
        return "add_employee_form";
    }

    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
    public String addEmployee(ModelMap model,
            @ModelAttribute("emp") Employee employee
    ) {
        System.out.println(employee.getName());

//        double salary_d = Double.parseDouble(salary);
//
//        Employee employee = new Employee();
//
//        employee.setEmployeeId(employeeId);
//        employee.setName(employeeName);
//        employee.setAddress(address);
//        employee.setSalary(salary_d);
        boolean success = false;

        try {
            success = employeeService.addEmployee(employee);
        } catch (Exception e) {
            model.addAttribute("failed_message", "Employee Add failed !");
            return "message";
        }
//        
//         List<Employee> employees = employeeService.listEmployees();
//        model.addAttribute("list",employees);   
//        return "list_employee";

        model.addAttribute("success_message", "Employee Addedd successfully !");

        return "message";

    }

    @RequestMapping(value = "/list_employees", method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        List<Employee> employees = employeeService.listEmployees();
        model.addAttribute("list", employees);

        return "list_employee";
    }

//    public void editEmployee(Scanner scanner) {
//
//        Employee employee;
//
//        employee = getEmployeeFromScanner(scanner);
//
//        Employee employee_old;
//
//        employee_old = getEmployeeByIdFromDB(employee.getEmployeeId());
//
//        if (employee_old == null) {
//
//            System.out.println("Employee Id : " + employee.getEmployeeId() + " not found !");
//        } else {
//
//            boolean successfullyInserted = updateEmployeeInDB(employee);
//
//            if (successfullyInserted) {
//                System.out.println("Employee Id : " + employee.getEmployeeId() + " has been edited successfully !");
//            } else {
//                System.out.println("Failed to update employee");
//            }
//
//        }
//
//    }
//
//    public void deleteEmployee(Scanner scanner) {
//
//        String employeeID;
//
//        employeeID = getEmployeeIDFromScanner(scanner);
//
//        Employee employee_old;
//
//        employee_old = getEmployeeByIdFromDB(employeeID);
//
//        if (employee_old == null) {
//
//            System.out.println("Employee Id : " + employee_old.getEmployeeId() + " not found !");
//        } else {
//
//            boolean successfullyInserted = removeEmployeeFromDB(employee_old);
//
//            if (successfullyInserted) {
//                System.out.println("Employee Id : " + employee_old.getEmployeeId() + " has been deleted successfully !");
//            } else {
//                System.out.println("Failed to delete employee");
//            }
//
//        }
//
//    }
//    public void searchEmployees(Scanner scanner) {
//
//        String searchParameter = getEmployeeNameFromScanner(scanner);
//
//        List<Employee> employees = getEmployeesByNameFromDB(searchParameter);
//
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
//
//    }
//
//    public void totalSalary(Scanner scanner) {
//
//        double totalSalary = countTotalSalaryFromDB();
//
//        System.out.println("============ resulst ================");
//
//        System.out.println("total salary is : " + totalSalary);
//
//        System.out.println("==========================================");
//
//    }
}
