package projeto2;

import java.awt.event.*;
import javax.swing.*;

/**
 * Autor: Alexandre Yuji Kajihara
 * Descrição: classe de interface gráfica com os botões frente, esquerda, trás,
 * ré e pare o carro.
 * Data de criação: 20/06/2018
 * Data de atualização: 20/06/2018
 */
public class MenuControle {

    /* Atributos */
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

    /**
     * O construtor MenuControle(AcessaArduino acessaArduino), é a classe que cria a interface 
     * gráfica com os botões, as labels e a barra de menu.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return é um construtor.
     */
    public MenuControle(AcessaArduino acessaArduino) {
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
        frenteButtonListener(frenteButton, acessaArduino);
        reButtonListener(reButton, acessaArduino);
        esquerdaButtonListener(esquerdaButton, acessaArduino);
        direitaButtonListener(direitaButton, acessaArduino);
        pareButtonListener(pareButton, acessaArduino);
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

    /**
     * O método frenteButtonListener(JButton frenteButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado faz o carrinho ir para frente.
     * @param frenteButton, é o botão que faz o carrinho ir para frente.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void frenteButtonListener(JButton frenteButton, AcessaArduino acessaArduino) {
        frenteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "frenteCarro");                
            }
        });
    }

    /**
     * O método reButtonListener(JButton trasButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado faz o carrinho ir para trás.
     * @param trasButton, é o botão que faz o carrinho ir para trás.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void reButtonListener(JButton trasButton, AcessaArduino acessaArduino) {
        trasButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "reCarro");
            }
        });
    }
    
    /**
     * O método esquerdaButtonListener(JButton esquerdaButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado faz o carrinho ir para esquerda.
     * @param esquerdaButton, é o botão que faz o carrinho ir para esquerda.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void esquerdaButtonListener(JButton esquerdaButton, AcessaArduino acessaArduino) {
        esquerdaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "esquerdaCarro");
            }
        });
    }

    /**
     * O método direitaButtonListener(JButton direitaButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado faz o carrinho ir para direita.
     * @param direitaButton, é o botão que faz o carrinho ir para direita.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void direitaButtonListener(JButton direitaButton, AcessaArduino acessaArduino) {
        direitaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "direitaCarro");
            }
        });
    }

    /**
     * O método pareButtonListener(JButton pareButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado faz o carrinho parar.
     * @param pareButton, é o botão que faz o carrinho parar.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void pareButtonListener(JButton pareButton, AcessaArduino acessaArduino) {
        pareButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "pareCarro");
            }
        });
    }

    /**
     * O método helpMenuItemListener(JMenuItem helpMenuItem), é o listener do botão
     * quando clicado acontece a abertura de outra interface gráfica da barra da menu.
     * @param helpMenuItem, é o botão presente nessa interface gráfica da barra de menu.
     * @return void, ou seja, nada.
     */
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
