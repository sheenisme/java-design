package UI;
import javax.swing.*;


/**
 * ��ʾ�Լ�������Ϣ�ı��ҳ�����
 * @author ���
 *
 */
@SuppressWarnings("serial")
public class Win_table extends JFrame{
	JFrame win=new JFrame();
	public JTable table;
	Object obj[][];
	Object name[];
	public Win_table() {
		
	}	
	public Win_table(Object obj[][],Object name[],JFrame win) {
		table=new JTable(obj,name);
		win.add(table);
		win.add(new JScrollPane(table));
		win.setVisible(true);
		win.validate();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setname(Object name[]) {
		this.name=name;
	}
	
	public void setobj(Object obj[][]) {
		this.obj=obj;
	}
}