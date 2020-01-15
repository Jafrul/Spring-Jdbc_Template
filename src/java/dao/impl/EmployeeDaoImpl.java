/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class EmployeeDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertEmployeeInToDB(Employee employee) {
        boolean successfullyInserted = false;

        String sql = "insert into employee (employeeId,employeeName,address,salary) values('" + employee.getEmployeeId() + "','" + employee.getName() + "','" + employee.getAddress() + "'," + employee.getSalary() + " ) ";

        jdbcTemplate.update(sql, employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getSalary());

        successfullyInserted = true;

        return successfullyInserted;
    }

//     public boolean insertEmployeeInToDB(Employee employee) {
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        boolean successfullyInserted = false;
//
//        try {
//            conn = DBConnection.getConnection();
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "insert into employee (employeeId,employeeName,address,salary) values('" + employee.getEmployeeId() + "','" + employee.getName() + "','" + employee.getAddress() + "'," + employee.getSalary() + " ) ";
//            int count = stmt.executeUpdate(sql);
//
//            if (count > 0) {
//                successfullyInserted = true;
//            }
//
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException se2) {
//                se2.printStackTrace();
//            }
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//                se2.printStackTrace();
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//
//        return successfullyInserted;
//    }
//    
    
    
    
    
    
//     public List<Employee> getAllEmployeeFromDB() {
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        List<Employee> employees = new ArrayList<>();
//
//        try {
//
//            conn = DBConnection.getConnection();
//
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT * FROM employee";
//            rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//
//                Employee employee = new Employee();
//                employee.setAddress(rs.getString("address"));
//                employee.setEmployeeId(rs.getString("employeeId"));
//                employee.setName(rs.getString("employeeName"));
//                employee.setSalary(rs.getDouble("salary"));
//                employees.add(employee);
//
//            }
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException se2) {
//                se2.printStackTrace();
//            }
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//                se2.printStackTrace();
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//
//        return employees;
//    }
    
    public Employee getEmployeeFromDB(int id){
    Employee employee = null;
    
    String sql = "SELECT * FROM Employee where id =" +id;
    employee = (Employee)jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class));

    return employee;
    }
    
        public List<Employee> getAllEmployeeFromDB() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        employees =  jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class));

        return employees;
    }
//    public List<Employee> getAllEmployeeFromDB() {
//
//        List<Employee> employees = new ArrayList<>();
//
//        String sql = "SELECT * FROM employee";
//
//
//        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
//        for (Map row : rows) {
//
//            Employee employee = new Employee();
//            employee.setAddress((String) row.get("address"));
//            employee.setEmployeeId((String) row.get("employeeId"));
//            employee.setName((String) row.get("employeeName"));
//            employee.setSalary((Double) row.get("salary"));
//            employees.add(employee);
//
//        }
//
//        return employees;
//    }
//    public List<Employee> getAllEmployeeFromDB() {
//
//        List<Employee> employees = new ArrayList<>();
//
//        String sql = "SELECT * FROM employee";
//
//        employees = jdbcTemplate.query(sql, new EmployeeMapper());
//
//        return employees;
//    }

    public Employee getEmployeeByIdFromDB(String employeeId) {

        Employee employee = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employee where employeeId=" + employeeId;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                employee = new Employee();
                employee.setAddress(rs.getString("address"));
                employee.setEmployeeId(rs.getString("employeeId"));
                employee.setName(rs.getString("employeeName"));
                employee.setSalary(rs.getDouble("salary"));

            }
        } catch (SQLException se) {

            se.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return employee;
    }

    public boolean updateEmployeeInDB(Employee employee) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        boolean successfullyInserted = false;

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "update employee set employeeName='" + employee.getName() + "',address='" + employee.getAddress() + "',salary=" + employee.getSalary() + " where employeeId= '" + employee.getEmployeeId() + "'";
            int count = stmt.executeUpdate(sql);

            if (count > 0) {
                successfullyInserted = true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return successfullyInserted;

    }

    public boolean removeEmployeeFromDB(Employee employee) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        boolean successfullyInserted = false;

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "delete from employee  where employeeId= '" + employee.getEmployeeId() + "'";
            int count = stmt.executeUpdate(sql);

            if (count > 0) {
                successfullyInserted = true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return successfullyInserted;

    }

    public List<Employee> getEmployeesByNameFromDB(String name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Employee> employees = new ArrayList<>();

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employee where employeeName like '%" + name + "%' ";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Employee employee = new Employee();
                employee.setAddress(rs.getString("address"));
                employee.setEmployeeId(rs.getString("employeeId"));
                employee.setName(rs.getString("employeeName"));
                employee.setSalary(rs.getDouble("salary"));
                employees.add(employee);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return employees;
    }

    public double countTotalSalaryFromDB() {
        Employee employee = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        double totalSalary = 0.0;

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "select sum(salary) from employee ";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String sum = rs.getString(1);
                totalSalary = Double.parseDouble(sum);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return totalSalary;
    }

    private static final class EmployeeMapper implements RowMapper<Employee> {

        @Override

        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

            Employee employee = new Employee();
            employee.setAddress(rs.getString("address"));
            employee.setEmployeeId(rs.getString("employeeId"));
            employee.setName(rs.getString("employeeName"));
            employee.setSalary(rs.getDouble("salary"));

            return employee;

        }

    }

}


