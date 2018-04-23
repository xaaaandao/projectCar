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
		/* Criando as vari�veis do frame, panel, etc */
		JDialog dialog = new JDialog(new JFrame(), "Escolha o modo de condu��o", true);
		JPanel panel = new JPanel(new GridLayout(rows, columns));
		
		/* Criando as vari�veis da barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
			
		/* Criando as vari�veis do bot�o */
		JButton xandaoButton = new JButton("Modo Xand�o");
		JButton dodoButton = new JButton("Modo Dodo");
		
		/* Adicionando bot�es no panel */
		panel.add(xandaoButton);
		panel.add(dodoButton);
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		
		/* Chamando os listener dos bot�es */
		xandaoButtonListener(xandaoButton);
		dodoButtonListener(dodoButton);
		helpMenuItemListener(duvidasMenuItem);

		/* Adicionando tamanho, posi��o, fechar e ficar vis�vel */
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
				String message = "� Se voc� deseja uma condu��o que priorize o desempenho clique no bot�o Modo Xand�o;\n" +
						 		 "� Se voc� deseja uma condu��o que priorize o conforto e o consumo de energia clique no bot�o Modo Dodo.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
