package org.facosta.springsurbtcplots.repository;

import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long>
{
    UserModel findByUsername(String userName);
}
