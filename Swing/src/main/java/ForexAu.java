import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ForexAu {

    public String getForex() throws IOException {

//        https://rate.bot.com.tw/xrt/flcsv/0/2022-01-10 下載歷史CSV連結
//        https://rate.bot.com.tw/xrt/flcsv/0/day 台銀當天匯率
    String auForex,line,aubuy,ausell;

    List<List<String>>recordes = new ArrayList<>();
        URL forexURL=new URL("https://rate.bot.com.tw/xrt/flcsv/0/day");
        BufferedReader in = new BufferedReader(new InputStreamReader(forexURL.openStream()));

        ArrayList<String> arrayList = new ArrayList<>();
        while((line=in.readLine())!= null){
//            System.out.println("."+line.split(","));
            String[] values=line.split(",");
            recordes.add(Arrays.asList(values));
        }
        for(List<String> record : recordes ){
            System.out.println(record);
        }
//        System.out.print(records.get(4).get(0) + "  ");
//        System.out.println(records.get(4).get(2));
        aubuy="買進"+recordes.get(4).get(0)+" "+recordes.get(4).get(2);
        ausell="賣出"+recordes.get(4).get(0)+" "+recordes.get(4).get(12);
        auForex=aubuy+ "    " + ausell;

        return auForex;
    }

}
