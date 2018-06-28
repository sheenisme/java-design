package UI;
import javax.swing.*;
import mysql.Data_sql;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 管理界面类 
 * @author 广辉
 * 
 */
@SuppressWarnings("serial")
public class Mutual_ui extends JFrame implements ActionListener{
	JFrame window;
	JMenuBar menubar;//创建菜单条
	JMenu menu1,menu2,menu3,submenu;//创建菜单
	JMenuItem item1,item2,item3;//创建菜单项    PS:菜单项放在菜单里，菜单放在菜单条里
	Win_table wt;//创建生成表格组件的类
	Data_sql ds;//创建配件的数据库类
	
	public Mutual_ui() {
		
	}
	
	//管理菜单设置
	public void manger_menu() {
		window=new JFrame();
		init_manger_menu("电脑库存管理系统");
		this.setBackground(Color.BLUE);
		this.setLocation(480,200);
		this.setSize(670,455);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//初始化菜单
	void init_manger_menu(String s) {
		this.setTitle(s);
		menubar=new JMenuBar();
		menu1=new JMenu("菜单");
		menu2=new JMenu("关于我们");
		menu3=new JMenu("安全退出");
		
		submenu=new JMenu("仓库信息");
		item1=new JMenuItem("配件入库");
		item2=new JMenuItem("配件出库");
		item3=new JMenuItem("退货入库");
		item1.setAccelerator(KeyStroke.getKeyStroke('E'));
		item2.setAccelerator(KeyStroke.getKeyStroke('Q'));
		item3.setAccelerator(KeyStroke.getKeyStroke('R'));
		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu1.addSeparator();
		menu1.add(submenu);
		menu1.add(menu2);
		
		submenu.add(new JMenuItem("供应商信息"));
		submenu.add(new JMenuItem("配件信息"));
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar);
	}
	
	//创建中间的表格显示
	public void center_table() {
    	ds=new Data_sql();
		wt=new Win_table(ds.getrecord(),ds.getcolumname(),this);
//		this.add(new JScrollPane(wt.table));调试表格JTable用的，可删除
	}
	
	//设置底部的各个按钮
	public void operation() {

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		
	}	
}