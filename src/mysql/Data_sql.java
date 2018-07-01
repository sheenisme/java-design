package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class Data_sql{
	// JDBC �����������ݿ� URL 
    static final String DB_URL = "jdbc:mysql://localhost:3306/pc stock control?&useSSL=false&serverTimezone=UTC";//"jdbc:mysql://localhost��3306/pc stock control?&useSSL=false&serverTimezone=UTC";
    // ���ݿ���û���������
    static final String USER = "root";
    static final String PASS = "";
	public Connection con = null;
	Statement sql;
	ResultSet rs;
	Parts ps[];
	String columnName[];//�ֶα�������
	String record[][];//��¼����ά������
	
	
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
             //System.out.println("�������������ݿ�...");
             con = DriverManager.getConnection(DB_URL,USER,PASS);
             //System.out.println("�������������ݿ�ɹ�������");
         }catch(SQLException e){   // ���� JDBC ����
         	System.out.println(e);
         }
    }
    
/*    //��ʾ���ݿ�����Ϣ
    public Parts[]  showall()
    {
    	try {
    		int i=0;
    		int number;
    		sql=con.createStatement();//����SQL������
        	rs=sql.executeQuery("select * from `table`");
        	//System.out.println("���     ����       ����        ����      ����     �۸�     ��Ӧ��      ���� ");
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
    
    
    
    //������
    public void in(String head[],String content[])
    {
    	initsql();

    	try {
    		sql=con.createStatement();//����SQL������
    		String ss="insert into `table` values (?,?,?,?,?,?,?,?)";//����ʾ����+"("+content[0]+","+content[1]+","+content[2]+","+content[3]+","+content[4]+","+content[5]+","+"'content[6]'"+","+"'content[7]'"+")";
//�����������룬��ɾ    		sql.execute("insert into `table` values (11,'erji',10,10,0,5,'akg','kong')");       
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
    
    
    //����
    public void out(String key,String content)
    {
    	initsql();
    	try {
    		sql=con.createStatement();//����SQL������
        	sql.execute("delete from `table` where "+key+"="+content);
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    }  
    
    //�˻����
    public void rejected()
    {
    	try {
    		sql=con.createStatement();//����SQL������
        	rs=sql.executeQuery("select * from `table`");
        	System.out.println("���     ����       ����        ����      ����     �۸�     ��Ӧ��      ���� ");
        	while(rs.next()) {
        		System.out.printf(rs.getInt("number")+"    "+rs.getString("type")+"     "+rs.getString("total")+"     "
        		+rs.getString("allowance")+"   "+rs.getString("sales")+"   "+rs.getString("price")+"   "
        		+rs.getString("supplier")+"   "+rs.getString("others")+"\n");
        	}
    	}catch(SQLException e) {
        	System.out.println(e);
        }
    }  

   //�������ݿ���ֶ���������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    }
	
    //�������ݿ�ļ�¼�Ķ�ά����
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    }
    
    //�����ֶ������麯��
    public String [] getcolumname() {
    	if(columnName==null)
    	{
    		setColumnName();
    		if(columnName==null) {
    			System.out.println("��ȡ�ֶ������麯������");
    			return null;
    		}
    	}
		return columnName;
    }
    
    //���ؼ�¼����ά�����麯��
    public String [][] getrecord() {
    	if(record==null) {
    		setColumnName();
    		setrecord();
    		if(record==null) {
    			System.out.println("��ȡ��¼����ά�����麯������");
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    }
}

