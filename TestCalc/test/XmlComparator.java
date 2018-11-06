import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.List;

/**
 * Created by Alexandra on 19.08.2017.*/
 public class XmlComparator {
    public Diff compareXML(String sF, String tF) throws FileNotFoundException, SAXException, IOException {

        // reading two xml file to compare in Java program
        FileInputStream fis1 = new FileInputStream( sF);//"C:/test/source.xml");
        FileInputStream fis2 = new FileInputStream( tF);//"C:/test/target.xml");

        // using BufferedReader for improved performance
        BufferedReader source = new BufferedReader(new InputStreamReader(fis1));
        BufferedReader target = new BufferedReader(new InputStreamReader(fis2));

        //configuring XMLUnit to ignore white spaces
        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreWhitespace(true);

        //comparing two XML using XMLUnit in Java
        //creating Diff instance to compare two XML files
        Diff diff = new Diff(source, target);
        showXmlDiff(diff);
        return diff;
    }

    public void showXmlDiff(Diff diff) {
        DetailedDiff detDiff = new DetailedDiff(diff);
        List differences = detDiff.getAllDifferences();
        for (Object difference : differences) {
            System.out.println("***********************");
            System.out.println(difference);
            System.out.println("***********************");
        }
    }
}

