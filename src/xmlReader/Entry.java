/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlReader;

/**
 * ENTRY
 * 
 * Java Data Class for XML Contents for this project.
 *
 * @author jrcro
 */
public class Entry {
    public String name;
    public String desc;
    
    /**
     * Entry()
     * 
     * Default Constructor.  Sets name and desc to "N/A"
     * 
     * The name and description can be set later with the getters and setters.
     * 
     */
    public Entry()
    {
        name = desc = "N/A";
    }
    
    /**
     * 
     * 
     * 
     * @param n
     * @param d 
     */
    public Entry(String n, String d)
    {
        name = n;
        desc = d;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }
    
    public void setDesc(String d)
    {
        desc = d;
    }
    public String getDesc()
    {
        return desc;
    }
    
    
    
}
