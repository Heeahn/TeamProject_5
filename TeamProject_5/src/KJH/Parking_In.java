package KJH;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Parking_In {
	
	
//	Parking_date date_array = new Parking_date(); 
	ArrayList<Parking_date> date_array = new ArrayList<>();
	void in(Parking_state state, Scanner scanner) {
		int position = 0;
		int car_num=0;
		int year =0;
		int month=0;
		int day=0;
		int hour =0;
		int min =0;
		
		
		System.out.println("=== ���� �Ͻ� ���� ��ġ�� ������ ===");
		System.out.println("���� :>  "); 
		position = (scanner.nextInt());
		int real_position = position-1;
		if(state.box[real_position].equals("[ ]")) {
			System.out.println("���� ��ȣ : "); car_num=scanner.nextInt();
			System.out.println("���� �� : "); year=scanner.nextInt();
			System.out.println("���� �� : "); month=scanner.nextInt();
			System.out.println("���� �� : "); day=scanner.nextInt();
			System.out.println("���� �� : "); hour=scanner.nextInt();
			System.out.println("���� �� : "); min=scanner.nextInt();
			
			state.box[real_position]="[O]";
			System.out.println((position)+" �� ���� �Ϸ�");
			
			Parking_date date = new Parking_date(car_num, year, month, day, hour, min,real_position);
			date_array.add(date);
			
			try { // ����[����]�� �߻��Ұ� ���� �ڵ� ���� ( ���� ) 				//  ���� ���   , �̾��=true[�ɼ�]
				FileOutputStream outputStream = new FileOutputStream("D:/java/����������.txt" , true );
				String �������� = car_num+","+year+","+month+","+day+","
								+hour+","+min+","+real_position+ "\n"; // , : �ʵ� ���п�   \n : ��ǰ ���п�
						outputStream.write( ��������.getBytes() ); // ���ڿ� -> ����Ʈ��
			}catch( Exception e ) { // ����[����] ó��[���] : Exception Ŭ����
			}
			System.out.println("�˸�]] �������� ���� �Ϸ� "); 
			
		}
		else System.err.println("�̹� �����Ǿ� �ִ� �����Դϴ�.");
		state.print_state();
		
		
	}
}
