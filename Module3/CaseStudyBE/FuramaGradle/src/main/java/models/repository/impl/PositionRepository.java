package models.repository.impl;

import models.bean.Position;
import models.repository.ConnectRepository;
import models.repository.IPositionRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<Position> listInRepository() {
        try {
            List<Position> positionList = new ArrayList<>();
            Statement statement =
                    this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Position");
            Position position = null;
            while (resultSet.next()){
                position = new Position(
                  resultSet.getInt("positionId"),
                  resultSet.getString("positionName")
                );
                positionList.add(position);
            }
            return positionList;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String addInRepository(Position position) {
        return null;
    }

    @Override
    public String deleteInRepository(int id) {
        return null;
    }

    @Override
    public String editInRepository(Position position) {
        return null;
    }

    @Override
    public Position detailInRepository(int id) {
        return null;
    }

    @Override
    public List<Position> findInRepository(String byName) {
        return null;
    }

    @Override
    public int countInRepository() {
        return 0;
    }

    @Override
    public List<Position> listLimitInRepository(int index, int getNumber) {
        return null;
    }
}
