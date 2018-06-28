package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.*;
import mysql.*;

/**
 * ��½���������� 
 * @author ���
 *
 */
@SuppressWarnings("serial")
public class Login_ui extends JFrame implements ActionListener{
	ActionListener listener;
	JFrame jframe=new JFrame();
	private JTextField input_id=new JTextField(12);
	private JPasswordField input_passward=new JPasswordField(12);
	
	User_sql usersql=new User_sql();
	Mutual_ui mu=new Mutual_ui();


	public void manger_login() {

		initui();
		usersql.initsql();
 
	}
	
	private void initui() {
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
		JButton bt=new JButton("��½");
		
		
		//����Ƕ��ʵ�ֺÿ��Ĳ���
		box1.add(jlabel1);
		box2.add(input_id);
		box1.add(jlabel2);
		box2.add(input_passward);
		box.add(box1);
		box.add(Box.createHorizontalStrut(10));
		box.add(box2);
		box3.add(box);
		box3.add(cb);
		box3.add(bt);
		bt.addActionListener(this);
		
		jframe.add(box3);
		jframe.pack();
		 
		
		
		Container con1=this.getContentPane();
		con1.setBackground(Color.white);
		jframe.setBounds(580,300,425,280);
		jframe.setResizable(false);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
    /**
     * �����¼��ť����¼�������
     */
	public void actionPerformed(ActionEvent e) {
		User [] user;
		user=usersql.getuser();
		if(input_id.getText().equals(null))
		{
			JOptionPane.showMessageDialog(this, "��������Ҫ��½���˻���");
			this.dispose();
		}
		else if(new String(input_passward.getPassword()).equals(null))
		{
			JOptionPane.showMessageDialog(this, "���������룡");
			this.dispose();
		}
		else if (!(input_id.getText().equals(null)) && !(new String(input_passward.getPassword()).equals(null)))
		{
			int i=0;
			for(;i<User.total;i++) {
				if(input_id.getText().equals(user[i].getid()) && new String(input_passward.getPassword()).equals(user[i].getpassward())) 
				{
					System.out.println("��½�ɹ�\n");
					jframe.dispose();
			        mu.manger_menu();
			        mu.center_table();
					break;
				}
			}
			if(i>=User.total)
				JOptionPane.showMessageDialog(this, "�˻����������������");
		}
	   
	}	
		
}