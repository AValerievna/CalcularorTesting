import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Alexandra on 19.08.2017.
 */

//working with xml
public class XmlParsing {
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    ArrayList<Double> results;

    public XmlParsing() {
        results = new ArrayList<Double>();
        dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    //parse expression element and get result of expression
     public void parseExp(Node curExp) throws Exception {
        NodeList fOper = curExp.getChildNodes();
        ArrayList<Node> nodes = getElems(fOper);

        if ((nodes.size() != 1) || !(nodes.get(0).getNodeName().equals("operation"))) throw new Exception("incorrect xml doc! 1f ");

        results.add(parseOp(nodes.get(0)));
        //System.out.println(results.get(results.size()-1));
    }

    //get child nodes without text nodes
    public ArrayList<Node> getElems(NodeList chList) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int i=0; i < chList.getLength(); i++) {
            if (chList.item(i).getNodeType() == Node.ELEMENT_NODE)
                nodes.add(chList.item(i));
        }
        return nodes;
    }

    //parse operation element and calculate result
    public double parseOp(Node curOp) throws Exception {
        List<Double> nums = asList(null,null); // list of operands

        NodeList nl =curOp.getChildNodes();
        ArrayList<Node> nodes = getElems(nl);

        if (nodes.size()!= 2) throw new Exception("incorrect xml doc! 2f");
        for ( int i=0; i<2; i++) {
            Node n = nodes.get(i);
            if (n.getNodeName().equals("operation")) {
                nums.set(i,parseOp(n));
            } else if (n.getNodeName().equals("arg")) {
                try {
                    int number = Integer.parseInt(n.getTextContent());
                    nums.set(i,(double)number );
                } catch (NumberFormatException e){
                    throw new Exception("number is too big or it is not number!");
                }
            } else throw new Exception("incorrect xml doc! 3f");
        }
        return doOp(curOp.getAttributes().getNamedItem("OperationType").getTextContent(),nums.get(0),nums.get(1));

    }

    //realising arithmetic operations
    public double doOp(String op, Double num1, Double num2) throws Exception {
        switch (op) {

            case "MUL":
                if ((num1 != 0) && (num2 != 0) && (num1*num2/num2 != num1)) throw new Exception("MUL overflow!");
                return num1*num2;
            case "DIV":
                if (num2 == 0) throw new Exception("DIV with zero as second argument!");
                if (((num1 != 0) && (num2 != 0) && (num1/num2*num2 != num1)) || ((num1 == -Double.MAX_VALUE) && (num2 == -1))) throw new Exception("DIV overflow!");
                return num1/num2;
            case "SUB":
                if (((num1 >= 0) && (num2 < 0) && (num1 > Double.MAX_VALUE + num2)) || ((num1 < 0) && (num2 >= 0) && (num1 < -Double.MAX_VALUE + num2))) throw new Exception("SUB overflow!");
                return num1-num2;
            case "SUM":
                if (((num1 > 0) && (num2 > 0) && (num1 > Double.MAX_VALUE - num2)) || ((num1 < 0) && (num2 < 0) && (num1 < -Double.MAX_VALUE - num2))) throw new Exception("SUM overflow!");
                return num1+num2;
            default:
                throw new Exception("incorrect operationType!");
        }
    }

    //parsing of input xml file
    void tryToParseXml(String inputPath) throws Exception{
        doc = db.parse(new File(inputPath));
        doc.getDocumentElement().normalize();

        Node root = doc.getDocumentElement();
        NodeList rootCh = root.getChildNodes();

        ArrayList<Node> exps = getElems(rootCh);
        if (root.getNodeName().equals("simpleCalculator") && (exps.size()==1) && (exps.get(0).getNodeName().equals("expressions"))) {

            NodeList cnl = exps.get(0).getChildNodes();
            ArrayList<Node> expList = getElems(cnl);
            for (int cur = 0; cur < expList.size(); cur++) {
                if (expList.get(cur).getNodeName().equals("expression")) {
                    parseExp(expList.get(cur));
                } else throw new Exception("incorrect xml file! 4f");
            }
        } else throw new Exception ("incorrect xml file! 5f");
    }

    //creating output file
    void createResultFile(String outputPath) {
        try {
            doc = db.newDocument();
            Element rootElem =doc.createElement("simpleCalculator");
            doc.appendChild(rootElem);

            Element expRess = doc.createElement("expressionResults");
            rootElem.appendChild(expRess);

            for (int i = 0; i < results.size(); i++) {
                Element expRes = doc.createElement("expressionResult");
                expRess.appendChild(expRes);

                Element res = doc.createElement("result");
                expRes.appendChild(res);

                res.appendChild(doc.createTextNode(results.get(i).toString()));
            }

            TransformerFactory trFac = TransformerFactory.newInstance();
            Transformer tr = trFac.newTransformer();
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult streamRes = new StreamResult(new File(outputPath));
            tr.transform(source,streamRes);
            //StreamResult console = new StreamResult(System.out);
            //tr.transform(source,console);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

}
