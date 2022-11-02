import java.util.Scanner;

import Battle.Battle;
import Person.Monster;
import Person.Player;
import map.Map;

public class MainClass {
	public static void main(String[] args) {
		
		boolean set = true;
		Player p = new Player();
		Monster m = new Monster();
		Battle battle = new Battle();
		Map map = new Map();
		
		System.out.println("================================");
		System.out.println();
		System.out.println(" 탈출하지 못하면 가위바위보하는 미로지옥 ");
		System.out.println();
		System.out.println("================================");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("플레이어의 이름을 입력하세요>");
		String name = sc.nextLine();
		System.out.println();

		//플레이어 이름 세팅
		p.setName(name);
		
		map.display();
		while(set) {
			System.out.print("어디로 이동할까? >");
			p.playerMove();
			
			if(map.getMap()[p.getX()][p.getY()] == "●") {
//			if(map.map[p.getX()][p.getY()] == "●") {
				System.out.println("@@@@@@@@@@@@@@@탈출@@@@@@@@@@@@@@");
				break;
			}
			map.display(p.getX(), p.getY());
			set = battle.checkBattle(p, map);
			p.playerInfo();
			
			
		}
		
		System.out.println("게임 종료");

		
	}
}
