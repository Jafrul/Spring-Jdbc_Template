//package employeemanagement;
//
//import comtroller.EmployeeController;
//import config.SpringConfig;
//import java.util.List;
//import model.Employee;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class EmployeeManagement {
//
//    public static void main(String[] args) {
//
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//
//        EmployeeController employeeController = ctx.getBean(EmployeeController.class);
//
//        String message;
//
//        message = employeeController.addEmployee("1541", "hasan", "dhaka", "1100");
//
//        System.out.println(message);
//
//        //--------------------
//        List<Employee> employees = employeeController.listEmployees();
//
//        printEmoloyees(employees);
//
//    }
//
//    private static void printEmoloyees(List<Employee> employees) {
//
//        for (Employee employee : employees) {
//            System.out.println("employee id : " + employee.getEmployeeId());
//            System.out.println("employee name : " + employee.getName());
//            System.out.println("employee address : " + employee.getAddress());
//            System.out.println("employee salary : " + employee.getSalary());
//            System.out.println("===================================");
//        }
//
//    }
//
//}
