package curriculum_design;
import java.sql.*;

public class sql{
	// JDBC �����������ݿ� URL 
    static final String DB_URL = "jdbc:mysql://localhost:3306/pc stock control?&useSSL=false&serverTimezone=UTC";//"jdbc:mysql://localhost��3306/pc stock control?&useSSL=false&serverTimezone=UTC";
    // ���ݿ���û���������
    static final String USER = "root";
    static final String PASS = "";
	Connection con = null;
	Statement sql;
	ResultSet rs;
	
	//��ʼ���������ݿ�
    public void initsql() {
 		 try {
 			 Class.forName("com.mysql.cj.jdbc.Driver");     //����MYSQL JDBC��������   
 		     System.out.println("�ɹ������������������");
 		    }catch (Exception e) {
 		      System.out.print("Error loading Mysql Driver!");
 		      e.printStackTrace();
 		    }
         try{
         	  // ������
             System.out.println("�������ݿ�...");
             con = DriverManager.getConnection(DB_URL,USER,PASS);
             System.out.println("���ӳɹ�������");
         }catch(SQLException e){   // ���� JDBC ����
         	System.out.println(e);
         }
    }
    
    //��ʾ���ݿ�
    public void showall()
    {
    	try {
    		sql=con.createStatement();//����SQL������
        	rs=sql.executeQuery("select * from `table`");
        	while(rs.next()) {
        		int number=rs.getInt("number");
        		String type=rs.getString("type");
        		System.out.printf("%d  ", number);
        		System.out.printf("%s\n", type);
        	}
  
        	System.out.println("��ѯ�ɹ��������ر����ݿ⣡");
        	rs.close();
        	con.close();
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    }

    
    
}