package curriculum_design;
import java.sql.*;

public class sql{
	// JDBC 驱动名及数据库 URL 
    static final String DB_URL = "jdbc:mysql://localhost:3306/pc stock control?&useSSL=false&serverTimezone=UTC";//"jdbc:mysql://localhost：3306/pc stock control?&useSSL=false&serverTimezone=UTC";
    // 数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "";
	Connection con = null;
	Statement sql;
	ResultSet rs;
	
	//初始化连接数据库
    public void initsql() {
 		 try {
 			 Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
 		     System.out.println("成功加载驱动，请继续！");
 		    }catch (Exception e) {
 		      System.out.print("Error loading Mysql Driver!");
 		      e.printStackTrace();
 		    }
         try{
         	  // 打开链接
             System.out.println("连接数据库...");
             con = DriverManager.getConnection(DB_URL,USER,PASS);
             System.out.println("连接成功！！！");
         }catch(SQLException e){   // 处理 JDBC 错误
         	System.out.println(e);
         }
    }
    
    //显示数据库
    public void showall()
    {
    	try {
    		sql=con.createStatement();//创建SQL语句对象
        	rs=sql.executeQuery("select * from `table`");
        	while(rs.next()) {
        		int number=rs.getInt("number");
        		String type=rs.getString("type");
        		System.out.printf("%d  ", number);
        		System.out.printf("%s\n", type);
        	}
  
        	System.out.println("查询成功，即将关闭数据库！");
        	rs.close();
        	con.close();
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    }

    
    
}