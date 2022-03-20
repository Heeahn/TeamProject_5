package KJH;

public class Date1 {
	// 입차 시 시간 저장
	//1. 필드
//	
//	2. 주차시 입력한 시간 (연 월 일 시 분)
	private int CarNum;
//	private int date;
	private int Year;
	private int Month;
	private int Day;
	private int Hour;
	private int Min;
	
	//2. 생성자
public Date1() {

}



	public Date1(int carNum, int year, int month, int day, int hour, int min) {
	
	CarNum = carNum;
	Year = year;
	Month = month;
	Day = day;
	Hour = hour;
	Min = min;
}



	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getHour() {
		return Hour;
	}

	public void setHour(int hour) {
		Hour = hour;
	}

	public int getMin() {
		return Min;
	}

	public void setMin(int min) {
		Min = min;
	}



	public int getCarNum() {
		return CarNum;
	}



	public void setCarNum(int carNum) {
		CarNum = carNum;
	}


	
	//3. 메소드
	
	

}
