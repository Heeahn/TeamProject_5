package KJH;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ExitCar {
	//���� ���α׷�
	
	//1 �ʵ�
	// �����Ϸ��� ������ȣ
	private int CarNum; //���� �� �Է�
	private ArrayList<Date1> Date1list = new ArrayList<>(); // ���� �� �ۼ��� ����Ʈ �ҷ�����
															// �����ð� => ����Ʈ �ҷ����� 
	
	
	
	//2������
	public ExitCar() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ExitCar(int carNum, ArrayList<Date1> date1list) {
	
		CarNum = carNum;
		Date1list = date1list;
	}


	//3 �޼ҵ�
	public void Exit() {
		Scanner scanner= new Scanner(System.in);
		try {
			System.out.println("������ȣ: "); int CarNum=scanner.nextInt();
			FileInputStream inputStream = new FileInputStream("C:/Users/lvblu/Desktop/JAVA/����������.txt"); // 1. ���� �Է°�ü ( ���ϰ��)
			// ������ �ؽ�Ʈ �ҷ����� 
			byte[] bytes = new byte[1024];
			
			inputStream.read(bytes);
			String ���ϳ���= new String(bytes);
			String[] inexit = ���ϳ���.split("\n");
			
			for(String temp: inexit) {
				String[] �ʵ��� = temp.split(",");
				Date1 date1 = new Date1( Integer.parseInt( �ʵ���[0]),
						Integer.parseInt( �ʵ���[1]),
						Integer.parseInt( �ʵ���[2]),
						Integer.parseInt( �ʵ���[3]),
						Integer.parseInt( �ʵ���[4]),
						Integer.parseInt( �ʵ���[5])
						);
				Date1list.add(date1);
			}
			
		}catch(Exception e) {}
		System.out.println("�����Ϸ�");
	}
	
		
	
	
}
