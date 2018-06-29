package control;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class About extends JFrame{
	public About(JFrame win) {
		JOptionPane.showMessageDialog(win, "Made by ËÎ¹ã»Ô£¨Email:sheensong@163.com)!");
		win.dispose();
	}
	
	public About() {
		JOptionPane.showMessageDialog(this, "Made by ËÎ¹ã»Ô£¨Email:sheensong@163.com)!");
		this.dispose();
	}
}