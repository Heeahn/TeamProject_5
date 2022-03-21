package KJH;

import java.util.Scanner;

public class Parking_menu {
	
	final static int MAX =12;
	String[] box = new String[MAX];
	Parking_state state = new Parking_state();
	Parking_In in = new Parking_In();
	Parking_exit exit = new Parking_exit();
	Tower_money money = new Tower_money();
	public void info(Scanner temp) {
		System.out.println("======== 주차 프로그램 =========");
		System.out.println();
		state.create(MAX);
		state.print_state();
		select(temp);
	}
	
	public void select(Scanner temp) {
		int ch = 1;
		System.out.println("============================");
		try {
		while(true) {
			
			System.out.println("1.입차 2.출차 3.매출확인 4.종료");
			ch=temp.nextInt();
			if(ch == 1) {
				System.out.println(" \t입차 메뉴 선택 ");
				in.in(state, temp);
			}
			else if(ch == 2) {
				System.out.println(" \t출차 메뉴 선택 ");
				exit.out(state, temp);
			}
			else if(ch == 3) {
				System.out.println(" \t\t매출 확인 ");
				money.inform(state,temp);
			}
			else if(ch == 4) {
				System.out.println(" 종료 ");
				break;
			}
			else {System.out.println(" 잘못된 입력입니다.");}
			}
		}catch(Exception e) {temp = new Scanner(System.in);}
	}
//	array_position
}
