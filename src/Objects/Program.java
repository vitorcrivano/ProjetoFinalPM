/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Crivano
 */
public class Program {
    
    private String name;
    private List<SearchLine> lines;

    public Program(String name) {
        this.name = name;
        this.lines = new ArrayList<SearchLine>();
    }
    
    public Program(){
        this("");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addLine(SearchLine line) {
        lines.add(line);
    }
    
    public int countSearchLines() {
        return lines.size();
    }

    public Iterable<SearchLine> getLinhas() {
        return lines;
    }
    
    public SearchLine getSearchLineByIndex(int index) {
        return lines.get(index);
    }
}
