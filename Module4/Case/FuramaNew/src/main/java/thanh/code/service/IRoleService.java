package thanh.code.service;

import thanh.code.models.Role;

public interface IRoleService extends ICRUDService<Role> {

    Iterable<Role> roleIterable();
}
