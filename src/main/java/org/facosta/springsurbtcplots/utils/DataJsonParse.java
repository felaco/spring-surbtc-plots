package org.facosta.springsurbtcplots.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.HighchartData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataJsonParse
{
    private final static Logger logger = LoggerFactory.getLogger(DataJsonParse.class);

    public static List<HighchartData> toHighChartData(String jsonString)
    {
        ObjectMapper mapper = new ObjectMapper();
        List<HighchartData> data = new ArrayList<>();
        try
        {
            data = mapper.readValue(jsonString,
                                    mapper.getTypeFactory()
                                          .constructCollectionType(List.class,
                                                                   HighchartData.class));
        } catch (IOException e)
        {
            logger.error("The json String could not be parsed | " + e.getMessage());
        }
        return data;
    }
}
