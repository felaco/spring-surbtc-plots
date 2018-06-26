package org.facosta.springsurbtcplots.repository;


import org.facosta.springsurbtcplots.models.entity.UserIndicator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserIndicatorRepository extends MongoRepository<UserIndicator, String>
{
}
