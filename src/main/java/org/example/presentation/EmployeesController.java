package org.example.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import org.example.domain.Employees;
import org.example.domain.IEmployeesHandler;
import org.example.domain.Offices;
import org.example.persistence.EmployeesHandler;
import org.example.persistence.OfficesHandler;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeesController implements Initializable {

    IEmployeesHandler employeesHandler = EmployeesHandler.getInstance();
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField extension;

    @FXML
    private TextField email;

    @FXML
    private MenuButton officeCode;

    @FXML
    private MenuButton reportsTo;

    @FXML
    private TextField jobTitle;
    @FXML
    private TableView<Employees> employeesTableView;

    private Integer officeSelected;
    private Integer reportsToSelected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Employees> employeesList = employeesHandler.getEmployees();
        employeesTableView.getItems().addAll(employeesList);
        List<Offices> offices = OfficesHandler.getInstance().getOffices();

        employeesList.forEach(empolyee -> {
            String reportToStr = String.format(
                    "%s %s",empolyee.getFirstName(), empolyee.getLastName());
            MenuItem menuItem = new MenuItem(reportToStr);
            menuItem.setOnAction(a->{
                reportsToSelected = empolyee.getEmployeeNumber();
                reportsTo.setText(reportToStr);
            });
            reportsTo.getItems().add(menuItem);
        });
        offices.forEach(office -> {
            MenuItem menuItem = new MenuItem(office.getCity());
            menuItem.setOnAction(a->{
                officeSelected = office.getOfficeCode();
                officeCode.setText(office.getCity());
            });
            officeCode.getItems().add(menuItem);
        });

    }

    @FXML
    void addEmployee(ActionEvent event) {
        Employees employee = new Employees(
                null,
                lastName.getText(),
                firstName.getText(),
                extension.getText(),
                email.getText(),
                officeSelected,
                reportsToSelected,
                jobTitle.getText()
                );
        if(employeesHandler.createEmployees(employee)){
            System.out.println("Friend inserted into database");
        } else {
            System.out.println("Something went wrong");
        }
        updateUI();
    }

    private void updateUI(){
        lastName.clear();
        firstName.clear();
        extension.clear();
        email.clear();
        officeCode.disarm();
        jobTitle.clear();
        employeesTableView.getItems().clear();
        employeesTableView.getItems().addAll(employeesHandler.getEmployees());
    }

}
