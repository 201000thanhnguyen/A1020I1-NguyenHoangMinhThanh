package models.repository.impl;

import models.bean.Division;
import models.repository.ConnectRepository;
import models.repository.IDivisionRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<Division> listInRepository() {
        try {
            List<Division> divisionList = new ArrayList<>();
            Statement statement =
                    this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Division");
            Division division = null;
            while (resultSet.next()){
                division = new Division(
                        resultSet.getInt("divisionId"),
                        resultSet.getString("divisionName")
                );
                divisionList.add(division);
            }
            return divisionList;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String addInRepository(Division division) {
        return null;
    }

    @Override
    public String deleteInRepository(int id) {
        return null;
    }

    @Override
    public String editInRepository(Division division) {
        return null;
    }

    @Override
    public Division detailInRepository(int id) {
        return null;
    }

    @Override
    public List<Division> findInRepository(String byName) {
        return null;
    }

    @Override
    public int countInRepository() {
        return 0;
    }

    @Override
    public List<Division> listLimitInRepository(int index, int getNumber) {
        return null;
    }
}
