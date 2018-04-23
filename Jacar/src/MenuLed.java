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
		/* Criando o JDialog */
		JDialog dialog = new JDialog(new JFrame(), "Acenda e apague o Led", true);

		/* Criando as vari�veis da barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);

		/* Criando as vari�veis da label e dos bot�es */
		JLabel labelMenuLed = new JLabel("Deixe o led acesso ou apagado: ");
		JButton acenderButton = new JButton("Acenda");
		JButton apagarButton = new JButton("Apague");

		/* Tornando v�sivel a label e os bot�es */
		labelMenuLed.setVisible(true);
		acenderButton.setVisible(true);
		apagarButton.setVisible(true);
		
		/* Definindo as coordenadas da label e os bot�es */
		labelMenuLed.setBounds(labelX, labelY, labelWidth, labelHeight);
		acenderButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		apagarButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);

		/* Adicionando bot�es no panel */
		dialog.add(labelMenuLed);
		dialog.add(acenderButton);
		dialog.add(apagarButton);
		
		/* Chamando os listener dos bot�es */
		acenderButtonListener(acenderButton);
		apagarButtonListener(apagarButton);
		
		/* Adicionando tamanho, posi��o, fechar e ficar vis�vel */
		dialog.setJMenuBar(barMenu);
		dialog.setLayout(null);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(height, width);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
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
