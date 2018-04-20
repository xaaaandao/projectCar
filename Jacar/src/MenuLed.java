import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuLed {
	/* Tamanho da tela principal */
	int height = 320;
	int width = 200;
	
	/* Tamanho dos botões */
	int buttonWidth = 120;
	int buttonHeight = 50;
	
	/* Coordenadas dos botões */
	int buttonX = 95;
	int buttonY = 40;
	
	/* Entre um botão e outro adiciona */
	int distanceOfButton = 52;
	
	/* Coordenadas dos labels */
	int labelX = 70;
	int labelY = 10;
	
	/* Tamanho dos botões */
	int labelWidth = 200;
	int labelHeight = 30;
	
	public MenuLed() {
		/* Definindo a janela */
		JPanel panel = new JPanel();
		JFrame window = new JFrame("Acenda e apague o Led: ");

		/* Definindo os botões e label */
		JButton acenderButton = new JButton("Acenda");
		JButton apagarButton = new JButton("Apague");
		JLabel labelMenu = new JLabel("Deixe o led acesso ou apagado: ");

		/* Definindo a barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas dúvidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
		
		/* Defini alguns padrões no componentes do menu controle */
		labelMenu.setBounds(labelX, labelY, labelWidth, labelHeight);
		acenderButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		apagarButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
		
		/* Adiciona os itens no menu do controle */
		window.add(labelMenu);
		window.add(acenderButton);
		window.add(apagarButton);
		window.setJMenuBar(barMenu);
					
		/* Defini alguns padrões no menu do controle */
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
				String message = "• Se você deseja acender o Led clique no botão Acenda;\n" +
						 		 "• Se você deseja apagar o Led clique no botão Apague.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
