package JavaPro.Lection_2_18012016.HomeWork.YahooFinanceXML;



import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;



public class Main {
    public static void main(String[] args) {

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20"
                + "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        try {
            String result = performRequest(request);
            System.out.println(result);
        }catch (IOException e1){
            e1.printStackTrace();
        }
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(request);
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Convert USD/EUR= " + element.getElementsByTagName("Rate").item(0).getFirstChild().getNodeValue());
                    System.out.println("Convert USD/UAH= " + element.getElementsByTagName("Rate").item(1).getLastChild().getNodeValue());
                }
            }
        }catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

    }
    private  static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            }while (r>0);
        }finally {
            http.disconnect();
        }
        return sb.toString();
    }
}
