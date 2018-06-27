package curriculum_design;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
/**
 * 两个界面类如下 
 * @author 广辉
 *
 */


/**
 * 管理界面类 
 * @author 广辉
 *
 */
/*@SuppressWarnings("serial")
class Manager_ui extends JFrame{
	JFrame window;
	JMenuBar menubar;//创建菜单条
	JMenu menu1,menu2,menu3,submenu;//创建菜单
	JMenuItem item1,item2,item3;//创建菜单项    PS:菜单项放在菜单里，菜单放在菜单条里
	
	//管理菜单设置
	public void manger_menu() {
		window=new JFrame();
		init_manger_menu("电脑库存管理系统");
		window.setBackground(Color.BLUE);
		window.setLocation(300,200);
		window.setSize(400,400);
		window.setBackground(Color.YELLOW);
		window.setVisible(true);
		window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	void init_manger_menu(String s) {
		window.setTitle(s);
		menubar=new JMenuBar();
		menu1=new JMenu("菜单");
		menu2=new JMenu("关于我们");
		menu3=new JMenu("安全退出");
		
		submenu=new JMenu("仓库信息");
		item1=new JMenuItem("菜单项1");
		item2=new JMenuItem("菜单项2");
		item3=new JMenuItem("安全退出");
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));
		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(submenu);
		menu1.add(menu2);
		
		submenu.add(new JMenuItem("这就是爱"));
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar);
	}	
}
*/
/**
 * 登陆界面类如下 
 * @author 广辉
 *
 */
@SuppressWarnings("serial")
public class login_ui extends JFrame{
	ActionListener listener;
	public boolean manger_login() {
		@SuppressWarnings("unused")
		User user[]=null;


		initui();
        User_sql usersql=new User_sql();
        usersql.initsql();
        user=usersql.getuser();
        
   
		return true;
	}
	
	private void initui() {
		JFrame jframe=new JFrame();
		jframe.setTitle("欢迎来到电脑配件库存管理系统");
		
/*		Container con1=this.getContentPane();
		con1.setBackground(Color.white);
		jframe.setBounds(580,380,425,280);
		jframe.setResizable(false);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
写代码过程中发现，必须要把JFramede的设置放在最后，
才可以避免没有立即显示的问题。这个bug 真是令人难受	*/

		jframe.setLayout(new FlowLayout());
		Box box;
		Box box1,box2,box3;
		box=Box.createHorizontalBox();
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createVerticalBox();
		JLabel jlabel1,jlabel2;
	
		jlabel1=new JLabel("账户：");
		jlabel2=new JLabel("密码：");
		JCheckBox cb=new JCheckBox("记住密码");
		Button bt=new Button("登陆");
		JTextField user=new JTextField(12);
		JTextField password=new JTextField(12);
		
		//利用嵌套实现好看的布局
		box1.add(jlabel1);
		box2.add(user);
		box1.add(jlabel2);
		box2.add(password);
		box.add(box1);
		box.add(Box.createHorizontalStrut(10));
		box.add(box2);
		box3.add(box);
		box3.add(cb);
		box3.add(bt);
		
		jframe.add(box3);
		jframe.pack();
		
		listener=new ButtonReader();
		bt.addActionListener(listener);
		
		Container con1=this.getContentPane();
		con1.setBackground(Color.white);
		jframe.setBounds(580,300,425,280);
		jframe.setResizable(false);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}