package models.repository.impl;

import com.mysql.cj.xdevapi.SqlDataResult;
import models.bean.Ground;
import models.repository.ConnectRepository;
import models.repository.IGroundRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroundRepository implements IGroundRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<Ground> listInRepository() {
        List<Ground> groundList = new ArrayList<>();
        try {
            Statement statement =
                    this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select gr.*, grS.groundStatusName, grT.groundTypeName from Ground gr\n" +
                    "inner join GroundStatus grS on gr.groundStatusId = grS.groundStatusId  \n" +
                    "inner join GroundType grT on gr.groundTypeId = grT.groundTypeId order by gr.groundAcreage asc");

            Ground ground;
            while (resultSet.next()){
                ground = new Ground(
                    resultSet.getString("groundId"),
                        resultSet.getInt("groundStatusId"),
                        resultSet.getString("groundStatusName"),
                        resultSet.getDouble("groundAcreage"),
                        resultSet.getInt("groundFloor"),
                        resultSet.getInt("groundTypeId"),
                        resultSet.getString("groundTypeName"),
                        resultSet.getDouble("groundCost"),
                        resultSet.getString("groundStartDate"),
                        resultSet.getString("groundEndDate")
                );
                groundList.add(ground);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return groundList;
    }

    @Override
    public String addInRepository(Ground ground) {
        return null;
    }

    @Override
    public String deleteInRepository(String id) {
        String msg;
        try {
            PreparedStatement preparedStatement =
                    this.connectRepository.getConnection().prepareStatement(
                            "delete from Ground where groundId = ?"
                    );
            preparedStatement.setString(1,id);
            int result = preparedStatement.executeUpdate();
            return msg = result > 0 ? "delete success" : "delete fail";
        }catch (SQLException ex){
            ex.printStackTrace();
            msg = ex.toString();
        }
        return msg;
    }

    @Override
    public String editInRepository(Ground ground) {
        return null;
    }

    @Override
    public Ground detailInRepository(int id) {
        return null;
    }

    @Override
    public List<Ground> findInRepository(String byName) {
        return null;
    }

    @Override
    public int countInRepository() {
        return 0;
    }

    @Override
    public List<Ground> listLimitInRepository(int index, int getNumber) {
        return null;
    }
}
