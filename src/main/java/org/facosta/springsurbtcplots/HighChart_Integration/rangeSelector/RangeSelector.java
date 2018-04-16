package org.facosta.springsurbtcplots.HighChart_Integration.rangeSelector;

import java.util.ArrayList;
import java.util.List;

public class RangeSelector
{
    private int selected;
    private List<Button> buttons = new ArrayList<>();

    public RangeSelector(int selected, List<Button> buttons)
    {
        this.selected = selected;
        this.buttons = buttons;
    }

    public RangeSelector(List<Button> buttons)
    {
        selected = 0;
        this.buttons = buttons;
    }

    public RangeSelector()
    {
        selected = 0;
        buttons.add(new Button(Type.DAY));
        buttons.add(new Button(Type.DAY, 7));
        buttons.add(new Button(Type.MONTH));
        buttons.add(new Button(Type.YEAR));
    }

    public int getSelected()
    {
        return selected;
    }

    public void setSelected(int selected)
    {
        this.selected = selected;
    }

    public List<Button> getButtons()
    {
        return buttons;
    }

    public void setButtons(List<Button> buttons)
    {
        this.buttons = buttons;
    }

    @Override
    public String toString()
    {
        return "RangeSelector{" +
                "selected=" + selected +
                ", buttons=" + buttons +
                '}';
    }
}
