import java.util.Scanner;

import Battle.Battle;
import Person.Monster;
import Person.Player;
import map.Map;
import shop.Shop;

class gameStart {
	
	static void game() {
		
		System.out.println("================================");
		System.out.println();
		System.out.println(" 탈출하지 못하면 가위바위보하는 미로지옥 ");
		System.out.println();
		System.out.println("================================");
	}
	
}

public class MainClass {
	public static void main(String[] args) {
		
		boolean set = true;
		Player p = new Player();
		Monster m = new Monster();
		Battle battle = new Battle();
		Map map = new Map();
		
		//게임시작호출
		gameStart.game();
		
		//캐릭터 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("플레이어의 이름을 입력하세요>");
		String name = sc.nextLine();
		System.out.println();
		
		//플레이어 이름 세팅
		p.setName(name);
		
		//최초 맵 호출
		map.display();
		
		//게임 실행 반복문
		while(set) {
			System.out.print("\n"+"어디로 이동할까? >");
			p.playerMove();

			if(map.getMap()[p.getX()][p.getY()] == "●") {
				System.out.println("@@@@@@@@@@@@@@@탈출@@@@@@@@@@@@@@");
				break;
			}
			
			//상점 이벤트 발생
			if(map.getMap()[p.getX()][p.getY()] == "▲") {
				Shop.shop(p);
			}
			
			//캐릭터 이동 맵 호출
			map.display(p.getX(), p.getY());
			set = battle.checkBattle(p, map);
			//캐릭터 정보 호출
			
			p.playerInfo();
		}
		
		sc.close();
	}
}
