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
		/* Criando as variáveis do frame, panel, etc */
		JDialog dialog = new JDialog(new JFrame(), "Pilote o seu carrinho", true);
		JPanel panel = new JPanel(new GridLayout(rows, columns));
		
		/* Criando as variáveis da barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas dúvidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
			
		/* Criando as variáveis do botão */
		JButton frenteButton = new JButton("Frente");
		JButton reButton = new JButton("Ré");
		JButton esquerdaButton = new JButton("Esquerda");
		JButton direitaButton = new JButton("Direita");
		JButton pareButton = new JButton("Pare");
		
		/* Adicionando botões no panel */
		panel.add(frenteButton);
		panel.add(reButton);
		panel.add(esquerdaButton);
		panel.add(direitaButton);
		panel.add(pareButton);
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		
		/* Chamando os listener dos botões */
		frenteButtonListener(frenteButton);
		reButtonListener(reButton);
		esquerdaButtonListener(esquerdaButton);
		direitaButtonListener(direitaButton);
		pareButtonListener(pareButton);
		helpMenuItemListener(duvidasMenuItem);

		/* Adicionando tamanho, posição, fechar e ficar visível */
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
				String message = "• Se você deseja que super mega carrinho vá para frente clique no botão Frente;\n" +
								 "• Se você deseja que super mega carrinho vá de ré clique no botão Ré;\n" +
								 "• Se você deseja que super mega carrinho vá para esquerda clique no botão Esquerda;\n" +
								 "• Se você deseja que super mega carrinho vá para direta clique no botão Direita;\n" +
								 "• Se você deseja que super mega carrinho pare clique no botão Pare.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
