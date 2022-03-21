package KJH;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Tower_money {
	
	
	public Tower_money() {}
	
	void inform(Parking_state state,Scanner scanner) {
		
		ArrayList<Parking_date> money_array = new ArrayList<>();
		try { // try { } 안에 예외[오류] 발생할것 하는 코드 넣기 ( 예상 )
			FileInputStream inputStream = new FileInputStream("D:/java/출차계산.txt"); // 1. 파일 입력객체 ( 파일경로)
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
						Integer.parseInt( 필드목록[6])  ,
						Integer.parseInt( 필드목록[7]) );
				// 문자열 --> 정수형 변환 [  Integer.parseInt("문자열") ] // 
				// 리스트 저장 
				money_array.add(parking_date);
				i++;
				 
				}
			
		}catch( Exception e ) {System.out.println("로드 성공");// catch : 예외 잡기 -> Exception 클래스의 객체에 저장 
		}
		System.out.print(" 연도 :"); int year = scanner.nextInt();
		System.out.print(" 월 :");	int month = scanner.nextInt();
		
		System.out.println("\n\n=============  월 별 매출액  ==============");
		for(Parking_date temp : money_array) {
			
			if(year==((int)temp.get주차연())&&month==((int)temp.get주차월())) {
				
			
				
				System.out.println(" 매출 발생일 : "+temp.get주차일()+"\t 매출액 :"+temp.get주차요금()+"\n");
				
			}
			else {System.out.println(" 매출액이 없습니다."); break;}
		}
	
		
		달력( year , month );
		
		
		state.print_state();
	}
	
		
		//1.달력메소드 
		public static void 달력( int year , int month ) {
			ArrayList<Parking_date> money_array = new ArrayList<>();
			while( true ) { // 무한루프 [ 종료조건 : 4번 ] 
				// 1. 캘린더 클래스내 현재 날짜/시간 객체 호출 
				Calendar calendar = Calendar.getInstance(); //예) 2022년3월18일
				// 2. * 해당 월의 1일의 요일찾기 
					calendar.set( year , month-1 , 1 ); // 예) 2022년3월1일 // 1. 사용자 정의 캘린터 설정 
					int sweek = calendar.get( Calendar.DAY_OF_WEEK ); // 2. 3월1일의 요일
					int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH ); // 3. 3월의 마지막 일 
				// 3. 출력 
				System.out.println("\n\n********************** "+year+"년" + month+"월 ******************");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				
				// 3-1.* 현재 월 1일의 위치 앞에 공백 채우기 
				for( int i = 1 ; i < sweek ; i++ ) { // 3월1일 = 화 = 3 
					System.out.print("\t"); // 공백출력
					
				}
				// 3-2. 1일부터 마지막날짜 까지 출력 
				for( int i = 1 ; i<=eday ; i++ ) {
					System.out.print(i+"\t");  // i = 일수 출력
					if( sweek % 7 == 0 ) System.out.println(); // 토요일마다 줄바꿈처리 [ 토요일=7 ] 요일이 7배수마다
					sweek++;  // 하루씩 요일 증가 
				}
				
				
				// 4. 버튼 [ 1.◀(이전달)  2.▶(다음달) 3.다시검색 4.종료 ]
				try { // 만약에 try { } 안에서 예외[에러]가 발생하면 catch 이동 ( 프로그램 다운x)
					System.out.print(" \n\n *[ 뒤로돌아갑니다. ] ");
					Scanner scanner = new Scanner( System.in ); 
					int ch = scanner.nextInt();
					break; // 무한루프 종료 
					
					
				}catch( Exception e  ) { // 만약에 try{ }에서 예외[에러] 발생하면 해당 코드가 실행
					System.out.println(" 경고 ]] 정상적인 입력을 해주세요 [ 관리자에게문의] ");
				}// catch end 
				
				
				
			}// while end 
		} // 달력 메소드 end 
	
}
