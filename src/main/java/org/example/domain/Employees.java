package org.example.domain;

public class Employees {
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private Integer officeCode;
    private Integer reportsTo;
    private String jobTitle;

    public Employees(
            Integer employeeNumber,
            String lastName,
            String firstName,
            String extension,
            String email,
            Integer officeCode,
            Integer reportsTo,
            String jobTitle
    ) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() { return firstName; }
    public String getExtension() { return extension; }
    public String getEmail() { return email; }
    public Integer getOfficeCode() { return officeCode; }
    public Integer getReportsTo() { return reportsTo; }
    public String getJobTitle() { return jobTitle; }
}
