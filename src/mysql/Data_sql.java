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
    static final String DB_URL ="jdbc:mysql://localhost:3306/pc stock control?&useSSL=false&serverTimezone=UTC";//"jdbc:mysql://localhost：3306/pc stock control?&useSSL=true";
    // 数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "";
	public Connection con = null;
	Statement sql;
	ResultSet rs;
	Parts ps[];
	String columnName[];//字段表名数组
	String record[][];//记录表（二维）数组
	private String suppliersrecord[][];
	private String suppliersname[];
	private String partsrecord[][];
	private String partsname[];
	private String pricerecord[][];
	private String pricename[];
	int recordamount;
	
	
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
    
    //判断数据库信息的
    public boolean judge(){
    	initsql();
    	setrecord();
    	for(int i=1;i<recordamount;i++) {
    		if(Integer.parseInt(record[i-1][2]) != (Integer.parseInt(record[i-1][3])+Integer.parseInt(record[i-1][4])))
    		{
    			//JOptionPane.showMessageDialog(this, "number为："+record[i][0]+"的记录库存信息有问题，请核对！！！！");
    			System.out.println("number为："+record[i-1][0]+"的记录库存信息有问题，请核对！！！！");
    			//return false;
    		}
    	}
    	return true;
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
    public void out(String number,String content,String amount)
    {
    	initsql();
    	try {
    		sql=con.createStatement();//创建SQL语句对象
        	sql.execute("update `table` set allowance = allowance-"+amount+",sales=sales+"+amount+" where "+number+"="+content);
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    }  
    
 /*   public String[] search(String number ) {
		try {
			int a=rs.getRow();
			int b=columnName.length;
			int i,j;
			for(i=0;i<a;i++)
			{
				if(record[i][1]==number) {
					return record[i];
				}
			}
			return record[i];
		}catch{
			
		}
    	
    }*/
   
    //退货入库
    public void add(String number,String content,String amount)
    {
    	initsql();
    	try {
    		sql=con.createStatement();//创建SQL语句对象
        	sql.execute("update `table` set allowance = allowance+"+amount+",sales=sales-"+amount+" where "+number+"="+content);
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
    		recordamount=rs.getRow();
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
    
    public void setsuppliers() {
    	setColumnName();
    	setrecord();
    	suppliersrecord=new String[recordamount][5];
    	for(int i=0;i<recordamount;i++) {
    		suppliersrecord[i][0]=record[i][0];
        	suppliersrecord[i][1]=record[i][1];
        	suppliersrecord[i][2]=record[i][2];
        	suppliersrecord[i][3]=record[i][6];
        	suppliersrecord[i][4]=record[i][7];
    	}
    	
    	suppliersname=new String[5];
    	suppliersname[0]=columnName[0];
    	suppliersname[1]=columnName[1];
    	suppliersname[2]=columnName[2];
    	suppliersname[3]=columnName[6];
    	suppliersname[4]=columnName[7];
    }
    
    public String[] getsuppliername(){
    	setsuppliers();
		return suppliersname;
    	
    }
    
    public String[][] getsupplierrecord(){
    	setsuppliers();
    	return suppliersrecord;
    }
    
    public void setparts() {
    	setColumnName();
    	setrecord();
    	partsrecord=new String[recordamount][5];
    	for(int i=0;i<recordamount;i++) {
    		partsrecord[i][0]=record[i][0];
    		partsrecord[i][1]=record[i][1];
    		partsrecord[i][2]=record[i][3];
    		partsrecord[i][3]=record[i][5];
    		partsrecord[i][4]=record[i][7];
    	}
    	
    	partsname=new String[5];
    	partsname[0]=columnName[0];
    	partsname[1]=columnName[1];
    	partsname[2]=columnName[3];
    	partsname[3]=columnName[5];
    	partsname[4]=columnName[7];
    }
    
    public String[] getpartsname() {
    	setparts();
    	return partsname;
    }
    
    public String[][] getpartsrecord(){
    	setparts();
    	return partsrecord;
    }
    
    
    public void setprice() {
    	setColumnName();
    	setrecord();
    	pricerecord=new String[recordamount][5];
    	for(int i=0;i<recordamount;i++) {
    		pricerecord[i][0]=record[i][0];
    		pricerecord[i][1]=record[i][1];
    		pricerecord[i][2]=record[i][4];
    		pricerecord[i][3]=record[i][5];
    		pricerecord[i][4]=record[i][7];
    	}
    	
    	pricename=new String[5];
    	pricename[0]=columnName[0];
    	pricename[1]=columnName[1];
    	pricename[2]=columnName[4];
    	pricename[3]=columnName[5];
    	pricename[4]=columnName[7];
    }
    
    public String[] getpricename() {
    	setparts();
    	return pricename;
    }
    
    public String[][] getpricerecord(){
    	setparts();
    	return pricerecord;
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