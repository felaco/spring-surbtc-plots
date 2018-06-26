package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.HighChart_Integration.HighChartChartConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController
{
    @GetMapping()
    HighChartChartConfig getBaseConfig()
    {
        return new HighChartChartConfig();
    }
}
