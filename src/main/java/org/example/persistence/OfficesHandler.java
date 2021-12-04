package org.example.persistence;

import org.example.domain.Offices;
import org.example.presentation.App;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfficesHandler {
    private static OfficesHandler instance;

    private OfficesHandler(){
    }

    public static OfficesHandler getInstance(){
        if (instance == null) {
            instance = new OfficesHandler();
        }
        return instance;
    }
    public List<Offices> getOffices() {
        try {
            PreparedStatement stmt = App.connection.prepareStatement("SELECT * FROM offices");
            ResultSet sqlReturnValues = stmt.executeQuery();

            List<Offices> returnValues = new ArrayList<>();

            while (sqlReturnValues.next()){
                returnValues.add(new Offices(
                                sqlReturnValues.getInt(1),
                                sqlReturnValues.getString(2),
                                sqlReturnValues.getString(3),
                                sqlReturnValues.getString(4),
                                sqlReturnValues.getString(5),
                                sqlReturnValues.getString(6),
                                sqlReturnValues.getString(7),
                                sqlReturnValues.getString(8),
                                sqlReturnValues.getString(9)
                        )
                );
            }
            return returnValues;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
    public boolean createOffices(Offices office) {
        return true;
    }

    public boolean UpdateOffices(Offices office, Integer officeCode) {
        return true;
    }
}
