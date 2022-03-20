package KJH;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main { // 임시 테스트 메인 파일
	public static void main(String[] args) {//
		// 1 차량 입력,2 리스트에 저장
		ArrayList<Date1> datelist = new ArrayList<>();
		Scanner scanner = new Scanner(System.in); // 입력객체 
//		while(true) {
		// 차량 입출차 파일 생성 및 저장
			System.out.print("차량번호 : "); 	 int carNum = scanner.nextInt();
			
			System.out.print("현재 연도 : "); 		int nowYear = scanner.nextInt();
			System.out.print("현재 월 : "); 		int nowMonth = scanner.nextInt();
			System.out.print("현재 일 : "); 		int nowDay = scanner.nextInt();
			System.out.print("현재 시 : "); 		int nowHour = scanner.nextInt();
			System.out.print("현재 분 : "); 		int nowMin = scanner.nextInt();
		
			Date1 date1 = new Date1(carNum,nowYear, nowMonth, nowDay, nowHour, nowMin);
			
			datelist.add(date1); 
			try {
				FileOutputStream outputStream = new FileOutputStream("C:/Users/lvblu/Desktop/JAVA/차량입출차.txt",true);
				String 내보내기 = carNum+","+nowYear+","+nowDay+","+nowHour+","+nowMin+"\n";
				outputStream.write( 내보내기.getBytes() );
			}catch(Exception e) {}
			System.out.println("알림]] 저장 완료 ");
			System.out.println("================");
			
			
//		}
	}

}
