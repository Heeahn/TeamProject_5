package KJH;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ExitCar {
	//출차 프로그램
	
	//1 필드
	// 출차하려는 차량번호
	private int CarNum; //출차 시 입력
	private ArrayList<Date1> Date1list = new ArrayList<>(); // 입차 시 작성한 리스트 불러오기
															// 입차시간 => 리스트 불러오기 
	
	
	
	//2생성자
	public ExitCar() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ExitCar(int carNum, ArrayList<Date1> date1list) {
	
		CarNum = carNum;
		Date1list = date1list;
	}


	//3 메소드
	public void Exit() {
		Scanner scanner= new Scanner(System.in);
		try {
			System.out.println("출차번호: "); int CarNum=scanner.nextInt();
			FileInputStream inputStream = new FileInputStream("C:/Users/lvblu/Desktop/JAVA/차량입출차.txt"); // 1. 파일 입력객체 ( 파일경로)
			// 입출차 텍스트 불러오기 
			byte[] bytes = new byte[1024];
			
			inputStream.read(bytes);
			String 파일내용= new String(bytes);
			String[] inexit = 파일내용.split("\n");
			
			for(String temp: inexit) {
				String[] 필드목록 = temp.split(",");
				Date1 date1 = new Date1( Integer.parseInt( 필드목록[0]),
						Integer.parseInt( 필드목록[1]),
						Integer.parseInt( 필드목록[2]),
						Integer.parseInt( 필드목록[3]),
						Integer.parseInt( 필드목록[4]),
						Integer.parseInt( 필드목록[5])
						);
				Date1list.add(date1);
			}
			
		}catch(Exception e) {}
		System.out.println("출차완료");
	}
	
		
	
	
}
