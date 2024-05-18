package com.map.exer1;

import java.util.*;

/**
 * ClassName:
 * Description:
 *                  編寫一個 貨運地址登錄系統
 *                                      1: print城市名稱，供 user選擇
 *                                      2: user選擇指定城市後，返回該城市的區(district)
 *                                      3. user選擇完指定區後，print出 user所選擇的配送地址
 * @Author Rin
 * @Create 2024/5/16 下午 05:58
 * @Version 1.0
 */
public class Exer1 {
    public static void main(String[] args) {

        //step1: print all key option
        HashMap map = CityMap.map;
        Set keySet = map.keySet();
        for (Object o : keySet) {
            System.out.print(o + "\t\t");
        }

        //step2: get user input(key), and return value of input(key)
        Scanner sc = new Scanner(System.in);
        String city;
        String[] values;

        while (true) {
            System.out.print("\n請輸入城市:");
            city = sc.next();
            Object value = map.get(city);

            //方式1: 當獲取的value是String[]類時
            values = (String[]) value;
            if (values != null || values.length == 0) {
                for (Object o : values) {
                    System.out.print(o + "\t\t");
                }

            //方式2: 當獲取的value是Set類時
//            Set values = (Set) value;
//            if (values != null || values.length == 0 ) {
//                    for (Object o : values) {
//                        System.out.print(o + "\t\t");
//                    }

                break;

            } else {
                System.out.print("查無該城市，請重新輸入");
            }
        }

        loopwhile:
        while (true){
            System.out.print("請輸入區:");
            String district = sc.next();
            for (String s : values){
                if (district.equals(s)){
                    System.out.println("配送地址:" + city + "\t" + district);
                    System.out.println("訂單成立!!");
                    break loopwhile;
                }
            }
            System.out.println("查無該區域，請重新輸入");
        }


        sc.close();
    }
}


class CityMap {
    public static HashMap map = new HashMap();

    static {
        //方式1: 當獲取的value是String[]類時
        map.put("台北市", new String[]{"南港區", "內湖區", "中山區"});
        map.put("新北市", new String[]{"板橋區", "淡水區", "汐止區"});


        //方式2: 當獲取的value是Set類時
//        Set set = new HashSet();
//        set.add("南港區");
//        set.add("內湖區");
//        set.add("中山區");
//        map.put("台北市", set);
//
//        Set set2 = new HashSet();
//        set2.add("板橋區");
//        set2.add("淡水區");
//        set2.add("汐止區");
//        map.put("新北市", set);
    }
}
