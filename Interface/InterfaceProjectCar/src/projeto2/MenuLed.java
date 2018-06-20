package projeto2;

import java.awt.event.*;
import javax.swing.*;

/**
 * Autor: Alexandre Yuji Kajihara
 * Descrição: classe de interface gráfica com os botões acender e apagar o led.
 * Data de criação: 20/06/2018
 * Data de atualização: 20/06/2018
 */
public class MenuLed {

    /* Atributos */
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

    /**
     * O construtor MenuLed(AcessaArduino acessaArduino), é a classe que cria a interface 
     * gráfica com os botões, as labels e a barra de menu.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return é um construtor.
     */
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

    /**
     * O método acenderButtonListener(JButton acenderButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado faz o led acender.
     * @param acenderButton, é o botão que faz o led acender.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void acenderButtonListener(JButton acenderButton, AcessaArduino acessaArduino) {
        acenderButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "onLed");
            }
        });
    }

    /**
     * O método apagarButtonListener(JButton apagarButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado faz o led apagar.
     * @param apagarButton, é o botão que faz o led apagar.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void apagarButtonListener(JButton apagarButton, AcessaArduino acessaArduino) {
        apagarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "offLed");
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
                String message = "• Se você deseja acender o Led clique no botão Acenda;\n"
                        + "• Se você deseja apagar o Led clique no botão Apague.\n";
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
}
