package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-09
 */
public class InvalidTransactionsChinemerem {

    public static void main(String[] args) {
        String[] list = {"alice,20,800,mtv","bob,50,1200,mtv"};
        //System.out.println(invalidTransactions(list));

        String[] list2 = {"bob,649,842,prague","alex,175,1127,mexico","iris,164,119,paris","lee,991,1570,mexico","lee,895,1876,taipei","iris,716,754,moscow","chalicefy,19,592,singapore","chalicefy,820,71,newdelhi","maybe,231,1790,paris","lee,158,987,mexico","chalicefy,415,22,montreal","iris,803,691,milan","xnova,786,804,guangzhou","lee,734,1915,prague","bob,836,1904,dubai","iris,666,231,chicago","iris,677,1451,milan","maybe,860,517,toronto","iris,344,1452,bangkok","lee,664,463,frankfurt","chalicefy,95,1222,montreal","lee,293,1102,istanbul","maybe,874,36,hongkong","maybe,457,1802,montreal","xnova,535,270,munich","iris,39,264,istanbul","chalicefy,548,363,barcelona","lee,373,184,munich","xnova,405,957,mexico","chalicefy,517,266,luxembourg","iris,25,657,singapore","bob,688,451,beijing","bob,263,1258,tokyo","maybe,140,222,amsterdam","xnova,852,330,barcelona","xnova,589,837,budapest","lee,152,981,mexico","alex,893,1976,shenzhen","xnova,560,825,prague","chalicefy,283,399,zurich","iris,967,1119,guangzhou","alex,924,223,milan","chalicefy,212,1865,chicago","alex,443,537,taipei","maybe,390,5,shanghai","bob,510,1923,madrid","bob,798,343,hongkong","iris,643,1703,madrid","bob,478,928,barcelona","maybe,75,1980,shanghai","xnova,293,24,newdelhi","iris,176,268,milan","alex,783,81,moscow","maybe,560,587,milan","alex,406,776,istanbul","lee,558,727,paris","maybe,481,1504,munich","maybe,685,602,madrid","iris,678,788,madrid","xnova,704,274,newdelhi","chalicefy,36,1984,paris","iris,749,200,amsterdam","lee,21,119,taipei","iris,406,433,bangkok","bob,777,542,taipei","maybe,230,1434,barcelona","iris,420,1818,zurich","lee,622,194,amsterdam","maybe,545,608,shanghai","xnova,201,1375,madrid","lee,432,520,dubai","bob,150,1634,singapore","maybe,467,1178,munich","iris,45,904,beijing","maybe,607,1953,tokyo","bob,901,815,tokyo","maybe,636,558,milan","bob,568,1674,toronto","iris,825,484,madrid","iris,951,930,dubai","bob,465,1080,taipei","bob,337,593,chicago","chalicefy,16,176,rome","chalicefy,671,583,singapore","iris,268,391,chicago","xnova,836,153,jakarta","bob,436,530,warsaw","alex,354,1328,luxembourg","iris,928,1565,paris","xnova,627,834,budapest","xnova,640,513,jakarta","alex,119,16,toronto","xnova,443,1687,taipei","chalicefy,867,1520,montreal","alex,456,889,newdelhi","lee,166,3,madrid","bob,65,1559,zurich","alex,628,861,moscow","maybe,668,572,mexico","bob,402,922,montreal"};
        System.out.println(invalidTransactions(list2));

//        String[] answer1 = {"maybe,668,572,mexico","lee,895,1876,taipei","lee,166,3,madrid","chalicefy,212,1865,chicago","bob,688,451,beijing","iris,176,268,milan","iris,344,1452,bangkok","iris,677,1451,milan","xnova,443,1687,taipei","maybe,874,36,hongkong","iris,967,1119,guangzhou","lee,373,184,munich","alex,406,776,istanbul","maybe,481,1504,munich","iris,803,691,milan","chalicefy,95,1222,montreal","bob,436,530,warsaw","iris,164,119,paris","chalicefy,548,363,barcelona","alex,924,223,milan","maybe,560,587,milan","iris,45,904,beijing","chalicefy,517,266,luxembourg","maybe,636,558,milan","alex,119,16,toronto","bob,402,922,montreal","lee,991,1570,mexico","maybe,685,602,madrid","iris,716,754,moscow","chalicefy,36,1984,paris","iris,420,1818,zurich","bob,649,842,prague","maybe,860,517,toronto","iris,406,433,bangkok","alex,354,1328,luxembourg","bob,798,343,hongkong","xnova,786,804,guangzhou","iris,749,200,amsterdam","bob,263,1258,tokyo","alex,456,889,newdelhi","xnova,640,513,jakarta","iris,666,231,chicago","iris,951,930,dubai","lee,158,987,mexico","maybe,545,608,shanghai","maybe,230,1434,barcelona","xnova,201,1375,madrid","alex,443,537,taipei","bob,568,1674,toronto","bob,65,1559,zurich","bob,478,928,barcelona","xnova,405,957,mexico","bob,510,1923,madrid","maybe,231,1790,paris","lee,293,1102,istanbul","iris,25,657,singapore","iris,643,1703,madrid","xnova,560,825,prague","lee,664,463,frankfurt","xnova,836,153,jakarta","alex,175,1127,mexico","lee,734,1915,prague","bob,465,1080,taipei","chalicefy,16,176,rome","chalicefy,19,592,singapore","xnova,852,330,barcelona","xnova,627,834,budapest","bob,836,1904,dubai","iris,825,484,madrid","bob,777,542,taipei","maybe,75,1980,shanghai","maybe,607,1953,tokyo","lee,432,520,dubai","chalicefy,867,1520,montreal","chalicefy,820,71,newdelhi","maybe,467,1178,munich","iris,678,788,madrid","maybe,457,1802,montreal","xnova,589,837,budapest","xnova,535,270,munich","alex,893,1976,shenzhen","iris,39,264,istanbul","iris,928,1565,paris","bob,150,1634,singapore","lee,622,194,amsterdam"};
//        String[] answer2 = {"bob,649,842,prague","alex,175,1127,mexico","iris,164,119,paris","lee,991,1570,mexico","lee,895,1876,taipei","iris,716,754,moscow","chalicefy,19,592,singapore","chalicefy,820,71,newdelhi","maybe,231,1790,paris","lee,158,987,mexico","iris,803,691,milan","xnova,786,804,guangzhou","lee,734,1915,prague","bob,836,1904,dubai","iris,666,231,chicago","iris,677,1451,milan","maybe,860,517,toronto","iris,344,1452,bangkok","lee,664,463,frankfurt","chalicefy,95,1222,montreal","lee,293,1102,istanbul","maybe,874,36,hongkong","maybe,457,1802,montreal","xnova,535,270,munich","iris,39,264,istanbul","chalicefy,548,363,barcelona","lee,373,184,munich","xnova,405,957,mexico","chalicefy,517,266,luxembourg","iris,25,657,singapore","bob,688,451,beijing","bob,263,1258,tokyo","xnova,852,330,barcelona","xnova,589,837,budapest","lee,152,981,mexico","alex,893,1976,shenzhen","xnova,560,825,prague","iris,967,1119,guangzhou","alex,924,223,milan","chalicefy,212,1865,chicago","alex,443,537,taipei","bob,510,1923,madrid","bob,798,343,hongkong","iris,643,1703,madrid","bob,478,928,barcelona","maybe,75,1980,shanghai","iris,176,268,milan","maybe,560,587,milan","alex,406,776,istanbul","maybe,481,1504,munich","maybe,685,602,madrid","iris,678,788,madrid","chalicefy,36,1984,paris","iris,749,200,amsterdam","iris,406,433,bangkok","bob,777,542,taipei","maybe,230,1434,barcelona","iris,420,1818,zurich","lee,622,194,amsterdam","maybe,545,608,shanghai","xnova,201,1375,madrid","lee,432,520,dubai","bob,150,1634,singapore","maybe,467,1178,munich","iris,45,904,beijing","maybe,607,1953,tokyo","maybe,636,558,milan","bob,568,1674,toronto","iris,825,484,madrid","iris,951,930,dubai","bob,465,1080,taipei","chalicefy,16,176,rome","xnova,836,153,jakarta","bob,436,530,warsaw","alex,354,1328,luxembourg","iris,928,1565,paris","xnova,627,834,budapest","xnova,640,513,jakarta","alex,119,16,toronto","xnova,443,1687,taipei","chalicefy,867,1520,montreal","alex,456,889,newdelhi","lee,166,3,madrid","bob,65,1559,zurich","maybe,668,572,mexico","bob,402,922,montreal"};
//
//        for(int i = 0; i < answer2.length; i++){
//            boolean found = false;
//            for(int j = 0; j < answer1.length; j++){
//                if(answer2[i].equals(answer1[j])) found = true;
//            }
//
//            if(!found) System.out.println(answer2[i]);
//        }
    }

