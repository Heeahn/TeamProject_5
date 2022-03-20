package KJH;

import java.util.ArrayList;

public class Parking_state_array {
	// 위치값 표시용 array
	final static int MAX = 4;
	public void array_position() {
		ArrayList<String> car_position1 = new ArrayList<>(MAX);
		ArrayList<String> car_position2 = new ArrayList<>(MAX);
		ArrayList<String> car_position3 = new ArrayList<>(MAX);
		System.out.println(car_position1);
		for(int i =0;i<MAX;i++) {
			car_position1.add(i, "[ ]");
			car_position2.add(i, "[ ]");
			car_position3.add(i, "[ ]");
		}
	}
	
	
}
