import java.awt.event.*;
import javax.swing.*;

public class MenuMain {
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
	int labelX = 75;
	int labelY = 10;
	
	/* Tamanho dos bot�es */
	int labelWidth = 150;
	int labelHeight = 30;

	public MenuMain() {
		/* Criando o JDialog */
		JDialog dialog = new JDialog(new JFrame(), "Project car v2", true);

		/* Criando as vari�veis da barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);

		/* Criando as vari�veis da label e dos bot�es */
		JLabel labelMenu = new JLabel("Escolha uma das op��es: ");
		JButton controleButton = new JButton("Controle");
		JButton modoButton = new JButton("Modo");
		JButton ledButton = new JButton("Led");
		JButton contatoButton = new JButton("Contato");
		JButton sairButton = new JButton("Sair");

		/* Tornando v�sivel a label e os bot�es */
		labelMenu.setVisible(true);
		controleButton.setVisible(true);
		modoButton.setVisible(true);
		ledButton.setVisible(true);
		contatoButton.setVisible(true);
		sairButton.setVisible(true);
		
		/* Definindo as coordenadas da label e os bot�es */
		labelMenu.setBounds(labelX, labelY, labelWidth, labelHeight);
		controleButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		modoButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
		ledButton.setBounds(buttonX, buttonY + (2 * distanceOfButton), buttonWidth, buttonHeight);
		contatoButton.setBounds(buttonX, buttonY + (3 * distanceOfButton), buttonWidth, buttonHeight);
		sairButton.setBounds(buttonX, buttonY + (4 * distanceOfButton), buttonWidth, buttonHeight);

		/* Adicionando bot�es no panel */
		dialog.add(labelMenu);
		dialog.add(controleButton);
		dialog.add(modoButton);
		dialog.add(ledButton);
		dialog.add(contatoButton);
		dialog.add(sairButton);
		
		/* Chamando os listener dos bot�es */
		controleButtonListener(controleButton);
		modoButtonListener(modoButton);
		ledButtonListener(ledButton);
		contatoButtonListener(contatoButton);
		sairButtonListener(sairButton);
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

	void controleButtonListener(JButton controleButton) {
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
				String message = "� Caso tenha d�vidas sobre o funcionamento mande um e-mail para: kikikiu@supermegacarrinho.com, com assunto: D�vidas Super Mega Carrinho;\n"
						+ "� Caso tenha algum erro para reportar mande um e-mail para: tchaubrigado@supermegacarrinho.com, com assunto: Reportar Super Mega Carrinho;\n"
						+ "� Se n�o ligue para o telefone: (66) 6666-6666.\n";
				JOptionPane.showMessageDialog(null, message);
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
				String message = "� Se voc� deseja pilotar o super mega carrinho clique no bot�o Controle;\n"
						+ "� Se voc� deseja selecionar o modo de condu��o clique no bot�o Modo;\n"
						+ "� Se voc� deseja acender os led do super mega carrinho clique no bot�o Led;\n"
						+ "� Se voc� deseja entrar em contato conosco clique no bot�o Contato;\n"
						+ "� Se voc� deseja sair clique no bot�o Sair.\n";
				JOptionPane.showMessageDialog(null, message);
			}

		});
	}

}
