import java.util.Scanner;

import Person.Monster;
import Person.Player;
import map.Map;

public class MainClass {
	public static void main(String[] args) {
		
		
		Player p = new Player();
		Monster m = new Monster();
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
		
		map.display();
		while(true) {
			System.out.print("어디로 이동할까? >");
			p.playerMove();

			map.display(p.getX(),p.getY());
			map.event(p.getX(),p.getY());
			p.playerInfo();
		}
		

		
	}
}
