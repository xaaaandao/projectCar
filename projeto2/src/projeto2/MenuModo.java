package projeto2;

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

    public MenuModo(AcessaArduino acessaArduino) {
        /* Criando o JDialog */
        JDialog dialog = new JDialog(new JFrame(), "Selecione o modo de condução", true);

        /* Criando as variáveis da barra de menu */
        JMenuBar barMenu = new JMenuBar();
        JMenu helpMenu = new JMenu("Ajuda");
        JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
        helpMenu.add(duvidasMenuItem);
        barMenu.add(helpMenu);

        /* Criando as variáveis da label e dos botões */
        JLabel labelMenuModo = new JLabel("Selecione o modo de condu��o: ");
        JButton xandaoButton = new JButton("Modo Xand�o");
        JButton dodoButton = new JButton("Modo Dodo");

        /* Tornando vísivel a label e os botões */
        labelMenuModo.setVisible(true);
        xandaoButton.setVisible(true);
        dodoButton.setVisible(true);

        /* Definindo as coordenadas da label e os botões */
        labelMenuModo.setBounds(labelX, labelY, labelWidth, labelHeight);
        xandaoButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        dodoButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);

        /* Adicionando botões no panel */
        dialog.add(labelMenuModo);
        dialog.add(xandaoButton);
        dialog.add(dodoButton);

        /* Chamando os listener dos botões */
        xandaoButtonListener(xandaoButton, acessaArduino);
        dodoButtonListener(dodoButton, acessaArduino);

        /* Adicionando tamanho, posição, fechar e ficar visível */
        dialog.setJMenuBar(barMenu);
        dialog.setLayout(null);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(height, width);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    void xandaoButtonListener(JButton xandaoButton, AcessaArduino acessaArduino) {
        xandaoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "xandaoModo");
            }
        });
    }

    void dodoButtonListener(JButton dodoButton, AcessaArduino acessaArduino) {
        dodoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "dodoModo");
            }
        });
    }

    void helpMenuItemListener(JMenuItem helpMenuItem) {
        helpMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "• Se você deseja uma condução que priorize o desempenho clique no botão Modo Xandão;\n"
                        + "• Se você deseja uma condução que priorize o conforto e o consumo de energia clique no botão Modo Dodo.\n";
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
}
