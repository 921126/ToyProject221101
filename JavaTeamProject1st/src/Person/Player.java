package Person;

import java.util.Scanner;

public class Player extends Common{

	private String name = null;
	private int money = 0;
	private int x = 0;
	private int y = 0;
	private int life = 0;

	//생성자
	public Player() {
		setHp(10);
		setAttack(3);
	}

	//getter /  setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
		
	public int getlife() {
		return life;
	}
	
	public void setlife(int life) {
		this.life = life;
	}

	//메서드
	public void playerInfo() {
		System.out.println();
		System.out.println(" = = = = = = = 캐릭터 정보 = = = = = = =");
		System.out.println(" 이름:" + getName() + " ◆ " + "체력:" + getHp() + " ◆ " + "공격력:" + getAttack() + " ◆ " + "돈:" + getMoney() + "골드" );
		System.out.println(" = = = = = = = = = = = = = = = = = = =");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void playerMove() {
		int moveX = 0;
		int moveY = 0;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		switch (str) {
		case "w": case "W":
			
			if(getX() == 0) {
				System.out.println("이동이 불가능합니다.");
			}else {
				moveX = getX()-1;
				setX(moveX);
			}

			break;
		case "a": case "A":
			if(getY() == 0) {
				System.out.println("이동이 불가능합니다.");
			}else {
				moveY = getY()-1;
				setY(moveY);
			}
			break;
		case "s": case "S":
			if(getX() == 6) {
				System.out.println("이동이 불가능합니다.");
			}else {
				moveX = getX()+1;
				setX(moveX);
			}
			break;
		case "d": case "D":
			if(getY() == 6) {
				System.out.println("이동이 불가능합니다.");
			}else {
				moveY = getY()+1;
				setY(moveY);
			}
			break;
		default:
			System.out.println(" w a s d 키로 입력해주세요.");
			break;
		}
	}

}
