import org.custommonkey.xmlunit.Diff;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexandra on 20.08.2017.
 */
public class CreateResultTest {
    XmlComparator xc;
    @Before
    public void toStart()throws Exception {
        xc = new XmlComparator();
    }
    @Test
    public void createResultFileWithResultsTest() throws IOException, SAXException {
        String sourseF ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\createResultFileWithResultsTest.xml";
        String outputPath ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\createResultFileWithResults.xml";
        XmlParsing xp = new XmlParsing();
        xp.results.addAll(Arrays.asList(1.0,3.0));
        xp.createResultFile(outputPath);
        Diff diff = xc.compareXML(sourseF, outputPath);
        assertTrue("Appropriate result",diff.identical());
    }

    @Test
    public void createResultFileWithoutResultsTest() throws IOException, SAXException {
        String sourseF ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\createResultFileWithoutResultsTest.xml";
        String outputPath ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\createResultFileWithoutResults.xml";
        XmlParsing xp = new XmlParsing();
        xp.createResultFile(outputPath);
        Diff diff = xc.compareXML(sourseF, outputPath);
        assertTrue("Appropriate result",diff.identical());
    }
}
