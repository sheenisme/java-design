package mysql;
import java.sql.*;

/**
 * �û������ݿ�
 */
public class User_sql{
	// JDBC �����������ݿ� URL 
    static final String DB_URL = "jdbc:mysql://localhost:3306/user?&useSSL=false&serverTimezone=UTC";//"jdbc:mysql://localhost��3306/pc stock control?&useSSL=false&serverTimezone=UTC";
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
 		     //System.out.println("�ɹ������������������");
 		    }catch (Exception e) {
 		      System.out.print("Error loading Mysql Driver!");
 		      e.printStackTrace();
 		    }
    	
         try{
         	  // ������
             // System.out.println("���ӹ���Ա���ݿ�...");
             con = DriverManager.getConnection(DB_URL,USER,PASS);
             //System.out.println("���ӹ���Ա���ݿ�ɹ�������");
         }catch(SQLException e){   // ���� JDBC ����
         	System.out.println(e);
         }
    }
    
    /**
     * �����ݿ��ȡuser���е�user
     * @return
     */
	public User[] getuser() {
		int i=0;
		User user[];
		user=new User[12];
    	try {
    		sql=con.createStatement();//����SQL������
        	rs=sql.executeQuery("select id,passward,birthday from `register`");
        	while(rs!=null && rs.next()) {
        		user[i]=new User(rs.getString("id"), rs.getString("passward"), rs.getDate("birthday"));
        		//user[i].show();
        		i++;
        		//System.out.println("I can run to here!\n");
        	}
        	rs.close();
        	//con.close();
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    	return user;
    }
}