package map;

import java.util.Random;

import shop.Shop;


public class Map {

	private String[][] map;//맵 면적
	private boolean[][] monster;//몬스터 위치
	private String shop;
	private String exit;
	private String player;
	private int[] shoplocation;//상점 위치
	private int[] exitlocation;//탈출 위치
	public Map() {
		super();
		shop = "▲";
		exit = "●";
		player = "■";
		shoplocation = new int[2];//x,y값
		exitlocation = new int[2];//x,y값
		String[] object = {shop,exit};
		int[][] location = {shoplocation,exitlocation}; //x,y값 배열을 담는 배열
		map = new String[7][7];
		map[0][0] = player;
		monster = new boolean[7][7];
		Random r = new Random();
		//몬스터의 위치 생성(랜덤)
		for(int i =0; i<10; i++) {
			 monster[r.nextInt(2, 7)][r.nextInt(2,7)] = true;
		}
		//오브젝트 생성 - 몬스터의 위치와 중복되지 않는 로직
		for(int i = 0; i<2; i++) {
			boolean run = true;
			while(run) {
				int random1 = r.nextInt(2,7);
				int random2 = r.nextInt(2,7);
				if(monster[random1][random2] == false && map[random1][random2] == null) {//중복 조건 제외
					map[random1][random2] = object[i];//맵 랜덤 위치에 오브젝트 저장
					location[i][0] = random1;//랜덤설정값 저장
					location[i][1] = random2;//랜덤설정값 저장
					run = false;
				}
			}
		}	
	}
	//초기 오브젝트 위치를 표시하고 출력하기 위한 메서드
	public void display() {
		for(int i = 0; i<7; i++) {
			for(int j = 0; j<7; j++) {
				if(map[i][j]==null) {
					System.out.printf("%2s","□");
				}  else System.out.printf("%2s",map[i][j]);
			}
			System.out.println();
		}
	}
	//오버로드 된 display 메서드 - 캐릭터의 움직임을 받아 출력하기 위함.
	public void display(int x ,int y) {
		map[x][y] = player;//매개변수로 위치값 받아서 표시
		if(x>0 || y>0) map[0][0]="□";
		for(int i = 0; i<7; i++) {
			for(int j = 0; j<7; j++) {
				if(map[i][j]==null) {
					System.out.printf("%2s","□");
				}  else System.out.printf("%2s",map[i][j]);
			}
			System.out.println();
		}
		map[x][y]= "□";//지나간 자리 흔적 지우기
		if(!map[shoplocation[0]][shoplocation[1]].equals(player)) {
			map[shoplocation[0]][shoplocation[1]] = shop; // shop을 지나가도 맵에 표시
		}
	}
	//오브젝트를 만났을 때 이벤트 발생
	public void event(int x , int y) {
		if(x == shoplocation[0] && y ==shoplocation[1]) {
			System.out.println("상점에 들어갑니다.");
			Shop.shop(null);
		} else if(x == exitlocation[0] && y ==exitlocation[1]) {
			System.out.println("탈출합니다.");
		} else if(monster[x][y] == true) {
			System.out.println("야생의 몬스터를 만났습니다.");
		} else {
			
		}
	}
	//get 메서드
	public String[][] getMap() {
		return map;
	}
	
	public boolean[][] getMonster() {
		return monster;
	}
	//몬스터가 죽었을 때 수정
	public void setMonster(boolean[][] monster) {
		this.monster = monster;
	}
	public String getShop() {
		return shop;
	}
	
	public String getExit() {
		return exit;
	}
	
	public String getPlayer() {
		return player;
	}
	public int[] getShoplocation() {
		return shoplocation;
	}
	public int[] getExitlocation() {
		return exitlocation;
	}
	
	
}
