class StairRunTest {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}


class StairRun{
	for(num=1 ; num<=2 ; num++){
		int getKind(int times){
			if(times == 1){
				return num;
			}else{
				return num + getKind(times - 1);
			}
		}
	}
}