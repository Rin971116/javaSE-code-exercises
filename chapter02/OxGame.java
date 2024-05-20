import java.util.*;



class  OxGame{
	String[][] player = new String[3][3];
	
	public boolean isSpace(int x , int y){
		if(player[x][y] == null){
			return true;
		}else{return false;
		}
	}

	public boolean checkWin(String[][] player){
		if( (player[0][0].equals(player[1][0]) && player[1][0].equals(player[2][0])) ||
			(player[0][1].equals(player[1][1]) && player[1][1].equals(player[2][1])) ||
			(player[0][2].equals(player[1][2]) && player[1][2].equals(player[2][2])) ||
			(player[0][0].equals(player[0][1]) && player[0][1].equals(player[0][2])) ||
			(player[1][0].equals(player[1][1]) && player[1][1].equals(player[1][2])) ||
			(player[2][0].equals(player[2][1]) && player[2][1].equals(player[2][2])) ||
			(player[0][2].equals(player[1][1]) && player[1][1].equals(player[2][0])) ||
			(player[0][0].equals(player[1][1]) && player[1][1].equals(player[2][2])) ){
		return true;
		}else{return false;}
	}
	
	public void runGame(){
		
		Scanner sc = new Scanner(System.in);
		
		int x,y;

		do{ x = sc.nextInt();
			y = sc.nextInt();
		}while(!isSpace(x,y));
		
		player[x][y] ="1"; //1表示下O
		
		if(checkWin(player)){
			System.out.println("O player win.");
		}
		
		do{ x = sc.nextInt();
			y = sc.nextInt();
		}while(!isSpace(x,y));
		
		player[x][y] ="2"; //2表示下X
		
		if(checkWin(player)){
			System.out.println("X player win.");
		}
	}
}

class OxGaming{
	public static void main(String[] args){
		OxGame ox1 = new OxGame();
		ox1.runGame();
	}
}