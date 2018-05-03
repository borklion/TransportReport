package ru.borklion.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import ru.borklion.view.MainWindow;

public class TransportReportUtil {
    static int stringToInt(String val, int defaultValue) {
        try {
            return Integer.parseInt(val);
        }
        catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    public static boolean isNullOrBlank(String s)
    {
      return (s==null || s.trim().equals(""));
    }
    
    static public List<String[]> XMLParse(File file) throws FileNotFoundException, IOException {
        List<String[]> calls = new ArrayList<>();
        FileInputStream stream = new FileInputStream(file);
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(stream);
            while(reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if(xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if(startElement.getName().getLocalPart().equals("Сведения")) {
                        Attribute mileageAttr = startElement.getAttributeByName(new QName("MILEAGE"));
                        if(mileageAttr !=null && mileageAttr.getValue().equals("Общественный транспорт")) {
                            String[] call = new String[4];
                            call[0] = (startElement.getAttributeByName(new QName("SER_ID"))!=null ? startElement.getAttributeByName(new QName("SER_ID")).getValue() : "");
                            call[1] = (startElement.getAttributeByName(new QName("FIO_ISP"))!=null ? startElement.getAttributeByName(new QName("FIO_ISP")).getValue() : "");
                            call[2] = (startElement.getAttributeByName(new QName("ADDR"))!=null ? startElement.getAttributeByName(new QName("ADDR")).getValue() : "");
                            call[3] = startElement.getAttributeByName(new QName("SER_ACTUALFINISH")).getValue().replace("T", " ");
                            calls.add(call);
                        }
                        
                    }
                }
            }
        }
        catch(XMLStreamException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        stream.close();
        return calls;
    }
}
