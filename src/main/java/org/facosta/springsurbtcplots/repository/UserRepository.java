package org.facosta.springsurbtcplots.repository;

import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String>
{
    UserModel findByUsername(String userName);
}
