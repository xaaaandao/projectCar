package projeto2;

import java.awt.event.*;
import javax.swing.*;

/**
 * Autor: Alexandre Yuji Kajihara
 * Descrição: classe de interface gráfica com os botões que acionam os modos de condução.
 * Data de criação: 20/06/2018
 * Data de atualização: 20/06/2018
 */
public class MenuModo {

    /* Atributos */
    /* Tamanho da tela principal */
    int height = 320;
    int width = 260;

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

    /**
     * O construtor MenuModo(AcessaArduino acessaArduino), é a classe que cria a interface 
     * gráfica com os botões, as labels e a barra de menu.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return é um construtor.
     */
    public MenuModo(AcessaArduino acessaArduino) {
        /* Criando o JDialog */
        JDialog dialog = new JDialog(new JFrame(), "Selecione o modo de condução", true);

        /* Criando as variáveis da barra de menu */
        JMenuBar barMenu = new JMenuBar();
        JMenu helpMenu = new JMenu("Ajuda");
        JMenuItem duvidasMenuItem = new JMenuItem("Tire suas dúvidas");
        helpMenu.add(duvidasMenuItem);
        barMenu.add(helpMenu);

        /* Criando as variáveis da label e dos botões */
        JLabel labelMenuModo = new JLabel("Selecione o modo de condução: ");
        JButton xandaoButton = new JButton("Modo Xandão");
        JButton dodoButton = new JButton("Modo Dodo");
        JButton autonomoButton = new JButton("Modo Auto");

        /* Tornando vísivel a label e os botões */
        labelMenuModo.setVisible(true);
        xandaoButton.setVisible(true);
        dodoButton.setVisible(true);
        autonomoButton.setVisible(true);

        /* Definindo as coordenadas da label e os botões */
        labelMenuModo.setBounds(labelX, labelY, labelWidth, labelHeight);
        xandaoButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        dodoButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
        autonomoButton.setBounds(buttonX, buttonY + (2 * distanceOfButton), buttonWidth, buttonHeight);

        /* Adicionando botões no panel */
        dialog.add(labelMenuModo);
        dialog.add(xandaoButton);
        dialog.add(dodoButton);
        dialog.add(autonomoButton);

        /* Chamando os listener dos botões */
        xandaoButtonListener(xandaoButton, acessaArduino);
        dodoButtonListener(dodoButton, acessaArduino);
        autonomoButtonListener(autonomoButton, acessaArduino);

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
     * O método xandaoButtonListener(JButton xandaoButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado aciona o modo de condução xandão.
     * @param xandaoButton, é o botão que aciona o modo xandão de condução.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void xandaoButtonListener(JButton xandaoButton, AcessaArduino acessaArduino) {
        xandaoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "xandaoModo");
            }
        });
    }

    /**
     * O método dodoButtonListener(JButton dodoButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado aciona o modo de condução xandão.
     * @param dodoButton, é o botão que aciona o modo dodo de condução.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void dodoButtonListener(JButton dodoButton, AcessaArduino acessaArduino) {
        dodoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "dodoModo");
            }
        });
    }
    
    /**
     * O método autonomoButtonListener(JButton autonomoButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado aciona o modo de condução autônomo.
     * @param autonomoButton, é o botão que aciona o modo dodo de condução.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void autonomoButtonListener(JButton autonomoButton, AcessaArduino acessaArduino) {
        autonomoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acessaArduino.setDataToArduino(acessaArduino.getSerialPort(), "autonomo");
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
                String message = "• Se você deseja uma condução que priorize o desempenho clique no botão Modo Xandão;\n"
                        + "• Se você deseja uma condução que priorize o conforto e o consumo de energia clique no botão Modo Dodo.\n";
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
    
    
}
