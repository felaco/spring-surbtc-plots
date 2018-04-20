package org.facosta.springsurbtcplots.HighChart_Integration.rangeSelector;

public class Button
{
    private String type;
    private int count;
    private String text;

    public Button(Type type, int count, String text)
    {
        this.type = type.getTypeStr();
        this.count = count;
        this.text = text;
    }

    public Button(Type type, int count)
    {
        this(type, count, type.toString());
    }

    public Button(Type type)
    {
        this(type, 1, type.toString());
    }

    public String getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type.getTypeStr();
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return "Button{" +
                "type=" + type +
                ", count=" + count +
                ", text='" + text + '\'' +
                '}';
    }
}
