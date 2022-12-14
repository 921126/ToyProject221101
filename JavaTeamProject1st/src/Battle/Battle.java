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
			str = "π€πΎπ€πΎπ€πΎπ€πΎπ€πΎπ€πΎπ€πΎπ€πΎ  κ°μ  π€πΎπ€πΎπ€πΎπ€πΎπ€πΎπ€πΎπ€πΎπ€πΎ";
		case 2:
			str = "βββββββ  λ°μ  βββββββ";
			break;
		case 3:
			str = "π€π€π€π€π€π€π€  λ³΄   π€π€π€π€π€π€π€";
			break;

		default:
			str = "λ€μ μλ ₯νμΈμ~";
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
		
		System.out.println("!!!!!!!!! λͺ¬μ€ν°λ₯Ό λ§λ¬μ΅λλ€. κ°μλ°μλ³΄ λ°°νμ μμν©λλ€.");
		System.out.println();
		
		Bt : while(true) {
			
			// κΈ°λ³Έ μΆλ ₯λ¬Έ
			metMonster();
			System.out.println("νλ μ΄μ΄ νμ¬ μν > : " + p.getHp());
			System.out.println("λͺ¬μ€ν° νμ¬ μ²΄λ ₯ > : " + mHp);
			
			System.out.println("------------------------");
			System.out.println("1. κ°μ | 2. λ°μ | 3. λ³΄");

			String str;
			int num;
			try {
				str = scan.nextLine();
				num = Integer.parseInt(str);
				if(!(0 <= num && num <= 3)) {
					Exception e = new Exception("1~3 μ¬μ΄ μ«μλ‘ λ€μ μλ ₯νμΈμ");
					System.out.println(e.getLocalizedMessage());
					continue Bt;
				}
			} catch (Exception e) {
				System.out.println("1~3 μ«μλ‘ λ€μ μλ ₯νμΈμ");
				System.out.println();
				System.out.println();
				continue Bt;
			}
			
			System.out.println("νλ μ΄μ΄ μ ν : " + Battle.printOutSelect(num));
			
			int random = (int)(Math.random()*3)+1;
			System.out.println("λͺ¬μ€ν°  μ ν : " + Battle.printOutSelect(random));
			System.out.println();
			System.out.println();
			int result = num - random;
			
			switch (result) {
			
			case 1: case -2:
				System.out.println("(βοΎγ?οΎ)β λͺ¬μ€ν°λ₯Ό κ³΅κ²©ν©λλ€ β(οΎγ?οΎβ)");
				System.out.println();
				System.out.println();
				mHp -= pAttack;
				if(mHp <= 0) {
					System.out.println("λͺ¬μ€ν°κ° μ°λ¬μ‘μ΅λλ€.");
					System.out.println("===========μ ν¬ μΉλ¦¬!!!===========");
					int ranMoney = (int)((Math.random()*10)+1);
					p.setMoney(p.getMoney() + ranMoney);
					System.out.println("μΉλ¦¬ λ³΄μμΌλ‘ "+ ranMoney + "μμ μ»μμ΅λλ€!");
					
					m.getMonster()[p.getX()][p.getY()] = false;
//					m.monster[p.getX()][p.getY()] = false;
					m.display(p.getX(), p.getY());
					return true;
					
				}
				break;
				
			case -1: case 2:
				System.out.println("(T_T) λͺ¬μ€ν°μκ² κ³΅κ²©λΉνμ΅λλ€. (T_T)");
				System.out.println();
				System.out.println();
				p.setHp(p.getHp()-mAttack);
				if(p.getHp() <= 0) {
					System.out.println("νλ μ΄μ΄κ° μ°λ¬μ‘μ΅λλ€.");
					if(p.getlife() == 0) {
						System.out.println("............Game over...........");
						System.out.println("νμΆ μ€ν¨ γ γ γ γ γ γ  κ²μμ€λ²");
						System.exit(0);
						return false;
					}
					else {
						p.setlife(p.getlife()-1);
						System.out.println("λ¨μ λμ νμ: " + (p.getlife()+1));
						p.setHp(10);
						m.display(p.getX(), p.getY());
						return true;
					}
				}
				break;
				
			default:
				System.out.println("οΌΌοΌγ_ο½οΌοΌ λΉκ²Όμ΅λλ€.");
				System.out.println();
				System.out.println();
				break;
			}
		}
	}
}
