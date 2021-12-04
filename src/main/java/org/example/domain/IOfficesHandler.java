package org.example.domain;

import java.util.List;

public interface IOfficesHandler {
    public List<Offices> getOffices();
    public boolean createOffices(Offices office);

    public boolean UpdateOffices(Offices office, Integer officeCode);
}
