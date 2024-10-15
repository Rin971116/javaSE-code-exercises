package grammar._06_block;

import org.junit.Test;

/**
 * ClassName:
 * Description:     超實用 !!
 *                  1.在輸出 String訊息時 可以使用 """ (三個 ")開頭及結束，可以依照 編輯器上寫的排版 輸出，不用再使用 \n 或是 sout() 去換行
 *                  2.說白了就是 IDEA自動幫你換行，相反 若使用這種方式，但有地方不想換行時，可以加一個 \ 符號，意思告訴 IDEA不換行
 * @Author Rin
 * @Create 2024/7/11 上午 02:20
 * @Version 1.0
 */
public class BlockTest {
    /**
     * 老方法
     */
    @Test
    public void test1(){
        String str = "{" + "\n" +
                "\t" + "Name: Brian" + "\n" +
                "\t" + "Age: 24" + "\n" +
                "\t" + "Mail: gummy789123@gmail.com" + "\n" +
                "}";

        System.out.println(str);
    }

    /**
     * 新方法
     */
    @Test
    public void test2(){
        String str = """
                {
                    Name: Brian
                    Age: 24
                    Mail: gummy789123@gmail.com
                }
                """;

        System.out.println(str);

        // 使用"""的情況下，使用 \ 來告訴IDEA不要自動換行
        String str1 = """
                {
                    Name: Brian\
                    Age: 24\
                    Mail: gummy789123@gmail.com
                }
                """;

        System.out.println(str);
    }
}
