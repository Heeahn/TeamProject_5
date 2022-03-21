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
		
		try { // try { } 안에 예외[오류] 발생할것 하는 코드 넣기 ( 예상 )
			FileInputStream inputStream = new FileInputStream("D:/java/차량입출차.txt"); // 1. 파일 입력객체 ( 파일경로)
			byte[] bytes = new byte[1024];
			inputStream.read( bytes );
			String 파일내용 = new String( bytes );
			String[] 주차정보목록 = 파일내용.split("\n"); 
			int i=0;
			for( String temp1 : 주차정보목록 ) {
				if(i+1 ==주차정보목록.length) break;
				String[] 필드목록 = temp1.split(","); //  8조각
				Parking_date parking_date = new Parking_date( Integer.parseInt(필드목록[0]) , 
						Integer.parseInt( 필드목록[1])  ,
						Integer.parseInt( 필드목록[2])  ,
						Integer.parseInt( 필드목록[3])  ,
						Integer.parseInt( 필드목록[4])  ,
						Integer.parseInt( 필드목록[5])  ,
						Integer.parseInt( 필드목록[6]) );
				// 문자열 --> 정수형 변환 [  Integer.parseInt("문자열") ] // 
				// 리스트 저장 
				date_array.add(parking_date);
				i++;
				}
			
		}catch( Exception e ) { // catch : 예외 잡기 -> Exception 클래스의 객체에 저장 
		}
	
		Calendar calendar = Calendar.getInstance();
		
		long yearNow = calendar.get(Calendar.YEAR);
	    long monthNow = calendar.get(Calendar.MONTH) + 1;
	    long dayNow = calendar.get(Calendar.DAY_OF_MONTH);
	    long timeNow= calendar.get(Calendar.HOUR_OF_DAY);
	    long minNow= calendar.get(Calendar.MINUTE);
		
		int num =0;
		int real_num=num-1;
		System.out.println("주차하신 차량번호를 입력하세요");
		num=scanner.nextInt();
//		int i =0;
		for (Parking_date board : date_array) {
			if(num==board.get차량번호()) {
				System.out.println("차량번호\t주차연\t주차월\t주차일\t주차시\t주차분\t주차위치");
				System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\n",
						board.get차량번호(),board.get주차연(),board.get주차월(),
						board.get주차일(),board.get주차시(),board.get주차분(),
						board.get주차위치()+1);
				System.out.println("출차 하시겠습니까?"); int sc= scanner.nextInt();
				System.out.println("1.예 2.아니오");
				if(sc==1) {
					int year1=Math.abs((int) (yearNow-board.get주차연()));
					int month1=Math.abs((int) (monthNow-board.get주차월()));
					int day1=Math.abs((int) (dayNow-board.get주차일()));
					int time1=Math.abs((int) (timeNow-board.get주차시()));
					int min1=Math.abs((int) (minNow-board.get주차분()));
					int cal_money = 0;
					
				
//					==== 돈계산
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
					System.out.println("주차요금 :" +cal_money+"입니다.");
					
					state.box[board.get주차위치()]="[ ]";
					System.out.println(board.get주차위치());
//						state1.box[board.get주차위치()]="[ ]";
//					}
					//					====
//							if(min1<=30) {
//								System.out.println("주차요금 무료");
//								cal_money = 0;
//							}
//							else if(min1>30) {
//								cal_money =(min1/10)*1000;
//								System.out.println("주차요금 :" +cal_money+"입니다.");
//							}
//							else if(min1>30&&time1>=1) {
//								cal_money =(min1/10)*1000 + time1*6000;
//								System.out.println("주차요금 :" +cal_money+"입니다.");
//							}
//							else if(time1>=1&&time1<24) {
//								cal_money =(min1/10)*1000 + time1*6000;;
//								System.out.println("주차요금 :" +cal_money+"입니다.");
//							}
//							else {
//							cal_money = 50000;
//							System.out.println("주차요금 :" +cal_money+"입니다.");
//							}
					
//					===
					
						
					
				Parking_date cal= new Parking_date(num, board.get주차연(), board.get주차월(), board.get주차일(), 
						board.get주차시(), board.get주차분(), board.get주차위치()+1, cal_money);
				
				try { // 예외[오류]가 발생할것 같은 코드 묶음 ( 예상 ) 				//  파일 경로   , 이어쓰기=true[옵션]
					FileOutputStream outputStream = new FileOutputStream("D:/java/출차계산.txt",true  );
					String 내보내기 = num+","+board.get주차연()+","+board.get주차월()+","+board.get주차일()+","
									+board.get주차시()+","+board.get주차분()+","+(board.get주차위치()+1)+","+cal_money+ "\n"; // , : 필드 구분용   \n : 제품 구분용
							outputStream.write( 내보내기.getBytes() ); // 문자열 -> 바이트열
				}catch( Exception e ) { // 예외[오류] 처리[잡기] : Exception 클래스
				}
				System.out.println("알림]] 출차정보 저장 완료 "); 
//				if(state1.box[board.get주차위치()].equals("[O]")) {
//					state1.box[board.get주차위치()]="[ ]";
//				}
				break;
				
				}
				else if(sc==2) {
					break;
				}
				else {System.out.println("잘못된 입력값입니다.");}
			}
			
		
//		차량번호 / 연/월/일/시/분
		
		}
		state.print_state();
	
	}
	
}
