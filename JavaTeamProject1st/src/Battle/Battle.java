package Battle;

import java.util.Scanner;

import Person.Monster;
import Person.Player;


public class Battle {
	
	Scanner scan = new Scanner(System.in);
	
	private static String printOutSelect(int i) {
		String str = "";
		switch (i) {
		case 1:
			str = "가위";
			break;
		case 2:
			str = "바위";
			break;
		case 3:
			str = "보";
			break;

		default:
			str = "다시 입력하세요~";
			break;
		}
		
		return str;
	}
	
	public static void battle() {
		Player p = new Player();
		Monster m = new Monster();
		Scanner scan = new Scanner(System.in);
		int pHp = p.getHp();
		int pAttack = p.getAttack();
		int money = p.getMoney();
		int mHp = m.getHp();
		int mAttack = m.getAttack();
		
		System.out.println("!!!!!!!!! 몬스터를 만났습니다. 가위바위보 배틀을 시작합니다.");
		
		
		Bt : while(true) {
			System.out.println("플레이어 현재 상태 > : " + pHp);
			System.out.println("몬스터 현재 체력 > : " + mHp);
			
			System.out.println("------------------------");
			System.out.println("1. 가위 | 2. 바위 | 3. 보");
			int num = scan.nextInt();
			System.out.println("플레이어 선택 : " + Battle.printOutSelect(num));
			
			int random = (int)(Math.random()*3)+1;
			System.out.println("몬스터 선택 : " + Battle.printOutSelect(random));
			
			int result = num - random;
			
			switch (result) {
			
			case 1: case -2:
				System.out.println("이겼다!");
				mHp -= pAttack;
				if(mHp <= 0) {
					System.out.println("몬스터가 쓰러졌습니다.");
					System.out.println("전투 승리!!!");
					money += (int)((Math.random()*10)+1);
					break Bt;
				}
				break;
				
			case -1: case 2:
				System.out.println("졌다!");
				pHp -= mAttack;
				if(pHp <= 0) {
					System.out.println("플레이어가 쓰러졌습니다.");
					System.out.println("게임 오버");
					break Bt; //배틀은 끝나는데 게임을 아예 종료시켜야 함
				}
				break;
				
			default:
				System.out.println("비겼다!");
				break;
			}
		}
		scan.close();
	}
}
