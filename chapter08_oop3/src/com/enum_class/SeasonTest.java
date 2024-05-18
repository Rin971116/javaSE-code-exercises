package com.enum_class;

/**
 * ClassName:
 * Description:
 * 設計枚舉類的目的，是為了將已知 "固定數量的對象" 提供給 user，
 * 代表告知使用者 此類的對象 就只有我提供的這幾個，沒有其他的了，也不允許使用者再額外建立此類的對象。
 * 若想使用此類的對象，就透過格式: "類名.類內部提供的對象名" 去調用。
 *
 * @Author Rin
 * @Create 2024/4/5 下午 12:41
 * @Version 1.0
 */
public class SeasonTest {
    public static void main(String[] args) {

        System.out.println(Season.SPRING); //默認toString是寫在Enum類中，默認傳回物件名。
        System.out.println(Season.SPRING.getClass());
        System.out.println(Season.SPRING.getClass().getSuperclass());
//        Season spring = new Season(); // 報錯，Season聲明成enum類，代表不能額外再創建對象
//        System.out.println(Season.SPRING.seasonName); //seasonName聲明為private，故無法調用
//        System.out.println(Season.SPRING.seasonDescribe); //seasonDescribe聲明為private，故無法調用

        System.out.println(Season.SPRING.toString()); //override後的toString()
        // 常用方法1. name()
        System.out.println(Season.SPRING.name()); //name()是寫在Enum類中，傳回物件名。

        //常用方法2. values() ，將枚舉類內部提供的全部對象，建立數組
        Season[] values = Season.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println("--------------");

        //常用方法3. valueof() ，尋找枚舉類中是否有 輸入之型參的對象名，若沒有，執行時會報錯。
        System.out.println(Season.valueOf("SPRING"));
    }
}

//jdk5.0中使用 enum關鍵字 來定義枚舉類的方式
enum Season { //聲明成enum類，代表class Season extends Enum{}，除此外還有特殊語法規則，如下例

    // 0. 使用(public static final)需省略 objectName(),建立(new)枚舉類對象，並且必須寫在類下的第一個敘述語句開始。
    // 格式: 物件名(),物件名2(),物件名3(), ... ,物件名n();
    // 若沒有型參時,其實連()也可省略。
    TEST(),
    SPRING("春天", "春天開花"),//java自動建立了名為SPRING的Season類物件。(Season類中定義Season類的成員)
    SUMMER("夏天", "夏天很熱"),
    AUTUMN("秋天", "秋天涼爽"),
    WINTER("冬天", "冬天很冷");

    // 正常類的設計流程

    // 1.私有成員
    private String seasonName;
    private String seasonDescribe;

    // 2.私有化類的構造器
    private Season() {

    };

    private Season(String seasonName, String seasonDescribe) {
        this.seasonName = seasonName;
        this.seasonDescribe = seasonDescribe;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDescribe='" + seasonDescribe + '\'' +
                '}';
    }
}
