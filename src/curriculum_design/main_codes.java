package curriculum_design;

/**
 * ����
 * @author ���
 *
 */
public class main_codes{
    public static void main(String[] args) {     
    	Data_sql datasql=new Data_sql();
        datasql.initsql();
        datasql.showall();

        login_ui u1=new login_ui();
        while(true) {
        	 if(u1.manger_login()==true) {
        		 //u1.dispose();
        	 }
        	 else
        	 {
        		 	System.out.println("�˺���������������������룡����\n");
        		 }
        	 break;
        }
       
    }
}