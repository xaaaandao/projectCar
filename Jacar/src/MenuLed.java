import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuLed {
	/* Tamanho da tela principal */
	int height = 320;
	int width = 200;
	
	/* Tamanho dos bot�es */
	int buttonWidth = 120;
	int buttonHeight = 50;
	
	/* Coordenadas dos bot�es */
	int buttonX = 95;
	int buttonY = 40;
	
	/* Entre um bot�o e outro adiciona */
	int distanceOfButton = 52;
	
	/* Coordenadas dos labels */
	int labelX = 70;
	int labelY = 10;
	
	/* Tamanho dos bot�es */
	int labelWidth = 200;
	int labelHeight = 30;
	
	public MenuLed() {
		/* Definindo a janela */
		JPanel panel = new JPanel();
		JFrame window = new JFrame("Acenda e apague o Led: ");

		/* Definindo os bot�es e label */
		JButton acenderButton = new JButton("Acenda");
		JButton apagarButton = new JButton("Apague");
		JLabel labelMenu = new JLabel("Deixe o led acesso ou apagado: ");

		/* Definindo a barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
		
		/* Defini alguns padr�es no componentes do menu controle */
		labelMenu.setBounds(labelX, labelY, labelWidth, labelHeight);
		acenderButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		apagarButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
		
		/* Adiciona os itens no menu do controle */
		window.add(labelMenu);
		window.add(acenderButton);
		window.add(apagarButton);
		window.setJMenuBar(barMenu);
					
		/* Defini alguns padr�es no menu do controle */
		window.add(panel, BorderLayout.CENTER);
		window.setSize(height, width);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		/* Chamo os listener */
		acenderButtonListener(acenderButton);
		apagarButtonListener(apagarButton);
		helpMenuItemListener(duvidasMenuItem);
	}
	
	void acenderButtonListener(JButton acenderButton) {
		acenderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void apagarButtonListener(JButton apagarButton) {
		apagarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void helpMenuItemListener(JMenuItem helpMenuItem) {
		helpMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "� Se voc� deseja acender o Led clique no bot�o Acenda;\n" +
						 		 "� Se voc� deseja apagar o Led clique no bot�o Apague.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
