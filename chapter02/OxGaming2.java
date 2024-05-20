import java.util.*;

class PointXY{

	char OX;

	public PointXY(char OX){
		this.OX = OX;
	}

	public char getOX(){
		return OX;
	}
}

class  OxGame{
	
	PointXY[][] player = new PointXY[3][3];
	
	public boolean isSpace(int x , int y){
		if(x<=2 && x>=0 && y<=2 && y>=0){
			if(player[x][y].getOX() == '*'){
				return true;
				}else{
				System.out.println("!你輸入的座標已被使用，請重新輸入!");
				return false;
				}
		}System.out.println("!你輸入的座標錯誤，請重新輸入!");
		return false;
	}

	public boolean checkWin(PointXY[][] player){
		if( (player[0][0].getOX() == player[1][0].getOX() && player[1][0].getOX() == player[2][0].getOX() && player[2][0].getOX() != '*') ||
			(player[0][1].getOX() == player[1][1].getOX() && player[1][1].getOX() == player[2][1].getOX() && player[2][1].getOX() != '*') ||
			(player[0][2].getOX() == player[1][2].getOX() && player[1][2].getOX() == player[2][2].getOX() && player[2][2].getOX() != '*') ||
			(player[0][0].getOX() == player[0][1].getOX() && player[0][1].getOX() == player[0][2].getOX() && player[0][2].getOX() != '*') ||
			(player[1][0].getOX() == player[1][1].getOX() && player[1][1].getOX() == player[1][2].getOX() && player[1][2].getOX() != '*') ||
			(player[2][0].getOX() == player[2][1].getOX() && player[2][1].getOX() == player[2][2].getOX() && player[2][2].getOX() != '*') ||
			(player[0][2].getOX() == player[1][1].getOX() && player[1][1].getOX() == player[2][0].getOX() && player[2][0].getOX() != '*') ||
			(player[0][0].getOX() == player[1][1].getOX() && player[1][1].getOX() == player[2][2].getOX() && player[2][2].getOX() != '*') ){
		return true;
		}else{return false;}
	}
	
	public void runGame(){
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<=2; i++){
			for(int j=0; j<=2; j++){
				player[i][j] = new PointXY('*');
			}
		}
		
		int x,y;

				System.out.println("遊戲開始!" + "\n");
				System.out.println("遊戲介紹:" + "\n");
				System.out.println("(0,2)" + "\t" +"(1,2)" + "\t" +"(2,2)");
				System.out.println("(0,1)" + "\t" +"(1,1)" + "\t" +"(2,1)");
				System.out.println("(0,0)" + "\t" +"(1,0)" + "\t" +"(2,0)");
				System.out.println();

		runloop:
			for(int round = 1; round<=5 ; round++){
							
				// 2. 輸入座標
				do{ System.out.println("Now, O Player turn!!");
					System.out.println("輸入任意數字繼續遊戲，投降請輸入0");
				
					int userXIsExit = sc.nextInt();
					if(userXIsExit == 0){
						System.out.println("X player win.");
						break runloop;
					}

					System.out.println("請輸入座標(x,y)的x:");
					x = sc.nextInt();
					System.out.println("請輸入座標(x,y)的y:");
					y = sc.nextInt();
				}while(!isSpace(x,y));
				
			
				player[x][y] = new PointXY('O'); //1表示下O

				System.out.println("-------------------------------------------------------------");
				System.out.println();
				System.out.println(player[0][2].getOX()+"\t" +player[1][2].getOX()+"\t" +player[2][2].getOX());
				System.out.println(player[0][1].getOX()+"\t" +player[1][1].getOX()+"\t" +player[2][1].getOX());
				System.out.println(player[0][0].getOX()+"\t" +player[1][0].getOX()+"\t" +player[2][0].getOX());
				System.out.println();
				System.out.println("-------------------------------------------------------------");
				System.out.println(" * :空白處");
				System.out.println("\n");
				
				if(checkWin(player)){
					System.out.println("O player win.");
					break runloop;
				}if(round == 5){
					System.out.println("Tie.");
					break runloop;
				}

				do{ System.out.println("Now, X Player turn!!");
					System.out.println("輸入任意數字繼續遊戲，投降請輸入0");
				
					int userYIsExit = sc.nextInt();
					if(userYIsExit == 0){
						System.out.println("O player win.");
						break runloop;					
					}

					System.out.println("請輸入座標(x,y)的x:");
					x = sc.nextInt();
					System.out.println("請輸入座標(x,y)的y:");
					y = sc.nextInt();
				}while(!isSpace(x,y));
				
				player[x][y] = new PointXY('X'); //2表示下X

				System.out.println("-------------------------------------------------------------");
				System.out.println();
				System.out.println(player[0][2].getOX()+"\t" +player[1][2].getOX()+"\t" +player[2][2].getOX());
				System.out.println(player[0][1].getOX()+"\t" +player[1][1].getOX()+"\t" +player[2][1].getOX());
				System.out.println(player[0][0].getOX()+"\t" +player[1][0].getOX()+"\t" +player[2][0].getOX());
				System.out.println();
				System.out.println("-------------------------------------------------------------");
				System.out.println(" * :空白處");
				System.out.println("\n");
				
				if(checkWin(player)){
					System.out.println("X player win.");
					break runloop;
				}
			}
	}
}

class OxGaming2{
		public static void main(String[] args){
			OxGame ox1 = new OxGame();
			ox1.runGame();
			Scanner sc = new Scanner(System.in);
			System.out.println("Game Over! Do you want one more game?(Y or N)");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("Y")){
				ox1 = new OxGame();
				ox1.runGame();
				}else{System.out.println("Game Closing , goodbye~");
					 }
				
		}
}
