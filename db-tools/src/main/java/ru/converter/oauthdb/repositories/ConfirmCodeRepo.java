package ru.converter.oauthdb.repositories;


import org.springframework.data.repository.CrudRepository;
import ru.converter.oauthdb.domains.ConfirmCode;

import java.util.UUID;

public interface ConfirmCodeRepo extends CrudRepository<ConfirmCode, UUID> {


}
