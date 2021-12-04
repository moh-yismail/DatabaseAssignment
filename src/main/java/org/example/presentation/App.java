package org.example.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.persistence.EmployeesHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App extends Application {
    private String url = "localhost";
    private int port = 3306;
    private String databaseName = "db_baraa";
    private String username = "root";
    private String password = "root";
    public static Connection connection = null;

    @Override
    public void start(Stage primaryStage) throws IOException {
        initializePostgresqlDatabase();
        Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private void initializePostgresqlDatabase() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "/" + databaseName, username, password);
            System.out.println("DB connected");
        } catch (SQLException | IllegalArgumentException ex) {
            ex.printStackTrace(System.err);
        } finally {
            if (connection == null) {
                System.exit(-1);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }

}