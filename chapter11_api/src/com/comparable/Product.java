package com.comparable;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/7 下午 06:39
 * @Version 1.0
 */
public class Product implements Comparable{
    /**
     * 當前的類需要實現Comparable中的抽象方法: compareTo(Object o)
     * 在此方法中，指明如何判斷當前類的對象大小。比如: 按照價格的高低進行比較
     *
     * 默認規則: 若 return 0:代表告訴 sort() 調用當前方法compareTo() 的 物件與 透過參數傳入的物件 大小相同
     *                    1:代表告訴 sort() 調用當前方法compareTo() 的 物件大
     *                   -1:代表告訴 sort() 調用當前方法compareTo() 的 物件小
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Object o)throws RuntimeException {
        if (o == this){ //代表同一個物件，地址值相同
            return 0;
        }

        if (o instanceof Product){
            Product p = (Product) o;
            //方法1: 完全自定義 比較規則
            if (this.price > p.price){
                return 1;
            }else if (this.price < p.price){
                return -1;
            }else if (this.price == p.price){
                return 0;
            }
            // 方法2: 使用包裝類的compare()
            // 包裝類的compare()邏輯為 傳入的參數前後比較，若後者較大return -1; 後者較小return 1; 相等return 0
            return Integer.compare(this.price,p.price); //結果1:假設this.price > p.price 傳回1 告知sort()當前調用compareTo()的物件大
//          return Integer.compare(p.price,this.price); //結果2:假設this.price > p.price 傳回-1 告知sort()當前調用compareTo()的物件小
        }

        throw new RuntimeException("類型不匹配");
    }

    private int price;
    private String name;
    private String brand;

    public Product(){

    }

    public Product(int price, String name, String brand) {
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
