package curriculum_design;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
/**
 * �������������� 
 * @author ���
 *
 */


/**
 * ��������� 
 * @author ���
 *
 */
/*@SuppressWarnings("serial")
class Manager_ui extends JFrame{
	JFrame window;
	JMenuBar menubar;//�����˵���
	JMenu menu1,menu2,menu3,submenu;//�����˵�
	JMenuItem item1,item2,item3;//�����˵���    PS:�˵�����ڲ˵���˵����ڲ˵�����
	
	//����˵�����
	public void manger_menu() {
		window=new JFrame();
		init_manger_menu("���Կ�����ϵͳ");
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
		menu1=new JMenu("�˵�");
		menu2=new JMenu("��������");
		menu3=new JMenu("��ȫ�˳�");
		
		submenu=new JMenu("�ֿ���Ϣ");
		item1=new JMenuItem("�˵���1");
		item2=new JMenuItem("�˵���2");
		item3=new JMenuItem("��ȫ�˳�");
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));
		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(submenu);
		menu1.add(menu2);
		
		submenu.add(new JMenuItem("����ǰ�"));
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar);
	}	
}
*/
/**
 * ��½���������� 
 * @author ���
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
		jframe.setTitle("��ӭ�����������������ϵͳ");
		
/*		Container con1=this.getContentPane();
		con1.setBackground(Color.white);
		jframe.setBounds(580,380,425,280);
		jframe.setResizable(false);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
д��������з��֣�����Ҫ��JFramede�����÷������
�ſ��Ա���û��������ʾ�����⡣���bug ������������	*/

		jframe.setLayout(new FlowLayout());
		Box box;
		Box box1,box2,box3;
		box=Box.createHorizontalBox();
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createVerticalBox();
		JLabel jlabel1,jlabel2;
	
		jlabel1=new JLabel("�˻���");
		jlabel2=new JLabel("���룺");
		JCheckBox cb=new JCheckBox("��ס����");
		Button bt=new Button("��½");
		JTextField user=new JTextField(12);
		JTextField password=new JTextField(12);
		
		//����Ƕ��ʵ�ֺÿ��Ĳ���
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