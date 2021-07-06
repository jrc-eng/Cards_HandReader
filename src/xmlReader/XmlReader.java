/*
 * XMLREADER:
 *
 * Created 3, March, 2021.
 *
 * Note:  This Class Adapts Code from the Following Sources:
 *
 * https://www.javatpoint.com/how-to-read-xml-file-in-java
 * https://www.programmergate.com/how-to-read-xml-file-in-java/
 *
 */
package project2_xmlBookReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xmlReader.Entry;

/**
 * XmlReader:
 * 
 * No-argument constructor.
 * 
 * Call function getBookXML to perform the XML Reading.
 * 
 * Make sure path is a valid path.
 * 
 * Note: This Class makes use of code adapted from:
 * https://www.javatpoint.com/how-to-read-xml-file-in-java
 * https://www.programmergate.com/how-to-read-xml-file-in-java/
 *
 */
public class XmlReader {
    
    
    
    /**
     * getBookXML
     * 
     * Gets an XML's Contents from the Page in the form of a String.
     * 
     * 
     * Adapted from: 
     * https://www.javatpoint.com/how-to-read-xml-file-in-java
     * https://www.programmergate.com/how-to-read-xml-file-in-java/
     * 
     * @param path
     * @return bookList.  bookList is EMPTY if this method fails due to an exception.
     */
    public ArrayList<Entry> getBookXML(String path)
    {
           //bookList: Our return value.  Starts empty.
           ArrayList<Entry> entryList = new ArrayList<Entry>();
           
           try
           {
            
            //Define a file.
            File isFile = new File(path);
            
            //Use DocumentBuilderFactory and Document Builder.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            //Parse the DocumentBuilder into a Document.
            Document doc = builder.parse(isFile);
            
            
            //Now, we can get the nodeList.
                doc.getDocumentElement().normalize(); 
             NodeList nodeList = doc.getElementsByTagName("book"); 
             
             //With the NodeList identified, we can convert the "Nodes" into Books which we can fill the ArrayList with.
            for (int i = 0; i < nodeList.getLength(); i++) { 

                Node node = nodeList.item(i);
                
                //If this Node is a Book, we read it, get its contents, generate a Book, and send.
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Entry entry = new Entry();
                    
                    Element eElement = (Element) node;  
                    
                    //author, title, and cover are all meant to be treated as strings.
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String desc = eElement.getElementsByTagName("desc").item(0).getTextContent();
                    
                    
                    //Set Entry Contents
                    entry.setName(name);
                    entry.setDesc(desc);
                    
                    //Add to List.
                    entryList.add(entry);
                }
            }
           }
           catch(Exception e)
           {
               //We failed.  Print what happened.
               System.out.println("XMLReader failed to get BookList.");
               e.printStackTrace();  
               
           }
           
           
           return entryList;
    }
}
    

