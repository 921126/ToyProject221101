package map;

import java.util.Random;


public class Map {
	private String[][] map;
	private boolean[][] monster;
	private String shop;
	private String exit;
	private String player;
	
	public Map() {
		super();
		shop = "▲";
		exit = "●";
		player = "■";
		String[] object = {shop,exit};
		map = new String[7][7];
		map[0][0] = player;
		monster = new boolean[7][7];
		Random r = new Random();
		for(int i =0; i<4; i++) {
			 monster[r.nextInt(2, 7)][r.nextInt(2,7)] = true;
		}
		
		for(int i = 0; i<2; i++) {
			boolean run = true;
			while(run) {
				int random1 = r.nextInt(2,7);
				int random2 = r.nextInt(2,7);
				if(monster[random1][random2] == false && map[random1][random2] == null) {
					map[random1][random2] = object[i];
					run = false;
				}
			}
		}	
	}
	public void display() {
		for(int i = 0; i<7; i++) {
			for(int j = 0; j<7; j++) {
				if(map[i][j]==null) {
					System.out.printf("%3s","□");
				}  else System.out.printf("%3s",map[i][j]);
			}
			System.out.println();
		}
	}
	public void display(int x ,int y) {
		map[x][y] = player;
		if(x>0 || y>0) map[0][0]=null;
		for(int i = 0; i<7; i++) {
			for(int j = 0; j<7; j++) {
				if(map[i][j]==null) {
					System.out.printf("%3s","□");
				}  else System.out.printf("%3s",map[i][j]);
			}
			System.out.println();
		}
		map[x][y]= null;
	}
	
}
