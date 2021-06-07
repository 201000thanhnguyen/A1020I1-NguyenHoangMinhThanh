package models.repository.impl;

import models.bean.Service;
import models.repository.ConnectRepository;
import models.repository.IServiceRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryy implements IServiceRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<Service> listInService() {
        try {
            List<Service> serviceList = new ArrayList<>();
            CallableStatement callableStatement =
                    this.connectRepository.getConnection().prepareCall(
                            "call sp_list_service"
                    );

            ResultSet resultSet = callableStatement.executeQuery();
            Service service = null;
            while (resultSet.next()){
                service = new Service(
                        resultSet.getInt("serviceId"),
                        resultSet.getString("serviceName"),
                        resultSet.getInt("serviceArea"),
                        resultSet.getDouble("serviceCost"),
                        resultSet.getInt("serviceMaxPeople"),
                        resultSet.getInt("rentTypeId"),
                        resultSet.getString("rentTypeName"),
                        resultSet.getDouble("rentTypeCost"),
                        resultSet.getInt("serviceTypeId"),
                        resultSet.getString("serviceTypeName"),
                        resultSet.getString("standardRoom"),
                        resultSet.getString("descOtherConvenience"),
                        resultSet.getDouble("poolArea"),
                        resultSet.getInt("numberOfFloors")
                );
                serviceList.add(service);
            }
            return serviceList;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String addInService(Service service) {
        String msg;
        try {
            PreparedStatement preparedStatement =
                    this.connectRepository.getConnection().prepareStatement(
                            "insert into Service values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                    );
            preparedStatement.setInt(1,service.getServiceId());
            preparedStatement.setString(2,service.getServiceName());
            preparedStatement.setInt(3,service.getServiceArea());
            preparedStatement.setDouble(4,service.getServiceCost());
            preparedStatement.setInt(5,service.getServiceMaxPeople());
            preparedStatement.setInt(6,service.getRentTypeId());
            preparedStatement.setInt(7,service.getServiceTypeId());
            preparedStatement.setString(8,service.getStandardRoom());
            preparedStatement.setString(9,service.getDescOtherConvenience());
            preparedStatement.setDouble(10,service.getPoolArea());
            preparedStatement.setInt(11,service.getNumberOfFloors());
            int result = preparedStatement.executeUpdate();
            msg = result != 0 ? "add success" : "add fail";
        }catch (SQLException ex){
            ex.printStackTrace();
            msg = ex.toString();
        }
        return msg;
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(Service service) {
        return null;
    }

    @Override
    public Service detailInService(int id) {
        return null;
    }

    @Override
    public List<Service> findInService(String byName) {
        return null;
    }

    @Override
    public int countInService() {
        return 0;
    }

    @Override
    public List<Service> listLimitInService(int index, int getNumber) {
        return null;
    }
}
