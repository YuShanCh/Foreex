

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForexUs {

    public String getForex() throws IOException {

//        https://rate.bot.com.tw/xrt/flcsv/0/2022-01-10 下載歷史CSV連結
//        https://rate.bot.com.tw/xrt/flcsv/0/day 台銀當天匯率

        String usForex, line, usbuy, ussell;


        List<List<String>> records = new ArrayList<>();
        URL forexURL = new URL("https://rate.bot.com.tw/xrt/flcsv/0/day");
        BufferedReader in = new BufferedReader(new InputStreamReader(forexURL.openStream()));


        ArrayList<String> arrayList = new ArrayList();
        while ((line = in.readLine()) != null) {
//            System.out.println("."+line.split(","));
            String[] values = line.split(",");
            records.add(Arrays.asList(values));
        }

        for(List<String> record : records){
            System.out.println(record);
        }

//        System.out.print(records.get(1).get(0) + "  ");
//        System.out.println(records.get(1).get(2));
        usbuy = "買進" + records.get(1).get(0) + " " + records.get(1).get(2);
        ussell = "賣出" + records.get(1).get(0) + " " + records.get(1).get(12);
        usForex = usbuy + "    " + ussell;

        return usForex;
    }
}