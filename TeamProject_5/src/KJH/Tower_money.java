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
			FileInputStream inputStream = new FileInputStream("C:/Users/lvblu/Desktop/JAVA/�������.txt"); // 1. ���� �Է°�ü ( ���ϰ��)
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
		
		�޷�( year , month );
		state.print_state();
	}
		//1.�޷¸޼ҵ� 
		public static void �޷�( int year , int month ) {
			ArrayList<Parking_date> money_array2 = new ArrayList<>();
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
				System.out.println(); /// ������� ���ۼ�
				System.out.println();
				System.out.println("1");
				for(Parking_date board : money_array2) {
					if(year==board.get������()&&month==board.get������()) {
						
							System.out.println(board.get�������());
						
					}
					System.out.println("1");
				}
				// 4. ��ư [ 1.��(������)  2.��(������) 3.�ٽð˻� 4.���� ]
				try { // ���࿡ try { } �ȿ��� ����[����]�� �߻��ϸ� catch �̵� ( ���α׷� �ٿ�x)
					System.out.print(" \n\n *[ 1.��(������)  2.��(������) 3.�ٽð˻� 4.���� ���� :  ");
					Scanner scanner = new Scanner( System.in ); int ch = scanner.nextInt();
					if( ch == 1 ) { // ������ 
						month = month -1;  // moth -=1 �� �ƹ��ų� ���[����]
						// ���࿡ ���� 0�� �Ǹ� ����1���� , �� 12 �� ���� 
						if( month == 0 ) { year -=1; month = 12; }
					}
					else if( ch == 2 ) { // ������ 
						month += 1; 
						// ���࿡ ���� 13���� �Ǹ� ����1���� , �� �ٽ� 1 �� ����
						if( month == 13 ) { year +=1; month = 1 ;  }
					}
					else if( ch == 3 ) {  // �ٽð˻� 
						System.out.print(" ���� :");  year = scanner.nextInt();
						System.out.print(" �� :");	 month = scanner.nextInt();
					}
					else if( ch == 4 ) { // ���� 
						System.out.println(" �˸� ]] �޷� ���α׷� ���� ");
						break; // ���ѷ��� ���� 
					}else { // �׿� 
						System.out.println(" �˸� ]] �˼� ���� ��ȣ�Դϴ�. ");
					}
				}catch( Exception e  ) { // ���࿡ try{ }���� ����[����] �߻��ϸ� �ش� �ڵ尡 ����
					System.out.println(" ��� ]] �������� �Է��� ���ּ��� [ �����ڿ��Թ���] ");
				}// catch end 
			}// while end 
		} // �޷� �޼ҵ� end 
	
}
