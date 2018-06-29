package main;
import UI.*;
import mysql.*;
import java.sql.PreparedStatement;


/**
 * 主类
 * @author 广辉
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
    	System.out.println("**************欢迎进入电脑配件库存管理系统**************");
    	System.out.println("******************  请选择您要进行的操作  **************");
    	System.out.println("******************    1. 配件出库               **************");
    	System.out.println("******************    2. 配件入库               **************");
    	System.out.println("******************    3. 退货配件入库       **************");
    	System.out.println("******************    4. 库存信息查询       **************");
    	System.out.println("******************    5. 退出系统               **************");
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
        	default:System.out.println("输入错误，请重新输入！\n");
        	
        	}
    	}
    }*/
}