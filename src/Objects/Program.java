package Objects;

import java.util.ArrayList;
import java.util.List;

public class Program 
{
    private String name;
    private List<SearchLine> lines;

    public Program(String name) 
    {
        this.name = name;
        this.lines = new ArrayList<SearchLine>();
    }
    
    public Program()
    {
        this("");
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public void addLine(SearchLine line) 
    {
        lines.add(line);
    }
    
    public int countSearchLines() 
    {
        return lines.size();
    }

    public Iterable<SearchLine> getLinhas() 
    {
        return lines;
    }
    
    public SearchLine getSearchLineByIndex(int index) 
    {
        return lines.get(index);
    }
}
