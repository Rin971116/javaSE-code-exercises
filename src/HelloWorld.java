class ideaTest{
    String[] str1 = {"你","好","我","是","林","廷胤"};
    String getWord(int index){
        System.out.println(str1[index]);
        return "有執行";
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        ideaTest it1 = new ideaTest();
        for (int i = 0; i <= it1.str1.length - 1; i++) {
            if(it1.getWord(i).equals("有執行")){
                System.out.println("真的有執行");
            }
        }
        System.out.println("Hello World!!");
        System.out.println("I'm Brian");
    }
}