package org.example.persistence;

import org.example.domain.Employees;
import org.example.domain.IEmployeesHandler;
import org.example.presentation.App;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeesHandler implements IEmployeesHandler {
    private static EmployeesHandler instance;

    public static EmployeesHandler getInstance(){
        if (instance == null) {
            instance = new EmployeesHandler();
        }
        return instance;
    }

    @Override
    public List<Employees> getEmployees() {
        try {
            PreparedStatement stmt = App.connection.prepareStatement("SELECT * FROM employees");
            ResultSet sqlReturnValues = stmt.executeQuery();

            List<Employees> returnValues = new ArrayList<>();

            while (sqlReturnValues.next()){
                returnValues.add(new Employees(
                        sqlReturnValues.getInt(1),
                        sqlReturnValues.getString(2),
                        sqlReturnValues.getString(3),
                        sqlReturnValues.getString(4),
                        sqlReturnValues.getString(5),
                        sqlReturnValues.getInt(6),
                        sqlReturnValues.getInt(7),
                        sqlReturnValues.getString(8)
                        )
                );
            }
            return returnValues;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createEmployees(Employees employee) {
        try {
            PreparedStatement insertStatement = App.connection.prepareStatement(
                    "INSERT INTO employees (lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES (?,?,?,?,?,?,?);");
            insertStatement.setString(1, employee.getLastName());
            insertStatement.setString(2,employee.getFirstName());
            insertStatement.setString(3,employee.getExtension());
            insertStatement.setString(4,employee.getEmail());
            insertStatement.setInt(5,employee.getOfficeCode());
            if (employee.getReportsTo() == null) {
                insertStatement.setNull(6, Types.NULL);
            }
            else {
                insertStatement.setInt(6, employee.getReportsTo());
            }
            insertStatement.setString(7,employee.getJobTitle());

            insertStatement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean UpdateEmployees(Employees employee, Integer employeeNumber) {
        // TODO: need implementation
        return true;
    }

}
