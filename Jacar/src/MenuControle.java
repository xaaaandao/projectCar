import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuControle {
	/* Tamanho da tela de controle */
	int height = 300;
	int width = 360;
	
	/* Tamanho dos botões */
	int buttonWidth = 100;
	int buttonHeight = 50;
	
	/* Coordenadas dos botões */
	int buttonX = 95;
	int buttonY = 40;
	
	/* Entre um botão e outro adiciona */
	int distanceOfButton = 52;
	
	/* Coordenadas dos labels */
	int labelX = 90;
	int labelY = 10;
	
	/* Tamanho dos botões */
	int labelWidth = 150;
	int labelHeight = 30;
	
	public MenuControle() {
		/* Definindo a janela */
		JPanel panel = new JPanel();
		JFrame window = new JFrame("Controle seu carrinho");

		/* Definindo os botões e label */
		JButton frenteButton = new JButton("Frente");
		JButton trasButton = new JButton("Trás");
		JButton esquerdaButton = new JButton("Esquerda");
		JButton direitaButton = new JButton("Direita");
		JButton pareButton = new JButton("Pare");
		JLabel labelMenu = new JLabel("Pilote seu carrinho: ");

		/* Definindo a barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas dúvidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
		
		/* Defini alguns padrões no componentes do menu controle */
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
					
		/* Defini alguns padrões no menu do controle */
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
				String message = "• Se você deseja que super mega carrinho vá para frente clique no botão Frente;\n" +
								 "• Se você deseja que super mega carrinho vá para trás clique no botão Trás;\n" +
								 "• Se você deseja que super mega carrinho vá para esquerda clique no botão Esquerda;\n" +
								 "• Se você deseja que super mega carrinho vá para direta clique no botão Direita;\n" +
								 "• Se você deseja que super mega carrinho pare clique no botão Pare.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
