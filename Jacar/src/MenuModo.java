import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuModo {
	/* Tamanho da tela principal */
	int height = 320;
	int width = 200;
	
	/* Tamanho dos botões */
	int buttonWidth = 120;
	int buttonHeight = 50;
	
	/* Coordenadas dos botões */
	int buttonX = 95;
	int buttonY = 40;
	
	/* Entre um botão e outro adiciona */
	int distanceOfButton = 52;
	
	/* Coordenadas dos labels */
	int labelX = 65;
	int labelY = 10;
	
	/* Tamanho dos botões */
	int labelWidth = 200;
	int labelHeight = 30;
	
	public MenuModo() {
		/* Definindo a janela */
		JPanel panel = new JPanel();
		JFrame window = new JFrame("Selecione o modo de condução: ");

		/* Definindo os botões e label */
		JButton dodoButton = new JButton("Modo Dodo");
		JButton xandaoButton = new JButton("Modo Xandão");
		JLabel labelMenu = new JLabel("Selecione o modo de condução: ");

		/* Definindo a barra de menu */
		JMenuBar barMenu = new JMenuBar();
		JMenu helpMenu = new JMenu("Ajuda");
		JMenuItem duvidasMenuItem = new JMenuItem("Tire suas dúvidas");
		helpMenu.add(duvidasMenuItem);
		barMenu.add(helpMenu);
		
		/* Defini alguns padrões no componentes do menu controle */
		labelMenu.setBounds(labelX, labelY, labelWidth, labelHeight);
		dodoButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		xandaoButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
		
		/* Adiciona os itens no menu do controle */
		window.add(labelMenu);
		window.add(dodoButton);
		window.add(xandaoButton);
		window.setJMenuBar(barMenu);
					
		/* Defini alguns padrões no menu do controle */
		window.add(panel, BorderLayout.CENTER);
		window.setSize(height, width);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		/* Chamo os listener */
		dodoButtonListener(dodoButton);
		xandaoButtonListener(xandaoButton);
		helpMenuItemListener(duvidasMenuItem);
	}
	
	void dodoButtonListener(JButton dodoButton) {
		dodoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void xandaoButtonListener(JButton xandaoButton) {
		xandaoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	void helpMenuItemListener(JMenuItem helpMenuItem) {
		helpMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "• Se você deseja uma condução que priorize o conforto e o consumo de energia clique no botão Modo Dodo;\n" +
						 		 "• Se você deseja uma condução que priorize o desempenho clique no botão Modo Xandão.\n";
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
