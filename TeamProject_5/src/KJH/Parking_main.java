package KJH;
/*
 * 타워 주차 프로그램 [ 주차관리인 만 사용O 일반고객X ] 
 * 조건1 : 3층 짜리 주차타워일 경우 층별 4개씩 주차 가능 
 * 1층 [ ] [ ] [ ] [ ] 
 * 2층 [ ] [ ] [ ] [ ]
 * 3층 [ ] [ ] [ ] [ ]

1. 주차타워설정(층수)
2. 입차
3. 출차
4. 매출확인
 


  조건2 : 메뉴 : 1.입차 2.출차 3.매출확인 
  입차시 : 차량번호[4자리] 입력받아 주차타워에 자리가 있을경우 주차 
  출차시 : 차량번호[4자리] 를 입력받아 출차시 금액계산 
  * 금액표 1 .최초 30분 무료 2. 30분 이후부터 10분당 1000원 3. 하루 최대 5만원 부과 4. 1일당 5만원
  매출확인시 : 연도 , 월 입력받아 해당 월의 일별 매출 출력 / 매출이 없는 경우 없다 .
   
   조건3 : 클래스 , 파일처리 , Arraylist , 예외처리 필수 사용 [ 그외 선택 사항 ]

// 조 별 각자 본인 작성한 메소드[코드] // 김현수 : 입차메소드 // 유재석 : 출차메소드 //
// git 저장소 새로 만들어서 각 조별 팀 초대

프론트 : 한준석 입차 : 박민욱 출차 : 김진혁 매출확인 : 정희승

클래스명 메인 클래스 TowerParking 입차 : Enter 출차 : Exit 매출확인 : Sales
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Parking_main {
	public static void main(String[] args) {
		// 메뉴로드
		//
		Scanner scanner =new Scanner(System.in);
		Parking_menu menu = new Parking_menu();
		menu.info(scanner);
		
		/*	주의 사항
		 * 	Parking_In 
		 *  Parking_exit
		 * 	Tower_money  에  fileInput,fileOutput 용  txt file 생성 및 경로지정해야함 
		 * 
		 * Parking_In.java : FileOutputStream outputStream = new FileOutputStream("D:/java/차량입출차.txt" , true );
		 * 					// 1.차량입출차.txt
		 * ---------------------------------------------------------------------------------------------------------------------- 
		 * Parking_exit.java : FileInputStream inputStream = new FileInputStream("D:/java/차량입출차.txt"); // 1. 파일 입력객체 ( 파일경로)
		 * 					   FileOutputStream outputStream = new FileOutputStream("D:/java/출차계산.txt",true  );
		 * 					// 1.차량입출차.txt
		 * 					   2.출차계산.txt
		 * ----------------------------------------------------------------------------------------------------------------------
		 * Tower_money.java : FileInputStream inputStream = new FileInputStream("D:/java/출차계산.txt");
		 * 					// 1. 출차계산
		 */
	
		
	
	}
}
