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
	JMenuItem subitem1,subitem2,subitem3;//�����Ӳ˵��Ĳ˵���
	Button addbt,reducebt;
	JTextField jtf;
	JTable tin;
	//����˵�����
	public void manger_menu() {
		window=new JFrame();
		init_manger_menu("�������������ϵͳ");
/*		this.setBackground(Color.BLUE);
		this.setLocation(480,200);
		this.setSize(670,655);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);*/
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
		subitem3=new JMenuItem("�۸���Ϣ");
		
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
	
	//�����м�ı����ʾ
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
		
			
		//���õײ��İ�ť
	
		bx1=Box.createHorizontalBox();
		bx11=Box.createVerticalBox();
		bx1.add(Box.createHorizontalStrut(230));//���Ҳ���֮����м����Ϳ������������������,����һ�����ɼ��ġ��̶���ȵ������
		bx1.add(new JLabel("number:"));
		jtf=new JTextField();
		bx1.add(jtf);
		bx1.add(Box.createHorizontalStrut(260));

		bx11.add(Box.createVerticalStrut(150));
		bx11.add(bx1);
		bx11.add(Box.createVerticalStrut(30));
		
		bx2=Box.createHorizontalBox();
		addbt=new Button("����������1");
		reducebt=new Button("�������Լ�1");
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
		// TODO �Զ����ɵķ������
		if(e.getSource() == item1) {
			this.dispose();
			new in();
			//System.out.println("���\n");//���
		}
		else if(e.getSource() == item2) {
			this.dispose();
			new out();
			//System.out.println("����\n");//����
		}
		else if(e.getSource() == item3) {
			this.dispose();
			new rejected();
			//System.out.println("�˻����\n");//�˻����
		}
		else if(e.getSource() == subitem1) {
			new suppliers();
			//System.out.println("��������Ϣ\n");//��������Ϣ
		}
		else if(e.getSource() == subitem2) {
			new pcparts();
			//System.out.println("�����Ϣ\n");//�����Ϣ
		}
		else if(e.getSource() == subitem3) {
			new price();
			//System.out.println("�۸���Ϣ\n");//�����Ϣ
		}else if(e.getSource() == addbt) {
			if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "����Ƿ���");
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
			//System.out.println("����\n");
		}else if(e.getSource() == reducebt) {
			if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "����Ƿ���");
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
			//System.out.println("�Լ�\n");
		}
		else
			System.out.println("�¼�Դ����\n");
	}

}

//�޸Ĳ˵��¼������ԭʼ�汾���£�
/*	public void menuSelected(MenuEvent e) {//���˵���ѡ��
/*if(e.getSource() == menu2) {
	new About();
	System.out.println("��������\n");//��������
}
else if(e.getSource() == menu3) {
	this.dispose();
	new Quit();
	System.out.println("�˳�\n");//�˳�
}
else {
	System.out.println("�¼�Դ����\n");
}*/

/*		System.out.println("3333333");
}

@Override
public void menuCanceled(MenuEvent e) {
// TODO �Զ����ɵķ������
/*	if(e.getSource() == menu2) {
	new About();
	System.out.println("��������\n");//��������
}
else if(e.getSource() == menu3) {
	this.dispose();
	new Quit();
	System.out.println("�˳�\n");//�˳�
}
else {
	System.out.println("�¼�Դ����\n");
}*/
/*		System.out.println("22222222");
}

@Override
public void menuDeselected(MenuEvent e) {
// TODO �Զ����ɵķ������
/*		if(e.getSource() == menu2) {
	new About();
	System.out.println("��������\n");//��������
}
else if(e.getSource() == menu3) {
	this.dispose();
	new Quit();
	System.out.println("�˳�\n");//�˳�
}
else {
	System.out.println("�¼�Դ����\n");
}*/
/*		System.out.println("11111111");
}*/