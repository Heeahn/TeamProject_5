package KJH;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Parking_exit {
	
	public Parking_exit() {}
	

	void out(Parking_state state, Scanner scanner) {
		
		
		
		LocalDateTime localdate=LocalDateTime.now();
		ArrayList<Parking_date> date_array = new ArrayList<>();
		
		try { // try { } �ȿ� ����[����] �߻��Ұ� �ϴ� �ڵ� �ֱ� ( ���� )
			FileInputStream inputStream = new FileInputStream("C:/Users/lvblu/Desktop/JAVA/����������.txt"); // 1. ���� �Է°�ü ( ���ϰ��)
			byte[] bytes = new byte[1024];
			inputStream.read( bytes );
			String ���ϳ��� = new String( bytes );
			String[] ����������� = ���ϳ���.split("\n"); 
			int i=0;
			for( String temp1 : ����������� ) {
				if(i+1 ==�����������.length) break;
				String[] �ʵ��� = temp1.split(","); //  8����
				Parking_date parking_date = new Parking_date( Integer.parseInt(�ʵ���[0]) , 
						Integer.parseInt( �ʵ���[1])  ,
						Integer.parseInt( �ʵ���[2])  ,
						Integer.parseInt( �ʵ���[3])  ,
						Integer.parseInt( �ʵ���[4])  ,
						Integer.parseInt( �ʵ���[5])  ,
						Integer.parseInt( �ʵ���[6]) );
				// ���ڿ� --> ������ ��ȯ [  Integer.parseInt("���ڿ�") ] // 
				// ����Ʈ ���� 
				date_array.add(parking_date);
				i++;
				}
			
		}catch( Exception e ) { // catch : ���� ��� -> Exception Ŭ������ ��ü�� ���� 
		}
	
		Calendar calendar = Calendar.getInstance();
		
		long yearNow = calendar.get(Calendar.YEAR);
	    long monthNow = calendar.get(Calendar.MONTH) + 1;
	    long dayNow = calendar.get(Calendar.DAY_OF_MONTH);
	    long timeNow= calendar.get(Calendar.HOUR_OF_DAY);
	    long minNow= calendar.get(Calendar.MINUTE);
		
		int num =0;
		int real_num=num-1;
		System.out.println("�����Ͻ� ������ȣ�� �Է��ϼ���");
		num=scanner.nextInt();
//		int i =0;
		for (Parking_date board : date_array) {
			if(num==board.get������ȣ()) {
				System.out.println("������ȣ\t������\t������\t������\t������\t������\t������ġ");
				System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\n",
						board.get������ȣ(),board.get������(),board.get������(),
						board.get������(),board.get������(),board.get������(),
						board.get������ġ()+1);
				System.out.println("���� �Ͻðڽ��ϱ�?"); int sc= scanner.nextInt();
				System.out.println("1.�� 2.�ƴϿ�");
				if(sc==1) {
					int year1=Math.abs((int) (yearNow-board.get������()));
					int month1=Math.abs((int) (monthNow-board.get������()));
					int day1=Math.abs((int) (dayNow-board.get������()));
					int time1=Math.abs((int) (timeNow-board.get������()));
					int min1=Math.abs((int) (minNow-board.get������()));
					int cal_money = 0;
					
				
//					==== �����
					if(month1>=1&&day1>=1) {
						
						cal_money = 50000;
						
					}
					else if(day1<1&&time1>1) {
						cal_money =(min1/10)*1000 + time1*6000;;
						
					}
					else if(min1>30&&time1>=1) {
						cal_money =(min1/10)*1000 + time1*6000;
						
					}
					else if(time1<1&&min1<60) {
						cal_money =(min1/10)*1000; 
						
					}
					else if(min1>30&&min1<60) {
						cal_money = (min1/10)*1000;
						}
					else {cal_money=0;}
					
					if(cal_money>=50000) {
					cal_money = 50000;
					}
					System.out.println("������� :" +cal_money+"�Դϴ�.");
					
					state.box[board.get������ġ()]="[ ]";
					System.out.println(board.get������ġ());
//						state1.box[board.get������ġ()]="[ ]";
//					}
					//					====
//							if(min1<=30) {
//								System.out.println("������� ����");
//								cal_money = 0;
//							}
//							else if(min1>30) {
//								cal_money =(min1/10)*1000;
//								System.out.println("������� :" +cal_money+"�Դϴ�.");
//							}
//							else if(min1>30&&time1>=1) {
//								cal_money =(min1/10)*1000 + time1*6000;
//								System.out.println("������� :" +cal_money+"�Դϴ�.");
//							}
//							else if(time1>=1&&time1<24) {
//								cal_money =(min1/10)*1000 + time1*6000;;
//								System.out.println("������� :" +cal_money+"�Դϴ�.");
//							}
//							else {
//							cal_money = 50000;
//							System.out.println("������� :" +cal_money+"�Դϴ�.");
//							}
					
//					===
					
						
					
				Parking_date cal= new Parking_date(num, board.get������(), board.get������(), board.get������(), 
						board.get������(), board.get������(), board.get������ġ()+1, cal_money);
				
				try { // ����[����]�� �߻��Ұ� ���� �ڵ� ���� ( ���� ) 				//  ���� ���   , �̾��=true[�ɼ�]
					FileOutputStream outputStream = new FileOutputStream("C:/Users/lvblu/Desktop/JAVA/�������.txt",true  );
					String �������� = num+","+board.get������()+","+board.get������()+","+board.get������()+","
									+board.get������()+","+board.get������()+","+(board.get������ġ()+1)+","+cal_money+ "\n"; // , : �ʵ� ���п�   \n : ��ǰ ���п�
							outputStream.write( ��������.getBytes() ); // ���ڿ� -> ����Ʈ��
				}catch( Exception e ) { // ����[����] ó��[���] : Exception Ŭ����
				}
				System.out.println("�˸�]] �������� ���� �Ϸ� "); 
//				if(state1.box[board.get������ġ()].equals("[O]")) {
//					state1.box[board.get������ġ()]="[ ]";
//				}
				break;
				
				}
				else if(sc==2) {
					break;
				}
				else {System.out.println("�߸��� �Է°��Դϴ�.");}
			}
			
		
//		������ȣ / ��/��/��/��/��
		
		}
		state.print_state();
	
	}
	
}
