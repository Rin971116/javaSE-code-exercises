import java.util.*;


class AccountCalculator{

	int allMoney = 0;
	//以下為宣告動態陣列的方式
	ArrayList<Integer> details = new ArrayList<Integer>();

	void addMoney(int money){
		allMoney += money;
		details.add(money);
		System.out.println("已存入"+ money +"元，目前帳戶餘額為:"+ allMoney +"元");
	}

	void minusMoney(int money){
		allMoney -= money;
		details.add(-money);
		System.out.println("已扣款"+ money +"元，目前帳戶餘額為:"+ allMoney +"元");
	}
	
	void showDetails(){
		for(int money : details){
			/*錯誤寫法。待求證
			if(details.length == 0){
				System.out.println("無紀錄");
			}else*/ System.out.println(money);
		}
	}
}


class GoAccountCalculator{

	public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);

	AccountCalculator ac1 = new AccountCalculator();
	
	loopOption:while(true){					
					System.out.println("-------------------------------");
					System.out.println("1.收支明細");
					System.out.println("2.登記收入");
					System.out.println("3.登記支出");
					System.out.println("4.退出");
					System.out.println();
					System.out.println("請輸入1-4:");
					
					String option = sc.next();
					
					switch(option){
						case "1": 
							System.out.println("------帳戶紀錄------");
							ac1.showDetails();
							break;
						case "2":
							System.out.println("請輸入你收入的金額:");
							ac1.addMoney(sc.nextInt());
							break;
						case "3": 
							System.out.println("請輸入你支出的金額:");
							ac1.minusMoney(sc.nextInt());
							break;
						case "4": 
							System.out.println("正在退出...");
							break loopOption;
						default: System.out.print("輸入錯誤");
							break;
					}
				}
	}
}