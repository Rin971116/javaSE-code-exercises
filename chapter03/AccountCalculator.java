import java.util.*;


class AccountCalculator{

	int allMoney;
	int[] details = new int[];
	int i = 0;

	void setIncome(int income){
		allMoney += income;
		storeDetails(income);
	}

	void setExpend(int expend){
		allMoney += expend;
		storeDetails(expend);
	}

	void storeDetails(int money){
		details[i] = money;
		i++;
	}
	
	void showDetails(){
		for(int money : details){
			System.out.println(money);
		}
	}
}


class goAccountCalculator{

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
							System.out.println("you chose 1");
							showDetails();
							break;
						case "2":
							System.out.println("請輸入你收入的金額:");
							setIncome(sc.nextInt());
							break;
						case "3": 
							System.out.println("請輸入你支出的金額(金額須加上-號):");
							setExpend(sc.nextInt());
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