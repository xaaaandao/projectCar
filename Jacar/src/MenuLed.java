import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuLed {
	/* Tamanho da tela principal */
	int height = 200;
	int width = 180;
	
	/* Linhas e colunas do grid layout */
	int rows = 2;
	int columns = 1;
	
	public MenuLed() {
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
		JButton acenderButton = new JButton("Acender");
		JButton apagarButton = new JButton("Apagar");
		
		/* Adicionando botões no panel */
		panel.add(acenderButton);
		panel.add(apagarButton);
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		
		/* Chamando os listener dos botões */
		acenderButtonListener(acenderButton);
		apagarButtonListener(apagarButton);
		helpMenuItemListener(duvidasMenuItem);

		/* Adicionando tamanho, posição, fechar e ficar visível */
		dialog.setJMenuBar(barMenu);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(height, width);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
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
