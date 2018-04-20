import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuControle {
	/* Tamanho da tela de controle */
	int height = 300;
	int width = 360;
	
	/* Tamanho dos bot�es */
	int buttonWidth = 100;
	int buttonHeight = 50;
	
	/* Coordenadas dos bot�es */
	int buttonX = 95;
	int buttonY = 40;
	
	/* Entre um bot�o e outro adiciona */
	int distanceOfButton = 52;
	
	/* Coordenadas dos labels */
	int labelX = 90;
	int labelY = 10;
	
	/* Tamanho dos bot�es */
	int labelWidth = 150;
	int labelHeight = 30;
	
	public MenuControle() {
		/* Definindo a janela */
		JPanel panel = new JPanel();
		JFrame window = new JFrame("Controle seu carrinho");

		/* Definindo os bot�es e label */
		JButton frenteButton = new JButton("Frente");
		JButton trasButton = new JButton("Tr�s");
		JButton esquerdaButton = new JButton("Esquerda");
		JButton direitaButton = new JButton("Direita");
		JButton pareButton = new JButton("Pare");
		JLabel labelMenu = new JLabel("Pilote seu carrinho: ");

		/* Definindo a barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
		
		/* Defini alguns padr�es no componentes do menu controle */
		labelMenu.setBounds(labelX, labelY, labelWidth, labelHeight);
		frenteButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		trasButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
		esquerdaButton.setBounds(buttonX, buttonY + (2 * distanceOfButton), buttonWidth, buttonHeight);
		direitaButton.setBounds(buttonX, buttonY + (3 * distanceOfButton), buttonWidth, buttonHeight);
		pareButton.setBounds(buttonX, buttonY + (4 * distanceOfButton), buttonWidth, buttonHeight);
		
		/* Adiciona os itens no menu do controle */
		window.add(labelMenu);
		window.add(frenteButton);
		window.add(trasButton);
		window.add(esquerdaButton);
		window.add(direitaButton);
		window.add(pareButton);
		window.setJMenuBar(barMenu);
					
		/* Defini alguns padr�es no menu do controle */
		window.add(panel, BorderLayout.CENTER);
		window.setSize(height, width);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		/* Chamo os listener */
		frenteButtonListener(frenteButton);
		trasButtonListener(trasButton);
		esquerdaButtonListener(esquerdaButton);
		direitaButtonListener(direitaButton);
		pareButtonListener(pareButton);
		helpMenuItemListener(duvidasMenuItem);
	}
	
	
	void frenteButtonListener(JButton frenteButton) {
		frenteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void trasButtonListener(JButton trasButton) {
		trasButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void esquerdaButtonListener(JButton esquerdaButton) {
		esquerdaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void direitaButtonListener(JButton direitaButton) {
		direitaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
		
	void pareButtonListener(JButton pareButton) {
		pareButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void helpMenuItemListener(JMenuItem helpMenuItem) {
		helpMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "� Se voc� deseja que super mega carrinho v� para frente clique no bot�o Frente;\n" +
								 "� Se voc� deseja que super mega carrinho v� para tr�s clique no bot�o Tr�s;\n" +
								 "� Se voc� deseja que super mega carrinho v� para esquerda clique no bot�o Esquerda;\n" +
								 "� Se voc� deseja que super mega carrinho v� para direta clique no bot�o Direita;\n" +
								 "� Se voc� deseja que super mega carrinho pare clique no bot�o Pare.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
