package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.HighChart_Integration.ChartConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController
{
    @GetMapping()
    ChartConfig getBaseConfig()
    {
        return new ChartConfig();
    }
}
