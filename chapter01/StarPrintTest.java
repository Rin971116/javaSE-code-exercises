class StarPrintTest {
	public static void main(String[] args) {
		System.out.println("*    *");
		System.out.println("*\t*");//	\t表示空7格空白鍵的長度，必須得是左上往右下這種槓\才行
		System.out.println("*\t\t*");//	表示空7格在空7格
		System.out.println("*\n*");//	\n表示換行
		System.out.println("*\n\n*");//	表示換行再換行
		//注意!!使用跳脫序列，不需要加"+"連接符
		System.out.println("林\n廷\n胤");
		System.out.println("\n林\n\n廷\n胤");
		System.out.println("\n林\n\n廷\n\n胤");
		System.out.println("顯示更多\n\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n啥也沒有");
	}
}
