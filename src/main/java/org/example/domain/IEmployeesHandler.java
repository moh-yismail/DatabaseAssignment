package org.example.domain;

import java.util.List;

public interface IEmployeesHandler {

    public List<Employees> getEmployees();

    public boolean createEmployees(Employees employee);

    public boolean UpdateEmployees(Employees employee, Integer employeeNumber);
}
