package projeto2;

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
		/* Criando o JDialog */
		JDialog dialog = new JDialog(new JFrame(), "Controle o super mega carrinho", true);

		/* Criando as vari�veis da barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);

		/* Criando as vari�veis da label e dos bot�es */
		JLabel labelMenuControle = new JLabel("Pilote seu carrinho: ");
		JButton frenteButton = new JButton("Frente");
		JButton reButton = new JButton("R�");
		JButton esquerdaButton = new JButton("Esquerda");
		JButton direitaButton = new JButton("Direita");
		JButton pareButton = new JButton("pare");

		/* Tornando v�sivel a label e os bot�es */
		labelMenuControle.setVisible(true);
		frenteButton.setVisible(true);
		reButton.setVisible(true);
		esquerdaButton.setVisible(true);
		direitaButton.setVisible(true);
		pareButton.setVisible(true);
		
		/* Definindo as coordenadas da label e os bot�es */
		labelMenuControle.setBounds(labelX, labelY, labelWidth, labelHeight);
		frenteButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		reButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
		esquerdaButton.setBounds(buttonX, buttonY + (2 * distanceOfButton), buttonWidth, buttonHeight);
		direitaButton.setBounds(buttonX, buttonY + (3 * distanceOfButton), buttonWidth, buttonHeight);
		pareButton.setBounds(buttonX, buttonY + (4 * distanceOfButton), buttonWidth, buttonHeight);

		/* Adicionando bot�es no panel */
		dialog.add(labelMenuControle);
		dialog.add(frenteButton);
		dialog.add(reButton);
		dialog.add(esquerdaButton);
		dialog.add(direitaButton);
		dialog.add(pareButton);
		
		/* Chamando os listener dos bot�es */
		frenteButtonListener(frenteButton);
		reButtonListener(reButton);
		esquerdaButtonListener(esquerdaButton);
		direitaButtonListener(direitaButton);
		pareButtonListener(pareButton);
		helpMenuItemListener(duvidasMenuItem);

		/* Adicionando tamanho, posi��o, fechar e ficar vis�vel */
		dialog.setJMenuBar(barMenu);
		dialog.setLayout(null);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(height, width);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);

	}	
	
	void frenteButtonListener(JButton frenteButton) {
		frenteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void reButtonListener(JButton trasButton) {
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
								 "� Se voc� deseja que super mega carrinho v� de r� clique no bot�o R�;\n" +
								 "� Se voc� deseja que super mega carrinho v� para esquerda clique no bot�o Esquerda;\n" +
								 "� Se voc� deseja que super mega carrinho v� para direta clique no bot�o Direita;\n" +
								 "� Se voc� deseja que super mega carrinho pare clique no bot�o Pare.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
