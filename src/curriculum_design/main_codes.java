package curriculum_design;
import java.sql.*;

public class main_codes{
	 // JDBC �����������ݿ� URL 
    static final String DB_URL = "jdbc:mysql://localhost:3306/pc stock control?&useSSL=false&serverTimezone=UTC";//"jdbc:mysql://localhost��3306/pc stock control?&useSSL=false&serverTimezone=UTC";
    // ���ݿ���û���������
    static final String USER = "root";
    static final String PASS = "";
 
    public static void main(String[] args) {
        Connection con = null;
		Statement sql;
		ResultSet rs;
		 try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //����MYSQL JDBC��������   
		     System.out.println("�ɹ������������������");
		    }
		    catch (Exception e) {
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
        
        try {
        	sql=con.createStatement();//����SQL������
        	rs=sql.executeQuery("select * from `table`");
        	while(rs.next()) {
        		int id=rs.getInt("number");
        		String typename=rs.getString("type");
        		System.out.printf("%d  ", id);
        		System.out.printf("%s\n", typename);
        	}
        	
        	System.out.println("��ѯ�ɹ��������ر����ݿ⣡");
        	rs.close();
        	con.close();
        }catch(SQLException e) {
        	System.out.println(e);
        }
        
        System.out.println("Goodbye!");
    }
}