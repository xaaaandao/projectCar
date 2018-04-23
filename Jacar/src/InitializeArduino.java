import java.awt.*;
import javax.swing.*;

public class InitializeArduino {
	/* Tamanho da tela principal */
	int height = 300;
	int width = 100;
	
	/* Minimo e máximo da barra de progresso */
	int minimo = 0;
	int maximo = 100;
	
	int rows = 2;
	int columns = 1;
	
	public InitializeArduino() throws InterruptedException {
		JPanel panel = new JPanel(new GridLayout(rows, columns));
		JFrame frame = new JFrame("Conexão com arduino");
		
		JProgressBar progressBar = new JProgressBar(minimo, maximo);
		JLabel label = new JLabel("Tentando conexão com arduino");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(label);
		panel.add(progressBar);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(height, width);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		for(int i = minimo; i <= maximo; i++){
			if(i < 20)
				label.setText("Conectando com arduino...");
			else if(i < 30)
				label.setText("Conectado!!!");
			else
				label.setText("Definindo algumas configurações...");
			progressBar.setValue(i);
			progressBar.setStringPainted(true);
			Thread.sleep(100);
		}
		
	}
}
