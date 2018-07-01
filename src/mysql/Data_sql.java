package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class Data_sql{
	// JDBC 驱动名及数据库 URL 
    static final String DB_URL = "jdbc:mysql://localhost:3306/pc stock control?&useSSL=false&serverTimezone=UTC";//"jdbc:mysql://localhost：3306/pc stock control?&useSSL=false&serverTimezone=UTC";
    // 数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "";
	public Connection con = null;
	Statement sql;
	ResultSet rs;
	Parts ps[];
	String columnName[];//字段表名数组
	String record[][];//记录表（二维）数组
	
	
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
    
/*    //显示数据库库存信息
    public Parts[]  showall()
    {
    	try {
    		int i=0;
    		int number;
    		sql=con.createStatement();//创建SQL语句对象
        	rs=sql.executeQuery("select * from `table`");
        	//System.out.println("编号     类型       总量        余量      销量     价格     供应商      其它 ");
        	while(rs.next()) {
        		number=rs.getInt("number");
        		if(number>0)
        		{
        			ps[i]=new Parts(rs.getString("type"),rs.getInt("total"),rs.getInt("sales"),rs.getInt("price"),rs.getString("supplier"));
        			return ps;
        		}
        	}
    	}catch(SQLException e) {
        	System.out.println(e);
        }
		return null;
    } */
    
    
    
    //入库操作
    public void in(String head[],String content[])
    {
    	initsql();

    	try {
    		sql=con.createStatement();//创建SQL语句对象
    		String ss="insert into `table` values (?,?,?,?,?,?,?,?)";//错误示范：+"("+content[0]+","+content[1]+","+content[2]+","+content[3]+","+content[4]+","+content[5]+","+"'content[6]'"+","+"'content[7]'"+")";
//测试用例代码，可删    		sql.execute("insert into `table` values (11,'erji',10,10,0,5,'akg','kong')");       
            PreparedStatement preStmt = (PreparedStatement) con.prepareStatement(ss);
            preStmt.setInt(1, Integer.parseInt(content[0]));
            preStmt.setString(2,content[1]);
            preStmt.setInt(3, Integer.parseInt(content[2]));
            preStmt.setInt(4, Integer.parseInt(content[3]));
            preStmt.setInt(5, Integer.parseInt(content[4]));
            preStmt.setInt(6, Integer.parseInt(content[5]));
            preStmt.setString(7,content[6]);
            preStmt.setString(8,content[7]);
            
            preStmt.executeUpdate();
           // sql.executeUpdate(ss);    
            preStmt.close();
            con.close();
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    }  
    
    
    //出库
    public void out(String key,String content)
    {
    	initsql();
    	try {
    		sql=con.createStatement();//创建SQL语句对象
        	sql.execute("delete from `table` where "+key+"="+content);
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    }  
    
    //退货入库
    public void rejected()
    {
    	try {
    		sql=con.createStatement();//创建SQL语句对象
        	rs=sql.executeQuery("select * from `table`");
        	System.out.println("编号     类型       总量        余量      销量     价格     供应商      其它 ");
        	while(rs.next()) {
        		System.out.printf(rs.getInt("number")+"    "+rs.getString("type")+"     "+rs.getString("total")+"     "
        		+rs.getString("allowance")+"   "+rs.getString("sales")+"   "+rs.getString("price")+"   "
        		+rs.getString("supplier")+"   "+rs.getString("others")+"\n");
        	}
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    }  

   //设置数据库的字段名字数组
	private void setColumnName() {
    	initsql();
    	try {
			sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=sql.executeQuery("select * from `table`");
			ResultSetMetaData metadata=rs.getMetaData();
			int length=metadata.getColumnCount();
			columnName =new String[length];
			for(int i=1;i<=length;i++) {
				columnName[i-1]=metadata.getColumnName(i);
			}
			rs.last();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
	
    //设置数据库的记录的二维数组
    private void setrecord() {
    	setColumnName();
    	try {
    		int recordamount=rs.getRow();
    		int length=columnName.length;
    		record=new String[recordamount][length];
    		int i=0;
    		rs.beforeFirst();
    		while(rs.next()) {
    			for(int j=1;j<=columnName.length;j++) {
    				record[i][j-1]=rs.getString(j);
    			}
    			i++;
    		}
    	} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
    
    //返回字段名数组函数
    public String [] getcolumname() {
    	if(columnName==null)
    	{
    		setColumnName();
    		if(columnName==null) {
    			System.out.println("获取字段名数组函数出错");
    			return null;
    		}
    	}
		return columnName;
    }
    
    //返回记录（二维）数组函数
    public String [][] getrecord() {
    	if(record==null) {
    		setColumnName();
    		setrecord();
    		if(record==null) {
    			System.out.println("获取记录（二维）数组函数出错");
    			return null;
    		}
    	}
		return record;
    }
    
    public void close(Connection con)
    {
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
}

