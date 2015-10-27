package code2flowchartclone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XmlTool {//xml reading class
    //////////////////////////////
    private ArrayList<String> stringelements;//attribute that containts each element of the xml.
     
    public XmlTool(){//constructor.
        stringelements= new ArrayList<>();
    }
    
    public ArrayList<String> getStringelements() {//get and set
        return stringelements;
    }

    public void setStringelements(ArrayList<String> stringelements) {
        this.stringelements = stringelements;
    }
      
    public void readMessage(String filename){//reads, parses, and puts each element of the xml to the string arraylist attribute.
      
        try {	
            ArrayList<String> elementsaux=new ArrayList<>();//aux arraylist.
            File inputFile = new File(filename);//creates a file.
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();//new instance of the document builder.
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();//assigns the document to the instance.
            Document doc = dBuilder.parse(inputFile);//parses the file.
            doc.getDocumentElement().normalize();//structures the tree for the xml.
            Element elemdoc = doc.getDocumentElement();//element of the document.

            NodeList list1=elemdoc.getChildNodes();//list of the nodes.
           System.out.println(list1.getLength());
           for(int i=0;i<list1.getLength();i++){//puts all the elements in the arraylist.
               for(int j=0;j<list1.item(i).getChildNodes().getLength();j++){
                   if(list1.item(i).getChildNodes().getLength()==0)
                       continue;
                   else{ 
                       elementsaux.add(list1.item(i).getChildNodes().item(j).getNodeValue());
                   }
               }

           }   

           stringelements.addAll(Arrays.asList(elementsaux.get(0).split(" "))); //splits characters and puts them in the
            //arraylist attribute.
           
            //System.out.println(stringelements.get(1));
            //System.out.println(list1.item().getChildNodes().getLength());
            //System.out.println("ele: "+ doc.getElementsByTagName("snippets").item(0).getTextContent());
            /*for(int i=0;i<doc.getElementsByTagName("snippets").getLength();i++){
            stringelements.add(doc.getElementsByTagName("snipp").item(0).getTextContent());
            //System.out.println("e: " + stringelements.get(0));
            }*/
            /* NodeList listanodo = doc.getElementsByTagName("snippet1");
            for(int i = 0; i < listanodo.getLength(); i++){
            System.out.println("elemento: "+doc.getDocumentElement().getNodeName());
            }*/
            //System.out.println("Root element :"
            //  + doc.getDocumentElement().getNodeName());
            //NodeList nList = doc.getElementsByTagName("student");
            /*for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :"
            + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            }
            }*/
      } catch (ParserConfigurationException | SAXException | IOException e) {
             System.out.println("Error en Xml");
      }
    }
    
    

	
}
