package shop;
import java.util.Scanner;
import Person.Player;

public class Shop extends Player{
	int money = getMoney();
	int hp = getHp();
	int attack = getAttack();
	
	public void hpPotion() {
			if(money >= 5) {
				System.out.println("[체력 물약을 구매합니다.]");
				if(hp > 4) {
					hp = 10;
				}else{
				hp += 5;
				money -= 5;
				}
			}else if(money < 5) {
			System.out.println("[골드가 부족합니다.]");
		}
	}
	
	public void attckPotion() {
		if(money >= 10) {
			System.out.println("[공격력 물약을 구매합니다.]");
			attack += 1;
			money -= 10;
		}else if(money < 10) {
			System.out.println("[골드가 부족합니다.]");
		}
	}
	
	public static void shop() {
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		Shop shop = new Shop();
		while(flag) {
			System.out.println("[메뉴: 1.체력 물약 | 2.공격력 물약 | 3. 나가기]");
			System.out.print("메뉴 > ");
			int menu = scan.nextInt();
			switch (menu) {
			case 1:
				shop.hpPotion();
				break;
			case 2:
				shop.attckPotion();
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
