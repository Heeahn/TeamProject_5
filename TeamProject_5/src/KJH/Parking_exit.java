package KJH;

import java.awt.datatransfer.Clipboard;
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
			FileInputStream inputStream = new FileInputStream("D:/java/����������.txt"); // 1. ���� �Է°�ü ( ���ϰ��)
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
				System.out.println("���� �Ͻðڽ��ϱ�?"); 
				System.out.println("1.�� 2.�ƴϿ�");
				int sc= scanner.nextInt();
				if(sc==1) {
					int year1=	(int) (yearNow-board.get������());
					int month1=	(int) (monthNow-board.get������());
					int day1=	(int) (dayNow-board.get������());
					int time1=	(int) (timeNow-board.get������());
					int min1=	(int) (minNow-board.get������());
					int cal_money = 0;
//					
//					
//					
//					
//					long year2 = board.get������()*31104000L;//(60*60*24*30*12);
////					double year3 = board.get������()*31104000;//(60*60*24*30*12);
//					long month2=board.get������()*(60*60*24*30L);
//					long day2=board.get������()*(60*60*24L);
//					long time2=board.get������()*(60*60L);
//					long min2=board.get������()*(60L);
//					long total_park_time = year2+month2+day2+time2+min2;
//
//				
//					long out5 =System.currentTimeMillis();//(�и���)
//					long out6 = (out5/1000)+62168472000L; //(1970�� ���� /�� ����)
//					System.out.println("����ð� ��:"+out6);
//					System.out.println("�������� �ð�:"+total_park_time);//(��);
//					long final_time = out6-total_park_time; //(�ʴ���)
//				
//					long cal_time_min = (out6)/60;
//					long cal_month = cal_time_min/10000;
//					System.out.println("����:"+cal_time_min);
//					System.out.println("����:"+cal_month);
//					System.out.println("��Ž:"+final_time); // ��
//					==== �����
					if(month1<1&&day1>=1) {// 1�� �̸� �Ϸ� �̻�
						
						cal_money = day1*50000;
						
					}
					else if(month1>=1&&day1>=1) { //1�� �̻� 
						cal_money = day1*50000+(month1*30)*50000;
					}
					else if(day1<1&&time1>1) { //�Ϸ� �̸� 1
						cal_money =(min1/10)*1000 + time1*6000;;
						
					}
					else if(min1>30&&time1>=1) { // �Ϸ� �̸� 2
						cal_money =(min1/10)*1000 + time1*6000;
						
					}
					else if(time1<1&&min1<60) { // �ѽð� �̸�
						cal_money =(min1/10)*1000; 
						
					}
					else if(min1>30&&min1<60) {// �ѽð� �̸� 30�� �ʰ�
						cal_money = (min1/10)*1000;
						}
					else {cal_money=0;} // �� �� (30�� �̸�)
					
					System.out.println("������� :" +cal_money+"�Դϴ�.");
					
					state.box[board.get������ġ()]="[ ]";
					System.out.println(board.get������ġ());
					
//					

//					==============
//					Parking_date cal= new Parking_date(num, board.get������(), board.get������(), board.get������(), 
//						board.get������(), board.get������(), board.get������ġ()+1, cal_money);
					
					Parking_date cal= new Parking_date(num, (int)yearNow, (int)monthNow, (int)dayNow, 
							(int)timeNow, (int)minNow, board.get������ġ()+1, cal_money);
				
				try { // ����[����]�� �߻��Ұ� ���� �ڵ� ���� ( ���� ) 				//  ���� ���   , �̾��=true[�ɼ�]
					FileOutputStream outputStream = new FileOutputStream("D:/java/�������.txt",true  );
					String �������� = num+","+(int)yearNow+","+(int)monthNow+","+(int)dayNow+","
									+(int)timeNow+","+(int)minNow+","+(board.get������ġ()+1)+","+cal_money+ "\n"; // , : �ʵ� ���п�   \n : ��ǰ ���п�
							outputStream.write( ��������.getBytes() ); // ���ڿ� -> ����Ʈ��
				}catch( Exception e ) { // ����[����] ó��[���] : Exception Ŭ����
				}
				System.out.println("�˸�]] �������� ���� �Ϸ� "); 
				
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
