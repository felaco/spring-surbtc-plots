package org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces;

import org.facosta.springsurbtcplots.models.entity.Indicator;

import java.util.List;

public interface IndicatorsService
{
    List<Indicator> findAllIndicators();
}
