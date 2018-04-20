package org.facosta.springsurbtcplots.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.HighchartData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataJsonParse
{
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
            e.printStackTrace();
        }
        return data;
    }
}
