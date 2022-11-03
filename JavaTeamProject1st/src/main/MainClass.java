package main;
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
	public static int count = 0;
	
	public static void main(String[] args) {
		
		
		boolean set = true;
		Monster m = new Monster();
		Battle battle = new Battle();
		
		//게임시작호출
		gameStart.game();
		
		//캐릭터 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("플레이어의 이름을 입력하세요>");
		String name = sc.nextLine();
		System.out.println();
		
		//플레이어 이름 세팅
		
		
		//게임 횟수
		int count = 0;
		int hp = 10;
		int attack = 3;
		int money = 0;
		int life = 2;
		
		while(count<5) {
			Player p = new Player();
			p.setName(name);
			p.setAttack(attack);
			p.setHp(hp);
			p.setMoney(money);
			p.setlife(life);
			Map map = new Map();
			//최초 맵 호출
			map.display();
			
			//게임 실행 반복문
			while(set) {
				
				//캐릭터 정보 호출
				p.playerInfo();
				System.out.print("\n"+"어디로 이동할까? >");
				p.playerMove();
				map.clear();
				
				if(map.getMap()[p.getX()][p.getY()] == "●") {
					System.out.println("다음 맵으로 이동합니다.");
					p.setX(0);
					p.setY(0);
					hp = p.getHp();
					attack = p.getAttack();
					money = p.getMoney();
					life = p.getlife();
					
					count++;
					break;
				}
				
				//상점 이벤트 발생
				if(map.getMap()[p.getX()][p.getY()] == "▲") {
					Shop.shop(p);
				}
				
				//캐릭터 이동 맵 호출
				map.display(p.getX(), p.getY());
				set = battle.checkBattle(p, map);
				
				
			}
			
			
			
		}
		System.out.println("🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉");
		System.out.println("축하합니다! 탈출하셨습니다!!!!!!!");
		
		sc.close();
	}
}
