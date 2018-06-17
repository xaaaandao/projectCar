package projeto2;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MenuLed {

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
    int labelX = 70;
    int labelY = 10;

    /* Tamanho dos botões */
    int labelWidth = 200;
    int labelHeight = 30;

    public MenuLed(AcessaArduino acessaArduino) {
        /* Criando o JDialog */
        JDialog dialog = new JDialog(new JFrame(), "Acenda e apague o Led", true);

        /* Criando as variáveis da barra de menu */
        JMenuBar barMenu = new JMenuBar();
        JMenu helpMenu = new JMenu("Ajuda");
        JMenuItem duvidasMenuItem = new JMenuItem("Tire suas d�vidas");
        helpMenu.add(duvidasMenuItem);
        barMenu.add(helpMenu);

        /* Criando as variáveis da label e dos botões */
        JLabel labelMenuLed = new JLabel("Deixe o led acesso ou apagado: ");
        JButton acenderButton = new JButton("Acenda");
        JButton apagarButton = new JButton("Apague");

        /* Tornando vísivel a label e os botões */
        labelMenuLed.setVisible(true);
        acenderButton.setVisible(true);
        apagarButton.setVisible(true);

        /* Definindo as coordenadas da label e os botões */
        labelMenuLed.setBounds(labelX, labelY, labelWidth, labelHeight);
        acenderButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        apagarButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);

        /* Adicionando botões no panel */
        dialog.add(labelMenuLed);
        dialog.add(acenderButton);
        dialog.add(apagarButton);

        /* Chamando os listener dos botões */
        acenderButtonListener(acenderButton, acessaArduino);
        apagarButtonListener(apagarButton, acessaArduino);

        /* Adicionando tamanho, posição, fechar e ficar visível */
        dialog.setJMenuBar(barMenu);
        dialog.setLayout(null);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(height, width);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    void acenderButtonListener(JButton acenderButton, AcessaArduino acessaArduino) {
        acenderButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "onLed");
            }
        });
    }

    void apagarButtonListener(JButton apagarButton, AcessaArduino acessaArduino) {
        apagarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "offLed");
            }
        });
    }

    void helpMenuItemListener(JMenuItem helpMenuItem) {
        helpMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "• Se você deseja acender o Led clique no botão Acenda;\n"
                        + "• Se você deseja apagar o Led clique no botão Apague.\n";
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
}
