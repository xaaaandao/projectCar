import java.awt.*;
import javax.swing.*;

public class Frame {

	/* Tamanho da tela principal */
	int height = 300;
	int width = 350;
	
	public JFrame buildFrame(String title) {
		return new JFrame(title);
	}
	
	public void setDefaultFrame(JFrame window) {
		window.add(new JPanel(), BorderLayout.CENTER);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(height, width);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
}
