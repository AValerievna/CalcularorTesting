import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexandra on 19.08.2017.
 */
public class XmlParsingTest {
    @Before
    public void toStart()throws Exception {
    }

    @Test(expected = Exception.class)
    public void tryToParseWithIncorrectPath() throws Exception {
        String inp ="somepath";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test(expected = Exception.class)
    public void tryToParseWithoutTagSimpleCalculator() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithoutTagSimpleCalculatorTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test(expected = Exception.class)
    public void tryToParseWithoutTagExpression() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithoutTagExpressionTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test
    public void tryToParseWithoutAnyExpressionInFileTest() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithoutAnyExpressionInFileTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
        assertTrue("Appropriate result", xp.results.isEmpty() );
    }

    @Test(expected = Exception.class)
    public void tryToParseWithTwoOpsAfterExpTest() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithTwoOpsAfterExpTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test(expected = Exception.class)
    public void tryToParseWithNoOpTagAfterExpTest() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithNoOpTagAfterExpTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test(expected = Exception.class)
    public void tryToParseWithThreeElemsAfterOpTest() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithThreeElemsAfterOpTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test(expected = Exception.class)
    public void tryToParseWithIncorrectOpOrArgTagTest() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithIncorrectOpOrArgTagTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test(expected = Exception.class)
    public void tryToParseWithIncorrectArgTest() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithIncorrectArgTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test(expected = Exception.class)
    public void tryToParseWithTooBigArgTest() throws Exception {
        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseWithTooBigArgTest.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
    }

    @Test
    public void tryToParseGoodRes1() throws Exception {
        ArrayList<Double> res = new ArrayList<>(Arrays.asList(-2443.75, 59747.58686350021));

        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseGoodRes1.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
        for (int i = 0; i < xp.results.size(); i++){
            assertEquals("Appropriate result!", res.get(i), xp.results.get(i));
        }
    }

    @Test
    public void tryToParseGoodRes2() throws Exception {
        ArrayList<Double> res = new ArrayList<>(Arrays.asList(8d, 5d, 11d));

        String inp ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\test\\testXml\\tryToParseGoodRes2.xml";
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inp);
        for (int i = 0; i < xp.results.size(); i++){
            assertEquals("Appropriate result!", res.get(i), xp.results.get(i));
        }
    }
}
