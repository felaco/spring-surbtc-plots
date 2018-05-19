package org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces;

import org.facosta.springsurbtcplots.models.entity.Indicator;
import org.facosta.springsurbtcplots.repository.IndicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndicatorsServiceImpl implements IndicatorsService
{
    private IndicatorRepository indicatorRepository;

    @Autowired
    public IndicatorsServiceImpl(IndicatorRepository indicatorRepository)
    {
        this.indicatorRepository = indicatorRepository;
    }

    @Override
    public List<Indicator> findAllIndicators()
    {
        List<Indicator> indicatorList = new ArrayList<>();
        indicatorRepository.findAll().forEach(indicatorList::add);
        return indicatorList;
    }
}
