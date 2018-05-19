package org.facosta.springsurbtcplots.repository;

import org.facosta.springsurbtcplots.models.entity.Indicator;
import org.springframework.data.repository.CrudRepository;

public interface IndicatorRepository extends CrudRepository<Indicator, Long>
{
    public Indicator findByIndicatorName(String indicatorName);
}
