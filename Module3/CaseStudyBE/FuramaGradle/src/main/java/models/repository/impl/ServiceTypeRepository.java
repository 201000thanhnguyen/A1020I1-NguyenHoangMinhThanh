package models.repository.impl;

import models.bean.ServiceType;
import models.repository.ConnectRepository;
import models.repository.IServiceTypeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<ServiceType> listInRepository() {
        try {
            List<ServiceType> serviceTypeList = new ArrayList<>();
            Statement statement =
                    this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ServiceType");
            ServiceType serviceType = null;
            while (resultSet.next()){
                serviceType = new ServiceType(
                  resultSet.getInt("serviceTypeId"),
                  resultSet.getString("serviceTypeName")
                );
                serviceTypeList.add(serviceType);
            }
            return serviceTypeList;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String addInRepository(ServiceType serviceType) {
        return null;
    }

    @Override
    public String deleteInRepository(int id) {
        return null;
    }

    @Override
    public String editInRepository(ServiceType serviceType) {
        return null;
    }

    @Override
    public ServiceType detailInRepository(int id) {
        return null;
    }

    @Override
    public List<ServiceType> findInRepository(String byName) {
        return null;
    }

    @Override
    public int countInRepository() {
        return 0;
    }

    @Override
    public List<ServiceType> listLimitInRepository(int index, int getNumber) {
        return null;
    }
}
