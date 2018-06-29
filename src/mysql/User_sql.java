package mysql;
import java.sql.*;

/**
 * 用户类数据库
 */
public class User_sql{
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
    
    /**
     * 从数据库获取user表中的user
     * @return
     */
	public User[] getuser() {
		int i=0;
		User user[];
		user=new User[12];
    	try {
    		sql=con.createStatement();//创建SQL语句对象
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