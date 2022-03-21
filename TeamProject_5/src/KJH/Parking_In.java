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
		
		try {
			System.out.println("=== 주차 하실 곳의 위치를 고르세요 ===");
			System.out.println("선택 :>  "); 
			position = (scanner.nextInt());
			int real_position = position-1;
			if(state.box[real_position].equals("[ ]")) {
				System.out.println("차량 번호 : "); car_num=scanner.nextInt();
				System.out.println("주차 연 : "); year=scanner.nextInt();
				System.out.println("주차 월 : "); month=scanner.nextInt();
				System.out.println("주차 일 : "); day=scanner.nextInt();
				System.out.println("주차 시 : "); hour=scanner.nextInt();
				System.out.println("주차 분 : "); min=scanner.nextInt();
				
				state.box[real_position]="[O]";
				System.out.println((position)+" 번 주차 완료");
				
				Parking_date date = new Parking_date(car_num, year, month, day, hour, min,real_position);
				date_array.add(date);
				
				 // 예외[오류]가 발생할것 같은 코드 묶음 ( 예상 ) 				//  파일 경로   , 이어쓰기=true[옵션]
					FileOutputStream outputStream = new FileOutputStream("D:/java/차량입출차.txt" , true );
					String 내보내기 = car_num+","+year+","+month+","+day+","
									+hour+","+min+","+real_position+ "\n"; // , : 필드 구분용   \n : 제품 구분용
							outputStream.write( 내보내기.getBytes() ); // 문자열 -> 바이트열
				
				System.out.println("알림]] 주차정보 저장 완료 "); 
				
		}
			else System.err.println("이미 주차되어 있는 공간입니다.");
		}catch( Exception e ) { // 예외[오류] 처리[잡기] : Exception 클래스
		}
		state.print_state();
		
		
	}
}
