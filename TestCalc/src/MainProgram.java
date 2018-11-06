/**
 * Created by Alexandra on 19.08.2017.
 */
public class MainProgram {

    public static void main(String[] arg) throws Exception {
        String inputPath = "mySampleTest.xml",outputPath ="C:\\Users\\Alexandra\\IdeaProjects\\TestCalc\\myExpResults.xml";

        XmlParsing xp = new XmlParsing();
        xp.tryToParseXml(inputPath);
        xp.createResultFile(outputPath);
    }
}
