package main;
import UI.*;
import mysql.*;
import java.sql.PreparedStatement;


/**
 * ����
 * @author ���
 *
 */
public class main_codes{
	static Data_sql datasql=new Data_sql();
	static Login_ui lu=new Login_ui();
	static Mutual_ui mu=new Mutual_ui();
	PreparedStatement preparedStatement = null;

	
    public static void main(String[] args) {     
        datasql.initsql();
//       lu.manger_login();
        //menu();
        mu.manger_menu();
        mu.center_table();

    }
    
/*    public static void menu() {
    	System.out.println("*****************************************************");
    	System.out.println("**************��ӭ����������������ϵͳ**************");
    	System.out.println("******************  ��ѡ����Ҫ���еĲ���  **************");
    	System.out.println("******************    1. �������               **************");
    	System.out.println("******************    2. ������               **************");
    	System.out.println("******************    3. �˻�������       **************");
    	System.out.println("******************    4. �����Ϣ��ѯ       **************");
    	System.out.println("******************    5. �˳�ϵͳ               **************");
    	System.out.println("*****************************************************");
    	int choice=0;
    	boolean exit=true;
    	while(exit) {
    		@SuppressWarnings("resource")
    		Scanner reader=new Scanner(System.in);
        	choice =reader.nextInt();
        	switch(choice) {
        	case 1:;break;
        	case 2:;break;
        	case 3:;break;
        	case 4:datasql.showall();break;
        	case 5:exit=false;datasql.close(datasql.con);break;
        	default:System.out.println("����������������룡\n");
        	
        	}
    	}
    }*/
}