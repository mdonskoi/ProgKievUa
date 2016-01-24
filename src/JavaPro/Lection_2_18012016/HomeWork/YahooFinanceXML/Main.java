package JavaPro.Lection_2_18012016.HomeWork.YahooFinanceXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        String request = "http://query.yahooapis.com/v1/public/yql?format=XML&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";
        // try {


        System.out.println(request);

        // String result = performRequest(request);


//            Gson gson = new GsonBuilder().create();
//            JSON json = (JSON) gson.fromJson(result, JSON.class);
//
//            for (Rate rate : json.query.results.rate) {
//                System.out.println(rate.id + "=" + rate.Rate);
//            }
//
//            System.out.println("JSON: \n\t" + gson.toJson(json));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String performRequest(String urlStr) throws IOException {
//        URL url = new URL(urlStr);
//        StringBuilder sb = new StringBuilder();
//
//        HttpURLConnection http = (HttpURLConnection) url.openConnection();
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
//            char[] buf = new char[1000000];
//
//            int r = 0;
//            do {
//                if ((r = br.read(buf)) > 0)
//                    sb.append(new String(buf, 0, r));
//            } while (r > 0);
//        } finally {
//            http.disconnect();
//        }
//
//        return sb.toString();

    }
}
