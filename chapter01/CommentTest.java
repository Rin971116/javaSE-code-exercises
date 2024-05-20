/*
這是多行注釋
我想打多少字都行，打篇作文都行
*/

/**
這邊為文檔注釋
@author kazu
@version 1.0
*/
import java.util.HashMap;

public class CommentTest{
/**
使用文檔注釋
1.需將類名給上public，也就是說開頭class名字需與檔案名稱相同
2.再cmd執行時，輸入javadoc -d mydoc(欲建立之資料夾的名稱) -author -version CommentTest.java(目前文本的檔案名稱)
*/
public static void main(String[] args){
		//這是輸出語句
		System.out.println("Kazu你好");
		HashMap<Integer, Integer> map = new HashMap<>();
	} 
} 