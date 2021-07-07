package thanh.code.service;

import thanh.code.models.User;

public interface IUserService extends ICRUDService<User> {

    User detailEntityByIdInteger(int id);
}
