package Person;

public class Player extends Common{
	
	private String name = null;
	private int money = 0;
	private int x = 0;
	private int y = 0;
	
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

	//메서드
	public void playerInfo() {
		System.out.println(" = = = = = = = = 캐릭터 정보 = = = = = = = =");
		System.out.println(" 이름:" + getName() + " ◆ " + "체력:" + getHp() + " ◆ " + "공격력:" + getAttack() + " ◆ " + "돈:" + getMoney() + "골드" );
		System.out.println(" = = = = = = = = = = = = = = = = = = = = =");
	}
	
}
