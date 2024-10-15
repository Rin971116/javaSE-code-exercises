package grammar._07_record;

/**
 * ClassName:
 * Description:
 *
 *              基本上建立一個 record 就等於 建立這樣一個結構的 java bean，內部包含:
 *
 *                                           1 聲明為final的成員變量 (畢竟使用 record相當你啥都沒寫，java在後台自動建立，所以變量只能是final的)
 *                                           2.為所有屬性賦值的構造器 (不包含空參的構造器)
 *                                           3.equals()、hashcode()
 *                                           4.toString()
 *
 *              record的 拓展、限制 :
 *                      拓展: 可以在 {}中聲明 實例方法、靜態方法、其他構造器(以下面代碼為例，如果還想用空參的構造器的話，
 *                           需要調用 this(String name, int age))，也就是說需要 透過 record自動建立的 為所有屬性賦值的構造器，
 *                           也可以想成，畢竟屬性是 final修飾的，一定要透過構造器時就賦上初值，因此內部一定要調用 全參的構造器
 *
 *                      限制:  1. record不可以聲明為 抽象類 ，不能繼承其他父類，默認已經繼承於 Record類了，跟 enum的情況一樣，默認繼承 Enum類
 *                            2. 不能有子類，也就是說 record不能被其他類繼承
 *                            3.不能 聲明新的屬性，就算有加 final修飾也不行，畢竟你多增加了屬性，自動建立的 equals()、hashcode()那些就衝突了
 * @Author Rin
 * @Create 2024/7/12 上午 12:56
 * @Version 1.0
 */
public record Person1(String name, int age) {
}
