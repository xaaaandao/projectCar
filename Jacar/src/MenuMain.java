import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuMain {
	
	/* Tamanho da tela principal */
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
	int labelX = 75;
	int labelY = 10;
	
	/* Tamanho dos bot�es */
	int labelWidth = 150;
	int labelHeight = 30;
		
	public MenuMain() {
		/* Definindo a janela */
		JPanel panel = new JPanel();
		JFrame window = new JFrame("Project car v2");
		
		/* Definindo os bot�es e label */
		JButton controleButton = new JButton("Controle");
		JButton modoButton = new JButton("Modo");
		JButton ledButton = new JButton("Led");
		JButton contatoButton = new JButton("Contato");
		JButton sairButton = new JButton("Sair");
		JLabel labelMenu = new JLabel("Escolha uma das op��es: ");
		
		/* Definindo a barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
				
		/* Defini alguns padr�es no componentes do menu principal */
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
		window.setJMenuBar(barMenu);
					
		/* Defini alguns padr�es no menu principal */
		window.add(panel, BorderLayout.CENTER);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(height, width);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		/* Chamo os listener */
		controleButtonListener(window, controleButton);
		modoButtonListener(modoButton);
		ledButtonListener(ledButton);
		contatoButtonListener(contatoButton);
		sairButtonListener(sairButton);
		helpMenuItemListener(duvidasMenuItem);
	}
	
	void controleButtonListener(JFrame window, JButton controleButton) {
		controleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuControle();
			}
		});
	}
	
	void modoButtonListener(JButton modoButton) {
		modoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuModo();
			}
		});
	}
	
	void ledButtonListener(JButton ledButton) {
		ledButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuLed();
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
	
	void helpMenuItemListener(JMenuItem helpMenuItem) {
		helpMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "� Se voc� deseja pilotar o super mega carrinho clique no bot�o Controle;\n" +
								 "� Se voc� deseja selecionar o modo de condu��o clique no bot�o Modo;\n" +
								 "� Se voc� deseja acender os led do super mega carrinho clique no bot�o Led;\n" +
								 "� Se voc� deseja entrar em contato conosco clique no bot�o Contato;\n" +
								 "� Se voc� deseja sair clique no bot�o Sair.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
	
}
