package org.facosta.springsurbtcplots.repository;

import org.facosta.springsurbtcplots.models.entity.SupportedIndicators;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupportedIndicatorsRepository extends MongoRepository<SupportedIndicators, String>
{
}
