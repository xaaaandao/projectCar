import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuControle {
	/* Tamanho da tela principal */
	int height = 200;
	int width = 360;
	
	/* Linhas e colunas do grid layout */
	int rows = 5;
	int columns = 1;
	
	public MenuControle() {
		/* Criando as vari�veis do frame, panel, etc */
		JDialog dialog = new JDialog(new JFrame(), "Pilote o seu carrinho", true);
		JPanel panel = new JPanel(new GridLayout(rows, columns));
		
		/* Criando as vari�veis da barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
			
		/* Criando as vari�veis do bot�o */
		JButton frenteButton = new JButton("Frente");
		JButton reButton = new JButton("R�");
		JButton esquerdaButton = new JButton("Esquerda");
		JButton direitaButton = new JButton("Direita");
		JButton pareButton = new JButton("Pare");
		
		/* Adicionando bot�es no panel */
		panel.add(frenteButton);
		panel.add(reButton);
		panel.add(esquerdaButton);
		panel.add(direitaButton);
		panel.add(pareButton);
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		
		/* Chamando os listener dos bot�es */
		frenteButtonListener(frenteButton);
		reButtonListener(reButton);
		esquerdaButtonListener(esquerdaButton);
		direitaButtonListener(direitaButton);
		pareButtonListener(pareButton);
		helpMenuItemListener(duvidasMenuItem);

		/* Adicionando tamanho, posi��o, fechar e ficar vis�vel */
		dialog.setJMenuBar(barMenu);
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
