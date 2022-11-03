package Battle;

import java.util.Scanner;

import Person.Monster;
import Person.Player;
import map.Map;


public class Battle {
	Scanner scan = new Scanner(System.in);

	private static void metMonster() {
		System.out.println("|\\_/|"); 
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |" );
		System.out.print("||_/=\\\\__|");
		System.out.println();
	}
	
	
	private static String printOutSelect(int i) {
		String str = "";
		switch (i) {
		case 1:
			str = "🤘🏾🤘🏾🤘🏾🤘🏾🤘🏾🤘🏾🤘🏾🤘🏾  가위  🤘🏾🤘🏾🤘🏾🤘🏾🤘🏾🤘🏾🤘🏾🤘🏾";
		case 2:
			str = "✊✊✊✊✊✊✊  바위  ✊✊✊✊✊✊✊";
			break;
		case 3:
			str = "🤚🤚🤚🤚🤚🤚🤚  보   🤚🤚🤚🤚🤚🤚🤚";
			break;

		default:
			str = "다시 입력하세요~";
			break;
		}
		
		return str;
	}
	
	
	public boolean checkBattle(Player p, Map m) {
		if(m.getMonster()[p.getX()][p.getY()] == true) {
			return battle(p, m);
		}
		return true;
	}
	
	
	
	
	public static boolean battle(Player p, Map m) {
		Monster monster = new Monster();
		Scanner scan = new Scanner(System.in);
		int pHp = p.getHp();
		int pAttack = p.getAttack();
		int money = p.getMoney();
		int mHp = monster.getHp();
		int mAttack = monster.getAttack();
		
		System.out.println("!!!!!!!!! 몬스터를 만났습니다. 가위바위보 배틀을 시작합니다.");
		System.out.println();
		
		Bt : while(true) {
			
			// 기본 출력문
			metMonster();
			System.out.println("플레이어 현재 상태 > : " + p.getHp());
			System.out.println("몬스터 현재 체력 > : " + mHp);
			
			System.out.println("------------------------");
			System.out.println("1. 가위 | 2. 바위 | 3. 보");

			String str;
			int num;
			try {
				str = scan.nextLine();
				num = Integer.parseInt(str);
				if(!(0 <= num && num <= 3)) {
					Exception e = new Exception("1~3 사이 숫자로 다시 입력하세요");
					System.out.println(e.getLocalizedMessage());
					continue Bt;
				}
			} catch (Exception e) {
				System.out.println("1~3 숫자로 다시 입력하세요");
				System.out.println();
				System.out.println();
				continue Bt;
			}
			
			System.out.println("플레이어 선택 : " + Battle.printOutSelect(num));
			
			int random = (int)(Math.random()*3)+1;
			System.out.println("몬스터  선택 : " + Battle.printOutSelect(random));
			System.out.println();
			System.out.println();
			int result = num - random;
			
			switch (result) {
			
			case 1: case -2:
				System.out.println("(☞ﾟヮﾟ)☞ 몬스터를 공격합니다 ☜(ﾟヮﾟ☜)");
				System.out.println();
				System.out.println();
				mHp -= pAttack;
				if(mHp <= 0) {
					System.out.println("몬스터가 쓰러졌습니다.");
					System.out.println("===========전투 승리!!!===========");
					int ranMoney = (int)((Math.random()*10)+1);
					p.setMoney(p.getMoney() + ranMoney);
					System.out.println("승리 보상으로 "+ ranMoney + "원을 얻었습니다!");
					
					m.getMonster()[p.getX()][p.getY()] = false;
//					m.monster[p.getX()][p.getY()] = false;
					m.display(p.getX(), p.getY());
					return true;
					
				}
				break;
				
			case -1: case 2:
				System.out.println("(T_T) 몬스터에게 공격당했습니다. (T_T)");
				System.out.println();
				System.out.println();
				p.setHp(p.getHp()-mAttack);
				if(p.getHp() <= 0) {
					System.out.println("플레이어가 쓰러졌습니다.");
					if(p.getlife() == 0) {
						System.out.println("............Game over...........");
						System.out.println("탈출 실패 ㅠㅠㅠㅠㅠㅠ 게임오버");
						System.exit(0);
						return false;
					}
					else {
						p.setlife(p.getlife()-1);
						System.out.println("남은 도전횟수: " + (p.getlife()+1));
						p.setHp(10);
						m.display(p.getX(), p.getY());
						return true;
					}
				}
				break;
				
			default:
				System.out.println("＼（〇_ｏ）／ 비겼습니다.");
				System.out.println();
				System.out.println();
				break;
			}
		}
	}
}
