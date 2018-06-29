package control;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Quit extends JFrame{
	public Quit(JFrame win){
		JOptionPane.showMessageDialog(win, "确定要退出吗？");
		win.dispose();
		System.exit(0);
	}
	
	public Quit(){
		JOptionPane.showMessageDialog(this, "确定要退出吗？");
		this.dispose();
		System.exit(0);
	}
}