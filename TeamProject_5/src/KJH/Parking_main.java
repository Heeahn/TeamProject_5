package KJH;
/*
 * Ÿ�� ���� ���α׷� [ ���������� �� ���O �Ϲݰ�X ] 
 * ����1 : 3�� ¥�� ����Ÿ���� ��� ���� 4���� ���� ���� 
 * 1�� [ ] [ ] [ ] [ ] 
 * 2�� [ ] [ ] [ ] [ ]
 * 3�� [ ] [ ] [ ] [ ]

1. ����Ÿ������(����)
2. ����
3. ����
4. ����Ȯ��
 


  ����2 : �޴� : 1.���� 2.���� 3.����Ȯ�� 
  ������ : ������ȣ[4�ڸ�] �Է¹޾� ����Ÿ���� �ڸ��� ������� ���� 
  ������ : ������ȣ[4�ڸ�] �� �Է¹޾� ������ �ݾװ�� 
  * �ݾ�ǥ 1 .���� 30�� ���� 2. 30�� ���ĺ��� 10�д� 1000�� 3. �Ϸ� �ִ� 5���� �ΰ� 4. 1�ϴ� 5����
  ����Ȯ�ν� : ���� , �� �Է¹޾� �ش� ���� �Ϻ� ���� ��� / ������ ���� ��� ���� .
   
   ����3 : Ŭ���� , ����ó�� , Arraylist , ����ó�� �ʼ� ��� [ �׿� ���� ���� ]

// �� �� ���� ���� �ۼ��� �޼ҵ�[�ڵ�] // ������ : �����޼ҵ� // ���缮 : �����޼ҵ� //
// git ����� ���� ���� �� ���� �� �ʴ�

����Ʈ : ���ؼ� ���� : �ڹο� ���� : ������ ����Ȯ�� : �����

Ŭ������ ���� Ŭ���� TowerParking ���� : Enter ���� : Exit ����Ȯ�� : Sales
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Parking_main {
	public static void main(String[] args) {
		// �޴��ε�
		//
		Scanner scanner =new Scanner(System.in);
		Parking_menu menu = new Parking_menu();
		menu.info(scanner);
		
		/*	���� ����
		 * 	Parking_In   ---
		 *  Parking_exit   |----  ��  fileInput,fileOutput ��  txt file ���� �� ��������ؾ���   
		 * 	Tower_money  ---   
		 * 
		 * Parking_In.java : FileOutputStream outputStream = new FileOutputStream("D:/java/����������.txt" , true );
		 * 					// 1.����������.txt
		 * ---------------------------------------------------------------------------------------------------------------------- 
		 * Parking_exit.java : FileInputStream inputStream = new FileInputStream("D:/java/����������.txt"); // 1. ���� �Է°�ü ( ���ϰ��)
		 * 					   FileOutputStream outputStream = new FileOutputStream("D:/java/�������.txt",true  );
		 * 					// 1.����������.txt
		 * 					   2.�������.txt
		 * ----------------------------------------------------------------------------------------------------------------------
		 * Tower_money.java : FileInputStream inputStream = new FileInputStream("D:/java/�������.txt");
		 * 					// 1. �������
		 */
	
		
	
	}
}
