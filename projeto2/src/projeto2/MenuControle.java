package projeto2;

import java.awt.event.*;
import javax.swing.*;

public class MenuControle {

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
    int labelX = 90;
    int labelY = 10;

    /* Tamanho dos bot�es */
    int labelWidth = 150;
    int labelHeight = 30;

    public MenuControle(String port) {
        /* Criando o JDialog */
        JDialog dialog = new JDialog(new JFrame(), "Controle o super mega carrinho", true);

        /* Criando as variáveis da barra de menu */
        JMenuBar barMenu = new JMenuBar();
        JMenu helpMenu = new JMenu("Ajuda");
        JMenuItem duvidasMenuItem = new JMenuItem("Tire suas dúvidas");
        helpMenu.add(duvidasMenuItem);
        barMenu.add(helpMenu);

        /* Criando as variáveis da label e dos botões */
        JLabel labelMenuControle = new JLabel("Pilote seu carrinho: ");
        JButton frenteButton = new JButton("Frente");
        JButton reButton = new JButton("Ré");
        JButton esquerdaButton = new JButton("Esquerda");
        JButton direitaButton = new JButton("Direita");
        JButton pareButton = new JButton("Pare");

        /* Tornando vísivel a label e os botões */
        labelMenuControle.setVisible(true);
        frenteButton.setVisible(true);
        reButton.setVisible(true);
        esquerdaButton.setVisible(true);
        direitaButton.setVisible(true);
        pareButton.setVisible(true);

        /* Definindo as coordenadas da label e os botões */
        labelMenuControle.setBounds(labelX, labelY, labelWidth, labelHeight);
        frenteButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        reButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
        esquerdaButton.setBounds(buttonX, buttonY + (2 * distanceOfButton), buttonWidth, buttonHeight);
        direitaButton.setBounds(buttonX, buttonY + (3 * distanceOfButton), buttonWidth, buttonHeight);
        pareButton.setBounds(buttonX, buttonY + (4 * distanceOfButton), buttonWidth, buttonHeight);

        /* Adicionando botões no panel */
        dialog.add(labelMenuControle);
        dialog.add(frenteButton);
        dialog.add(reButton);
        dialog.add(esquerdaButton);
        dialog.add(direitaButton);
        dialog.add(pareButton);

        /* Chamando os listener dos botões */
        frenteButtonListener(frenteButton, port);
        reButtonListener(reButton, port);
        esquerdaButtonListener(esquerdaButton, port);
        direitaButtonListener(direitaButton, port);
        pareButtonListener(pareButton, port);
        helpMenuItemListener(duvidasMenuItem);

        /* Adicionando tamanho, posição, fechar e ficar visível */
        dialog.setJMenuBar(barMenu);
        dialog.setLayout(null);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(height, width);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }

    void frenteButtonListener(JButton frenteButton, String port) {
        frenteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    void reButtonListener(JButton trasButton, String port) {
        trasButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    void esquerdaButtonListener(JButton esquerdaButton, String port) {
        esquerdaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    void direitaButtonListener(JButton direitaButton, String port) {
        direitaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    void pareButtonListener(JButton pareButton, String port) {
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
                String message = "• Se você deseja que super mega carrinho vá para frente clique no botão Frente;\n"
                        + "• Se você deseja que super mega carrinho de ré clique no botão Ré;\n"
                        + "• Se você deseja que super mega carrinho vá para esquerda clique no botão Esquerda;\n"
                        + "• Se você deseja que super mega carrinho vá para direta clique no botão Direita;\n"
                        + "• Se você deseja que super mega carrinho pare clique no botão Pare.\n";
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
}
