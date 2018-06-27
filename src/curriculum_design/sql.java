package curriculum_design;
import java.sql.*;
/**
 * 配件类和用户类
 * @author 广辉
 *
 */

/**
 * 数据库类数据库
 */
class Data_sql{
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
 		     //System.out.println("成功加载驱动，请继续！");
 		    }catch (Exception e) {
 		      System.out.print("Error loading Mysql Driver!");
 		      e.printStackTrace();
 		    }
 		 
         try{
         	  // 打开链接
             //System.out.println("连接配件库存数据库...");
             con = DriverManager.getConnection(DB_URL,USER,PASS);
             //System.out.println("连接配件库存数据库成功！！！");
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


/**
 * 用户类数据库
 */

class User_sql{
	// JDBC 驱动名及数据库 URL 
    static final String DB_URL = "jdbc:mysql://localhost:3306/user?&useSSL=false&serverTimezone=UTC";//"jdbc:mysql://localhost：3306/pc stock control?&useSSL=false&serverTimezone=UTC";
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
 		     //System.out.println("成功加载驱动，请继续！");
 		    }catch (Exception e) {
 		      System.out.print("Error loading Mysql Driver!");
 		      e.printStackTrace();
 		    }
    	
         try{
         	  // 打开链接
             // System.out.println("连接管理员数据库...");
             con = DriverManager.getConnection(DB_URL,USER,PASS);
             //System.out.println("连接管理员数据库成功！！！");
         }catch(SQLException e){   // 处理 JDBC 错误
         	System.out.println(e);
         }
    }
    
    @SuppressWarnings("null")
	public User[] getuser() {
    	int i=0;
		User user[] = null;
    	try {
    		sql=con.createStatement();//创建SQL语句对象
        	rs=sql.executeQuery("select * from `register`");
        	while(rs.next()) {
        		user[i]=new User(rs.getString("id"), rs.getString("passward"), rs.getDate("birthday"));
        		i++;
        		user[i].show();
        	}
        	rs.close();
        	con.close();
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    	return user;
    }
}