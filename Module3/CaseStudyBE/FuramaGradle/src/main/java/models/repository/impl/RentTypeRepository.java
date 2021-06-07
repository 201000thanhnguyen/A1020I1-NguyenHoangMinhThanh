package models.repository.impl;

import models.bean.RentType;
import models.repository.ConnectRepository;
import models.repository.IRentTypeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<RentType> listInRepository() {
        try {
            List<RentType> rentTypeList = new ArrayList<>();
            Statement statement =
                    this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from RentType");
            RentType rentType = null;
            while (resultSet.next()) {
                rentType = new RentType(
                        resultSet.getInt("rentTypeId"),
                        resultSet.getString("rentTypeName"),
                        resultSet.getDouble("rentTypeCost")
                );
                rentTypeList.add(rentType);
            }
            return rentTypeList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String addInRepository(RentType rentType) {
        return null;
    }

    @Override
    public String deleteInRepository(int id) {
        return null;
    }

    @Override
    public String editInRepository(RentType rentType) {
        return null;
    }

    @Override
    public RentType detailInRepository(int id) {
        return null;
    }

    @Override
    public List<RentType> findInRepository(String byName) {
        return null;
    }

    @Override
    public int countInRepository() {
        return 0;
    }

    @Override
    public List<RentType> listLimitInRepository(int index, int getNumber) {
        return null;
    }
}
