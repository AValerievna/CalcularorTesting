import org.custommonkey.xmlunit.Diff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexandra on 20.08.2017.
 */
public class FullApplicationTest {
    XmlComparator xc;
    @Before
    public void toStart()throws Exception {
        xc = new XmlComparator();
    }

    @Test
    public void fullTestGoodRes1() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseGoodRes1.xml";
        String sourseF ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\fullTestGoodRes1.xml";
        String outputPath ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\fullTestGoodRes1Results.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
        xp.createResultFile(outputPath);
        Diff diff = xc.compareXML(sourseF, outputPath);
        assertTrue("Appropriate result",diff.identical());
    }

    @Test
    public void fullTestGoodRes2() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseGoodRes2.xml";
        String sourseF ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\fullTestGoodRes2.xml";
        String outputPath ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\fullTestGoodRes2Results.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
        xp.createResultFile(outputPath);
        Diff diff = xc.compareXML(sourseF, outputPath);
        assertTrue("Appropriate result",diff.identical());
    }
}
