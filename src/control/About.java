package control;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class About extends JFrame{
	public About(JFrame win) {
		JOptionPane.showMessageDialog(win, "Made by �ι�ԣ�Email:sheensong@163.com)!");
		win.dispose();
	}
	
	public About() {
		JOptionPane.showMessageDialog(this, "Made by �ι�ԣ�Email:sheensong@163.com)!");
		this.dispose();
	}
}