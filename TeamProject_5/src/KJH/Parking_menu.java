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
		System.out.println("======== ���� ���α׷� =========");
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
			
			System.out.println("1.���� 2.���� 3.����Ȯ�� 4.����");
			ch=temp.nextInt();
			if(ch == 1) {
				System.out.println(" \t���� �޴� ���� ");
				in.in(state, temp);
			}
			else if(ch == 2) {
				System.out.println(" \t���� �޴� ���� ");
				exit.out(state, temp);
			}
			else if(ch == 3) {
				System.out.println(" \t\t���� Ȯ�� ");
				money.inform(state,temp);
			}
			else if(ch == 4) {
				System.out.println(" ���� ");
				break;
			}
			else {System.out.println(" �߸��� �Է��Դϴ�.");}
			}
		}catch(Exception e) {temp = new Scanner(System.in);}
	}
//	array_position
}
