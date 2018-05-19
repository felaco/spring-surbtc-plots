package org.facosta.springsurbtcplots.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.facosta.springsurbtcplots.utils.indicatorUtilities.Source;

import java.util.Iterator;
import java.util.List;

@Slf4j
@Getter
@Setter
public class IndicatorCommand
{
    private String indicatorName;
    private String source = Source.CLOSE.toString();
    private List<IndicatorParamCommand> paramCommandList;
    private int index; // only used in UserIndicatorsServiceImp.insertDefaultIndicator()

    public IndicatorCommand(String indicatorName)
    {
        this.indicatorName = indicatorName;
    }

    public IndicatorCommand(String indicatorName, String source, List<IndicatorParamCommand> paramCommandList)
    {
        this.indicatorName = indicatorName;
        this.source = source;
        this.paramCommandList = paramCommandList;
    }

    public IndicatorCommand()
    {
    }

    public String paramToString()
    {
        StringBuilder stringBuilder = new StringBuilder("(");
        Iterator<IndicatorParamCommand> iterator = paramCommandList.iterator();

        while (iterator.hasNext())
        {
            IndicatorParamCommand paramCommand = iterator.next();
            String commaString = ", ";
            if (!iterator.hasNext()) commaString = "";

            String concatString = paramCommand.toBuilderString() + commaString;
            stringBuilder.append(concatString);
        }

        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String toJson()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();

        objectNode.put("indicatorName", indicatorName);
        objectNode.put("source", source.toLowerCase());
        objectNode.put("StringParams", paramToString());
        // number to be put as the id for the buttons indicating the index of the indicator
        // notice that this index is the one from the list storing the indicators not the pk
        // from the database.
        objectNode.put("lastIndicatorIndex", index);

        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (IndicatorParamCommand param : paramCommandList)
            arrayNode.addPOJO(param);

        objectNode.putPOJO("paramsList", arrayNode);

        String temp = "";
        try
        {
            temp = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
        } catch (JsonProcessingException e)
        {
            log.error(e.getMessage());
        }

        return temp;
    }
}
