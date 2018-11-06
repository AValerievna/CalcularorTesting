import org.junit.Test;

/**
 * Created by Alexandra on 20.08.2017.
 */
public class NullTest {
    @Test(expected = NullPointerException.class)
    public void getElemsNullTest() {
        XmlParsing xp = new XmlParsing();
        xp.getElems(null);
    }

    @Test(expected = NullPointerException.class)
    public void tryToParseXmlNullTest() throws Exception {
        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(null);
    }

    @Test(expected = NullPointerException.class)
    public void doOpNullTest() throws Exception {
        XmlParsing xp = new XmlParsing();
        xp.doOp(null,null, null);
    }

    @Test(expected = NullPointerException.class)
    public void parseOpNullTest() throws Exception {
        XmlParsing xp = new XmlParsing();
        xp.parseOp(null);
    }

    @Test(expected = NullPointerException.class)
    public void parseExpNullTest() throws Exception {
        XmlParsing xp = new XmlParsing();
        xp.parseExp(null);
    }

    @Test(expected = NullPointerException.class)
    public void createResFileNullTest() throws Exception {
        XmlParsing xp = new XmlParsing();
        xp.createResultFile(null);
    }


}
