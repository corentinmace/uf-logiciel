package front;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Window extends JFrame{
//	Frame = this
	
	public Window(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(new Dimension(width, height));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		loadingGUI();
	}
	
	private void loadingGUI() {
		JLabel mainTitle = new JLabel();
		JProgressBar loadBar = new JProgressBar();
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 50));
		this.add(loadBar);
		this.add(mainTitle);
		
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(100);
				loadBar.setValue(i);
				mainTitle.setText("Loading... (" + i + "%)");
				if(i > 99) {
					displayGUI();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void displayGUI() {
		System.out.println("Application loaded !");
		
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
	}
}
