package UI;
import javax.swing.*;
import mysql.Data_sql;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * ��������� 
 * @author ���
 * 
 */
@SuppressWarnings("serial")
public class Mutual_ui extends JFrame implements ActionListener{
	JFrame window;
	ActionListener listener;
	Win_table wt;//�������ɱ���������
	Data_sql ds;//������������ݿ���
	JMenuBar menubar;//�����˵���
	JMenu menu1,menu2,menu3,submenu;//�����˵�
	JMenuItem item1,item2,item3;//�����˵���    PS:�˵�����ڲ˵���˵����ڲ˵�����
	JMenuItem subitem1,subitem2;//�����Ӳ˵��Ĳ˵���
	
	public Mutual_ui() {
		
	}
	
	//����˵�����
	public void manger_menu() {
		window=new JFrame();
		init_manger_menu("���Կ�����ϵͳ");
		this.setBackground(Color.BLUE);
		this.setLocation(480,200);
		this.setSize(670,455);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//��ʼ���˵�
	void init_manger_menu(String s) {
		this.setTitle(s);
		menubar=new JMenuBar();
		menu1=new JMenu("�˵�");
		menu2=new JMenu("��������");
		menu3=new JMenu("��ȫ�˳�");
		
		submenu=new JMenu("�ֿ���Ϣ");
		item1=new JMenuItem("������");
		item2=new JMenuItem("�������");
		item3=new JMenuItem("�˻����");
		subitem1=new JMenuItem("��Ӧ����Ϣ");
		subitem2=new JMenuItem("�����Ϣ");
		
		menu2.addActionListener(this);
		menu3.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		subitem1.addActionListener(this);
		subitem2.addActionListener(this);
		
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
		

		submenu.add(subitem1);
		submenu.add(subitem2);
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar);
		

	}
	
	//�����м�ı����ʾ
	public void center_table() {
    	ds=new Data_sql();
		wt=new Win_table(ds.getrecord(),ds.getcolumname(),this);
//		this.add(new JScrollPane(wt.table));���Ա��JTable�õģ���ɾ��
	}
	
	//���õײ��ĸ�����ť
	public void operation() {

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource() == menu2) {
			System.out.println("��������\n");//��������
		}
		else if(e.getSource() == menu3) {
			window.dispose();
			System.out.println("�˳�\n");//�˳�
		}
		else if(e.getSource() == item1) {
			System.out.println("���\n");//���
		}
		else if(e.getSource() == item2) {
			System.out.println("����\n");//����
		}
		else if(e.getSource() == item3) {
			System.out.println("�˻����\n");//�˻����
		}
		else if(e.getSource() == subitem1) {
			System.out.println("��������Ϣ\n");//��������Ϣ
		}
		else if(e.getSource() == subitem2) {
			System.out.println("�����Ϣ\n");//�����Ϣ
		}
		else
			System.out.println("�¼�Դ����\n");
	}	
}