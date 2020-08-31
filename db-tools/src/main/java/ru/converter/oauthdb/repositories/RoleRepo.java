package ru.converter.oauthdb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.converter.oauthdb.domains.user.Role;

public interface RoleRepo extends CrudRepository<Role, String> {

}
