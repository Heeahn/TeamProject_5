package KJH;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main { // �ӽ� �׽�Ʈ ���� ����
	public static void main(String[] args) {//
		// 1 ���� �Է�,2 ����Ʈ�� ����
		ArrayList<Date1> datelist = new ArrayList<>();
		Scanner scanner = new Scanner(System.in); // �Է°�ü 
//		while(true) {
		// ���� ������ ���� ���� �� ����
			System.out.print("������ȣ : "); 	 int carNum = scanner.nextInt();
			
			System.out.print("���� ���� : "); 		int nowYear = scanner.nextInt();
			System.out.print("���� �� : "); 		int nowMonth = scanner.nextInt();
			System.out.print("���� �� : "); 		int nowDay = scanner.nextInt();
			System.out.print("���� �� : "); 		int nowHour = scanner.nextInt();
			System.out.print("���� �� : "); 		int nowMin = scanner.nextInt();
		
			Date1 date1 = new Date1(carNum,nowYear, nowMonth, nowDay, nowHour, nowMin);
			
			datelist.add(date1); 
			try {
				FileOutputStream outputStream = new FileOutputStream("C:/Users/lvblu/Desktop/JAVA/����������.txt",true);
				String �������� = carNum+","+nowYear+","+nowDay+","+nowHour+","+nowMin+"\n";
				outputStream.write( ��������.getBytes() );
			}catch(Exception e) {}
			System.out.println("�˸�]] ���� �Ϸ� ");
			System.out.println("================");
			
			
//		}
	}

}
