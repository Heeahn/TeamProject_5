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
		
		달력( year , month );
		state.print_state();
	}
		//1.달력메소드 
		public static void 달력( int year , int month ) {
			ArrayList<Parking_date> money_array2 = new ArrayList<>();
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
				System.out.println(); /// 주차요금 미작성
				System.out.println();
				System.out.println("1");
				for(Parking_date board : money_array2) {
					if(year==board.get주차연()&&month==board.get주차월()) {
						
							System.out.println(board.get주차요금());
						
					}
					System.out.println("1");
				}
				// 4. 버튼 [ 1.◀(이전달)  2.▶(다음달) 3.다시검색 4.종료 ]
				try { // 만약에 try { } 안에서 예외[에러]가 발생하면 catch 이동 ( 프로그램 다운x)
					System.out.print(" \n\n *[ 1.◀(이전달)  2.▶(다음달) 3.다시검색 4.종료 선택 :  ");
					Scanner scanner = new Scanner( System.in ); int ch = scanner.nextInt();
					if( ch == 1 ) { // 이전달 
						month = month -1;  // moth -=1 중 아무거나 사용[권장]
						// 만약에 월이 0이 되면 연도1감소 , 월 12 값 설정 
						if( month == 0 ) { year -=1; month = 12; }
					}
					else if( ch == 2 ) { // 다음달 
						month += 1; 
						// 만약에 월이 13월이 되면 연도1증가 , 월 다시 1 값 설정
						if( month == 13 ) { year +=1; month = 1 ;  }
					}
					else if( ch == 3 ) {  // 다시검색 
						System.out.print(" 연도 :");  year = scanner.nextInt();
						System.out.print(" 월 :");	 month = scanner.nextInt();
					}
					else if( ch == 4 ) { // 종료 
						System.out.println(" 알림 ]] 달력 프로그램 종료 ");
						break; // 무한루프 종료 
					}else { // 그외 
						System.out.println(" 알림 ]] 알수 없는 번호입니다. ");
					}
				}catch( Exception e  ) { // 만약에 try{ }에서 예외[에러] 발생하면 해당 코드가 실행
					System.out.println(" 경고 ]] 정상적인 입력을 해주세요 [ 관리자에게문의] ");
				}// catch end 
			}// while end 
		} // 달력 메소드 end 
	
}
