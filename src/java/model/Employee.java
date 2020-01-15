package model;

public class Employee {

    private String employeeId;    
    private String name;
    private String address;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId) {
        this.employeeId = employeeId;

    }

    public Employee(String employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public Employee(String employeeId, String name, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
    }

    public Employee(String employeeId, String name, String address, double salary) {
        System.out.println("Employee constructor called");
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    

}
