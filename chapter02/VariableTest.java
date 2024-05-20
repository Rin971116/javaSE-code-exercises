/*
測試變量的基本使用
 
1.變量的理解:內存中的一個存儲區域，該區域的數據可以在同一類型範圍下不斷變化

2.變量的構成包含三個要素:數據類型(某種類)、變量名、存儲的值

3.java中變量聲明的格式: 數據類型(某種類) 變量名 = 變量值

4.java中的變量按照數據類型分類:
	
	基本數據類型(8種):
		整型: byte \ short \ int \ long
		浮點型: float \ double
		字符型: char
		布爾型: boolean

	引用數據類型:
		類(class)
		數組(array)
		接口(interface)

		枚舉(enum)
		注解(annotation)
		紀錄(record)

5.定義變量名時，要遵守標示符的命名規則和規範

6.說明:
	> 變量都有其作用區域。變量只在作用域內是有效的，出了作用域就失效了。所謂作用區域就是變量所在最近的{ }
	> 在同一個作用區域內，不可以聲明兩個同名的變量
	> 定義好變量之後，就可以通過變量名的方式對變量進行調用和運算
	> 變量值在賦值時，必須滿足變量的數據類型，並且在數據類型有效範圍內變化 

*/
class VariableTest {
	public static void main(String[] args) {
		char gender;
			gender = '男'; //第一個聲明的變量值為初始化，預設值
			gender = '女'; 
			
			//char是一種數據類型，gender為變量名，男、女是變量值
			//char賦值使用''
		int age = 10;

		byte b1 = 127;
		// 若b1=128 則超過了byte的範圍，不編譯不通過

		System.out.println("age = "+age);
		//System.out.println("age = "age); 這樣編譯不過，要print兩個以上的東西的話，必須要寫+，作為連接詞。
	}

	public static void main123(String[] args){
		int age = 12;
		System.out.println(age);
	}
}
