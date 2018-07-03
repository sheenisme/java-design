package UI;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import control.*;
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
	ActionListener listener;
	Win_table wt;//创建生成表格组件的类
	Data_sql ds;//创建配件的数据库类
	JMenuBar menubar;//创建菜单条
	JMenu menu1,menu2,menu3,submenu;//创建菜单
	JMenuItem item1,item2,item3;//创建菜单项    PS:菜单项放在菜单里，菜单放在菜单条里
	JMenuItem subitem1,subitem2,subitem3;//创建子菜单的菜单项
	Button addbt,reducebt;
	JTextField jtf;
	JTable tin;
	//管理菜单设置
	public void manger_menu() {
		window=new JFrame();
		init_manger_menu("电脑配件库存管理系统");
/*		this.setBackground(Color.BLUE);
		this.setLocation(480,200);
		this.setSize(670,655);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);*/
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
		subitem1=new JMenuItem("供应商信息");
		subitem2=new JMenuItem("配件信息");
		subitem3=new JMenuItem("价格信息");
		
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
		menu2.add(menu2);
		menu3.add(menu3);

		submenu.add(subitem1);
		submenu.add(subitem2);
		submenu.add(subitem3);
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar);
		

		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		subitem1.addActionListener(this);
		subitem2.addActionListener(this);
		subitem3.addActionListener(this);
		menu2.addMenuListener(new MenuListener() {
			 public void menuSelected(MenuEvent e) {
				 new About();
			 }

			public void menuDeselected(MenuEvent e) {
			
			}

			public void menuCanceled(MenuEvent e) {
				
			}
		});
		
		menu3.addMenuListener(new MenuListener() {
			 public void menuSelected(MenuEvent e) {
				 new Quit();   
			 }

			public void menuDeselected(MenuEvent e) {
			        
			}

			public void menuCanceled(MenuEvent e) {
			        
			}
		});
		
	}
	
	//创建中间的表格显示
	public void center_table() {
    	ds=new Data_sql();
    	ds.judge();
		this.setLayout(new GridLayout(2,1));//new FlowLayout()
		Box bx1,bx2,bx3,bx11;
		tin=new JTable(ds.getrecord(),ds.getcolumname());
		tin.setCellSelectionEnabled(true); 
		
		JScrollPane js=new JScrollPane(tin);
		js.setLocation(0,0);
		js.setSize(670,300);
		
			
		//设置底部的按钮
	
		bx1=Box.createHorizontalBox();
		bx11=Box.createVerticalBox();
		bx1.add(Box.createHorizontalStrut(230));//左右部件之间的中间间隔就可以用这个方法来控制,创建一个不可见的、固定宽度的组件。
		bx1.add(new JLabel("number:"));
		jtf=new JTextField();
		bx1.add(jtf);
		bx1.add(Box.createHorizontalStrut(260));

		bx11.add(Box.createVerticalStrut(150));
		bx11.add(bx1);
		bx11.add(Box.createVerticalStrut(30));
		
		bx2=Box.createHorizontalBox();
		addbt=new Button("配件库存自增1");
		reducebt=new Button("配件库存自减1");
		bx2.add(Box.createHorizontalStrut(50));
		bx2.add(addbt);
		bx2.add(Box.createHorizontalStrut(100));
		bx2.add(reducebt);
		bx2.add(Box.createHorizontalStrut(50));
		
		bx3=Box.createVerticalBox();
		bx3.add(bx11);
		bx3.add(bx2);
		bx3.add(Box.createVerticalStrut(100));

		this.add(js);
		this.add(bx3);
		
		addbt.addActionListener(this);
		reducebt.addActionListener(this);
		
		this.setBackground(Color.BLUE);
		this.setLocation(480,180);
		this.setSize(670,580);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == item1) {
			this.dispose();
			new in();
			//System.out.println("入库\n");//入库
		}
		else if(e.getSource() == item2) {
			this.dispose();
			new out();
			//System.out.println("出库\n");//出库
		}
		else if(e.getSource() == item3) {
			this.dispose();
			new rejected();
			//System.out.println("退货入库\n");//退货入库
		}
		else if(e.getSource() == subitem1) {
			new suppliers();
			//System.out.println("供货商信息\n");//供货商信息
		}
		else if(e.getSource() == subitem2) {
			new pcparts();
			//System.out.println("配件信息\n");//配件信息
		}
		else if(e.getSource() == subitem3) {
			new price();
			//System.out.println("价格信息\n");//配件信息
		}else if(e.getSource() == addbt) {
			if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "输入非法！");
				this.dispose();
			}
			else{
				ds.add("number", jtf.getText(), "1");
				this.dispose();
				new repaint();
			}
			
			//this.dispose();	
			//manger_menu();
			//center_table();
			//System.out.println("自增\n");
		}else if(e.getSource() == reducebt) {
			if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "输入非法！");
				this.dispose();
			}
			else{
				ds.out("number",  jtf.getText(), "1");
				this.dispose();
				new repaint();
			}
			//this.dispose();	
			//manger_menu();
			//center_table();
			//System.out.println("自减\n");
		}
		else
			System.out.println("事件源有误！\n");
	}

}

//修改菜单事件代码的原始版本如下：
/*	public void menuSelected(MenuEvent e) {//当菜单被选中
/*if(e.getSource() == menu2) {
	new About();
	System.out.println("关于我们\n");//关于我们
}
else if(e.getSource() == menu3) {
	this.dispose();
	new Quit();
	System.out.println("退出\n");//退出
}
else {
	System.out.println("事件源有误！\n");
}*/

/*		System.out.println("3333333");
}

@Override
public void menuCanceled(MenuEvent e) {
// TODO 自动生成的方法存根
/*	if(e.getSource() == menu2) {
	new About();
	System.out.println("关于我们\n");//关于我们
}
else if(e.getSource() == menu3) {
	this.dispose();
	new Quit();
	System.out.println("退出\n");//退出
}
else {
	System.out.println("事件源有误！\n");
}*/
/*		System.out.println("22222222");
}

@Override
public void menuDeselected(MenuEvent e) {
// TODO 自动生成的方法存根
/*		if(e.getSource() == menu2) {
	new About();
	System.out.println("关于我们\n");//关于我们
}
else if(e.getSource() == menu3) {
	this.dispose();
	new Quit();
	System.out.println("退出\n");//退出
}
else {
	System.out.println("事件源有误！\n");
}*/
/*		System.out.println("11111111");
}*/