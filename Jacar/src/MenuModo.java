import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuModo {
	/* Tamanho da tela principal */
	int height = 200;
	int width = 180;
	
	/* Linhas e colunas do grid layout */
	int rows = 2;
	int columns = 1;
	
	public MenuModo() {
		/* Criando as variáveis do frame, panel, etc */
		JDialog dialog = new JDialog(new JFrame(), "Escolha o modo de condução", true);
		JPanel panel = new JPanel(new GridLayout(rows, columns));
		
		/* Criando as variáveis da barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas dúvidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
			
		/* Criando as variáveis do botão */
		JButton xandaoButton = new JButton("Modo Xandão");
		JButton dodoButton = new JButton("Modo Dodo");
		
		/* Adicionando botões no panel */
		panel.add(xandaoButton);
		panel.add(dodoButton);
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		
		/* Chamando os listener dos botões */
		xandaoButtonListener(xandaoButton);
		dodoButtonListener(dodoButton);
		helpMenuItemListener(duvidasMenuItem);

		/* Adicionando tamanho, posição, fechar e ficar visível */
		dialog.setJMenuBar(barMenu);
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
				String message = "• Se você deseja uma condução que priorize o desempenho clique no botão Modo Xandão;\n" +
						 		 "• Se você deseja uma condução que priorize o conforto e o consumo de energia clique no botão Modo Dodo.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