    public static List<String> invalidTransactions(String[] list) {
        if (list == null || list.length == 0) {
            return new ArrayList<>();
        }

        Map<String, PriorityQueue<Tran>> map = new HashMap<>();

        for (String entry : list) {
            Tran tran = new Tran(entry);
            map.putIfAbsent(tran.name, new PriorityQueue<>());
            map.get(tran.name).add(tran);
        }

        Set<String> res = new HashSet<>();

        for (String name : map.keySet()) {

            if(name.equals("lee")){
                System.out.println("Enter");
            }

            Tran prev = new Tran();
            PriorityQueue<Tran> pq = map.get(name);

            while (!pq.isEmpty()) {
                Tran tran = pq.poll();
                if (tran.amount > 1000) {
                    res.add(tran.toString());
                }

                if (Math.abs(tran.time - prev.time) <= 60 && !prev.city.equals(tran.city)) {
                    res.add(prev.toString());
                    res.add(tran.toString());
                }

                prev = tran;
            }
        }

        return new ArrayList<>(res);
    }
}

class Tran implements Comparable<Tran> {
    String name = "";
    int time = Integer.MIN_VALUE;
    int amount = 0;
    String city = "";

    Tran(String input) {
        String[] arr = input.split(",");
        name = arr[0];
        time = Integer.parseInt(arr[1]);
        amount = Integer.parseInt(arr[2]);
        city = arr[3];
    }

    Tran() {
    }

    public String toString() {
        return String.format("%s,%d,%d,%s", name, time, amount, city);
    }

    @Override
    public int compareTo(Tran o) {
        return this.time - o.time;
    }
}
