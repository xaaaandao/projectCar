import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuMain {
	
	/* Tamanho da tela principal */
	int height = 300;
	int width = 350;
	
	/* Tamanho dos botões */
	int buttonWidth = 100;
	int buttonHeight = 50;
	
	/* Coordenadas dos botões */
	int buttonX = 95;
	int buttonY = 40;
	
	/* Entre um botão e outro adiciona */
	int distanceOfButton = 52;
	
	/* Coordenadas dos labels */
	int labelX = 75;
	int labelY = 10;
	
	/* Tamanho dos botões */
	int labelWidth = 150;
	int labelHeight = 30;
		
	public MenuMain() {
		JPanel panel = new JPanel();
		JFrame window = new JFrame("Project car v2");
		JButton controleButton = new JButton("Controle");
		JButton modoButton = new JButton("Modo");
		JButton ledButton = new JButton("Led");
		JButton contatoButton = new JButton("Contato");
		JButton sairButton = new JButton("Sair");
		JLabel labelMenu = new JLabel("Escolha uma das opções: ");
		
		/* Defini alguns padrões no componentes do menu principal */
		labelMenu.setBounds(labelX, labelY, labelWidth, labelHeight);
		controleButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		modoButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
		ledButton.setBounds(buttonX, buttonY + (2 * distanceOfButton), buttonWidth, buttonHeight);
		contatoButton.setBounds(buttonX, buttonY + (3 * distanceOfButton), buttonWidth, buttonHeight);
		sairButton.setBounds(buttonX, buttonY + (4 * distanceOfButton), buttonWidth, buttonHeight);
		
		/* Adiciona os itens no menu principal */
		window.add(labelMenu);
		window.add(controleButton);
		window.add(modoButton);
		window.add(ledButton);
		window.add(contatoButton);
		window.add(sairButton);
					
		/* Defini alguns padrões no menu principal */
		window.add(panel, BorderLayout.CENTER);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(height, width);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		/* Chamo os listener */
		controleButtonListener(controleButton);
		modoButtonListener(modoButton);
		ledButtonListener(ledButton);
		contatoButtonListener(contatoButton);
		sairButtonListener(sairButton);
	}
	
	void controleButtonListener(JButton controleButton) {
		controleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuControle();
				//JFrame window = new JFrame("Controle seu carrinho");
			}
		});
	}
	
	void modoButtonListener(JButton modoButton) {
		modoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	void ledButtonListener(JButton ledButton) {
		ledButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	void contatoButtonListener(JButton contatoButton) {
		contatoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	void sairButtonListener(JButton sairButton) {
		sairButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
	}
	
}
