package KJH;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Tower_money {
	
	
	public Tower_money() {}
	
	void inform(Parking_state state,Scanner scanner) {
		
		ArrayList<Parking_date> money_array = new ArrayList<>();
		try { // try { } �ȿ� ����[����] �߻��Ұ� �ϴ� �ڵ� �ֱ� ( ���� )
			FileInputStream inputStream = new FileInputStream("D:/java/�������.txt"); // 1. ���� �Է°�ü ( ���ϰ��)
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
						Integer.parseInt( �ʵ���[6])  ,
						Integer.parseInt( �ʵ���[7]) );
				// ���ڿ� --> ������ ��ȯ [  Integer.parseInt("���ڿ�") ] // 
				// ����Ʈ ���� 
				money_array.add(parking_date);
				i++;
				 
				}
			
		}catch( Exception e ) {System.out.println("�ε� ����");// catch : ���� ��� -> Exception Ŭ������ ��ü�� ���� 
		}
		System.out.print(" ���� :"); int year = scanner.nextInt();
		System.out.print(" �� :");	int month = scanner.nextInt();
		
		System.out.println("\n\n=============  �� �� �����  ==============");
		for(Parking_date temp : money_array) {
			
			if(year==((int)temp.get������())&&month==((int)temp.get������())) {
				
			
				
				System.out.println(" ���� �߻��� : "+temp.get������()+"\t ����� :"+temp.get�������()+"\n");
				
			}
			else {System.out.println(" ������� �����ϴ�."); break;}
		}
	
		
		�޷�( year , month );
		
		
		state.print_state();
	}
	
		
		//1.�޷¸޼ҵ� 
		public static void �޷�( int year , int month ) {
			ArrayList<Parking_date> money_array = new ArrayList<>();
			while( true ) { // ���ѷ��� [ �������� : 4�� ] 
				// 1. Ķ���� Ŭ������ ���� ��¥/�ð� ��ü ȣ�� 
				Calendar calendar = Calendar.getInstance(); //��) 2022��3��18��
				// 2. * �ش� ���� 1���� ����ã�� 
					calendar.set( year , month-1 , 1 ); // ��) 2022��3��1�� // 1. ����� ���� Ķ���� ���� 
					int sweek = calendar.get( Calendar.DAY_OF_WEEK ); // 2. 3��1���� ����
					int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH ); // 3. 3���� ������ �� 
				// 3. ��� 
				System.out.println("\n\n********************** "+year+"��" + month+"�� ******************");
				System.out.println("��\t��\tȭ\t��\t��\t��\t��");
				
				// 3-1.* ���� �� 1���� ��ġ �տ� ���� ä��� 
				for( int i = 1 ; i < sweek ; i++ ) { // 3��1�� = ȭ = 3 
					System.out.print("\t"); // �������
					
				}
				// 3-2. 1�Ϻ��� ��������¥ ���� ��� 
				for( int i = 1 ; i<=eday ; i++ ) {
					System.out.print(i+"\t");  // i = �ϼ� ���
					if( sweek % 7 == 0 ) System.out.println(); // ����ϸ��� �ٹٲ�ó�� [ �����=7 ] ������ 7�������
					sweek++;  // �Ϸ羿 ���� ���� 
				}
				
				
				// 4. ��ư [ 1.��(������)  2.��(������) 3.�ٽð˻� 4.���� ]
				try { // ���࿡ try { } �ȿ��� ����[����]�� �߻��ϸ� catch �̵� ( ���α׷� �ٿ�x)
					System.out.print(" \n\n *[ �ڷε��ư��ϴ�. ] ");
					Scanner scanner = new Scanner( System.in ); 
					int ch = scanner.nextInt();
					break; // ���ѷ��� ���� 
					
					
				}catch( Exception e  ) { // ���࿡ try{ }���� ����[����] �߻��ϸ� �ش� �ڵ尡 ����
					System.out.println(" ��� ]] �������� �Է��� ���ּ��� [ �����ڿ��Թ���] ");
				}// catch end 
				
				
				
			}// while end 
		} // �޷� �޼ҵ� end 
	
}
