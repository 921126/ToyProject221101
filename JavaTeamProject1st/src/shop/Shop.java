package shop;
import java.util.Scanner;
import Person.Player;
import map.Map;
import Battle.Battle;

public class Shop extends Player{

	public void hpPotion(Player p) {
		int money = p.getMoney();
			if(p.getMoney() >= 5) {
				p.setMoney(money-5);
				System.out.println("[체력 물약을 구매합니다.]");
				if(p.getHp() > 4) {
					p.setMoney(money-5);
					p.setHp(10);
				}else{
				p.setHp(p.getHp()+5);
				}
			}else if(money < 5) {
			System.out.println("[골드가 부족합니다.]");
		}

	}

	
	public void attckPotion(Player p) {
		int money = p.getMoney();
		if(money >= 10) {
			System.out.println("[공격력 물약을 구매합니다.]");
			p.setAttack(p.getAttack()+1);
			p.setMoney(money-10);
		}else if(p.getMoney() < 10) {
			System.out.println("[골드가 부족합니다.]");
		}
	}
	
	public static void shop(Player p) {
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		Shop shop = new Shop();
		while(flag) {
			System.out.println("[메뉴: 1.체력 물약(5 골드) | 2.공격력 물약(10 골드) | 3. 나가기]");
			System.out.print("메뉴 > ");
			
			int menu;
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				System.out.println("1~3 숫자로 다시 입력하세요!");
				scan.nextLine();
				continue;
			}
			
			switch (menu) {
			case 1:
				shop.hpPotion(p);
				break;
			case 2:
				shop.attckPotion(p);
				break;
			case 3:
				System.out.println("[상점을 나갑니다.]");
				flag = false;
				break;
			default:
				System.out.println("[올바른 메뉴를 입력해주세요.]");
				break;
			}
		}
	}
}
