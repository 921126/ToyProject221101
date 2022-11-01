package Person;

public class Monster extends Common{
	
	private int x = 0;
	private int y = 0;
	
	//생성자
	public Monster() {
		setHp(9);
		setAttack(2);
	}
	//게터 세터
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
	public void MonsterInfo() {
		System.out.println(" = = = 몬스터 정보  = = = ");
		System.out.println(" 체력:" + getHp() + " ◆ " + "공격력:" + getAttack());
		System.out.println(" = = = = = = = = = = =");
	}
	

}
