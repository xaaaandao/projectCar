package projeto2;

import java.awt.event.*;
import javax.swing.*;

public class MenuModo {
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
	int labelX = 65;
	int labelY = 10;

	/* Tamanho dos bot�es */
	int labelWidth = 200;
	int labelHeight = 30;

	public MenuModo() {
		/* Criando o JDialog */
		JDialog dialog = new JDialog(new JFrame(), "Selecione o modo de condu��o", true);

		/* Criando as vari�veis da barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);

		/* Criando as vari�veis da label e dos bot�es */
		JLabel labelMenuModo = new JLabel("Selecione o modo de condu��o: ");
		JButton xandaoButton = new JButton("Modo Xand�o");
		JButton dodoButton = new JButton("Modo Dodo");

		/* Tornando v�sivel a label e os bot�es */
		labelMenuModo.setVisible(true);
		xandaoButton.setVisible(true);
		dodoButton.setVisible(true);
		
		/* Definindo as coordenadas da label e os bot�es */
		labelMenuModo.setBounds(labelX, labelY, labelWidth, labelHeight);
		xandaoButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		dodoButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);

		/* Adicionando bot�es no panel */
		dialog.add(labelMenuModo);
		dialog.add(xandaoButton);
		dialog.add(dodoButton);
		
		/* Chamando os listener dos bot�es */
		xandaoButtonListener(xandaoButton);
		dodoButtonListener(dodoButton);
		
		/* Adicionando tamanho, posi��o, fechar e ficar vis�vel */
		dialog.setJMenuBar(barMenu);
		dialog.setLayout(null);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(height, width);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	void xandaoButtonListener(JButton xandaoButton) {
		xandaoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	void dodoButtonListener(JButton dodoButton) {
		dodoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	void helpMenuItemListener(JMenuItem helpMenuItem) {
		helpMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "� Se voc� deseja uma condu��o que priorize o desempenho clique no bot�o Modo Xand�o;\n"
						+ "� Se voc� deseja uma condu��o que priorize o conforto e o consumo de energia clique no bot�o Modo Dodo.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
