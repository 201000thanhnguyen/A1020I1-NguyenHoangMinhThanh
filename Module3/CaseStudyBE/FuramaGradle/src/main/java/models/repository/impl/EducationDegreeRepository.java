package models.repository.impl;

import models.bean.EducationDegree;
import models.repository.ConnectRepository;
import models.repository.IEducationDegreeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<EducationDegree> listInRepository() {
        try {
            List<EducationDegree> educationDegreeList = new ArrayList<>();
            Statement statement =
                    this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from EducationDegree");
            EducationDegree educationDegree = null;
            while (resultSet.next()){
                educationDegree = new EducationDegree(
                        resultSet.getInt("educationDegreeId"),
                        resultSet.getString("educationDegreeName")
                );
                educationDegreeList.add(educationDegree);
            }
            return educationDegreeList;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String addInRepository(EducationDegree educationDegree) {
        return null;
    }

    @Override
    public String deleteInRepository(int id) {
        return null;
    }

    @Override
    public String editInRepository(EducationDegree educationDegree) {
        return null;
    }

    @Override
    public EducationDegree detailInRepository(int id) {
        return null;
    }

    @Override
    public List<EducationDegree> findInRepository(String byName) {
        return null;
    }

    @Override
    public int countInRepository() {
        return 0;
    }

    @Override
    public List<EducationDegree> listLimitInRepository(int index, int getNumber) {
        return null;
    }
}
