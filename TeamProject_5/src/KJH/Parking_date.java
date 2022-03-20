package KJH;

import java.util.ArrayList;

public class Parking_date {
	private ArrayList<Parking_date> date_array = new ArrayList<>();
	// array 에 저장할 내용
	private int 차량번호;
	private int 주차연;
	private int 주차월;
	private int 주차일;
	private int 주차시;
	private int 주차분;
	private int 주차위치;
	private int 주차요금;
	
	
	public Parking_date() {
		// TODO Auto-generated constructor stub
	}
	
	public Parking_date(int 차량번호) {
		
		this.차량번호 = 차량번호;
	}

	public Parking_date(int 차량번호, ArrayList<Parking_date> date_array) {
		
		this.차량번호 = 차량번호;
		this.date_array = date_array;
	}
	public Parking_date(int car_num, int year, int month, int day, int hour, int min,int real_position) {
		
		this.차량번호 = car_num;
		this.주차연 = year;
		this.주차월 = month;
		this.주차일 = day;
		this.주차시 = hour;
		this.주차분 = min;
		this.주차위치 = real_position;
	}

	public Parking_date(int 차량번호, int 주차연, int 주차월, int 주차일, int 주차시, int 주차분,int 주차위치, int 주차요금) {
		
		this.차량번호 = 차량번호;
		this.주차연 = 주차연;
		this.주차월 = 주차월;
		this.주차일 = 주차일;
		this.주차시 = 주차시;
		this.주차분 = 주차분;
		this.주차위치 = 주차위치;
		this.주차요금 = 주차요금;
	}

	public int get차량번호() {
		return 차량번호;
	}

	public void set차량번호(int 차량번호) {
		this.차량번호 = 차량번호;
	}

	public int get주차연() {
		return 주차연;
	}

	public void set주차연(int 주차연) {
		this.주차연 = 주차연;
	}

	public int get주차월() {
		return 주차월;
	}

	public void set주차월(int 주차월) {
		this.주차월 = 주차월;
	}

	public int get주차일() {
		return 주차일;
	}

	public void set주차일(int 주차일) {
		this.주차일 = 주차일;
	}

	public int get주차시() {
		return 주차시;
	}

	public void set주차시(int 주차시) {
		this.주차시 = 주차시;
	}

	public int get주차분() {
		return 주차분;
	}

	public void set주차분(int 주차분) {
		this.주차분 = 주차분;
	}

	public int get주차위치() {
		return 주차위치;
	}

	public void set주차위치(int 주차위치) {
		this.주차위치 = 주차위치;
	}

	public int get주차요금() {
		return 주차요금;
	}

	public void set주차요금(int 주차요금) {
		this.주차요금 = 주차요금;
	}
	
	

}
