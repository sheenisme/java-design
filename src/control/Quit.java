package control;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Quit extends JFrame{
	public Quit(JFrame win){
		JOptionPane.showMessageDialog(win, "ȷ��Ҫ�˳���");
		win.dispose();
		System.exit(0);
	}
	
	public Quit(){
		JOptionPane.showMessageDialog(this, "ȷ��Ҫ�˳���");
		this.dispose();
		System.exit(0);
	}
}