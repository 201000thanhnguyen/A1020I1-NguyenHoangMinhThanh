package Models.repository.impl;

import Models.bean.User;
import Models.repository.BaseRepository;
import Models.repository.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<User> listUser() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setNameUser(resultSet.getString("nameUser"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public String addUser(User user) {
        int msg = 0;
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(
                            "insert into users (nameUser, email, country) values (?,?,?)"
                    );
            preparedStatement.setString(1, user.getNameUser());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            msg = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg != 0 ? "add success" : "add fail";
    }

    @Override
    public String deleteUser(int id)
    {
        int msg = 0;
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(
                      "delete from users where id = ?"
                    );
            preparedStatement.setInt(1, id);
            msg = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg != 0 ? "delete success" : "delete fail";
    }

    @Override
    public String editUser(User user) {
        int msg = 0;
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(
                            "update users set nameUser = ?, email = ?, country = ? where id = ?"
                    );
            preparedStatement.setString(1, user.getNameUser());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            msg = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg != 0 ? "edit success" : "edit fail";
    }

    @Override
    public User detailUser(int id) {
        try {
            User user = new User();
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement("select * from users where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setNameUser(resultSet.getString("nameUser"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
