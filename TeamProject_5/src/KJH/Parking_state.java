package KJH;




public class Parking_state {
	
	// �������� ( ������ ��Ȳ ) 
	final static int MAX = 12;
	
//	public Parking_date_array array[] = new Parking_date_array[MAX];
	String[] box = new String[MAX];
	
	
	public void create(int MAX){
		for(int i=0; i<MAX; i++){
			box[i] = "[ ]";
		}
    }
	
	
	public void print_state(){
		System.out.println("==============================================\n << ���� ������ ���� >>");
		for(int i =0 ;i<MAX;i++) {
			
			System.out.print(    box[i]    );
				if(i%4==3) System.out.println();				
		}
	}

	
}
