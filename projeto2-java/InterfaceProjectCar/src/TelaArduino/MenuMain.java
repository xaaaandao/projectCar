package TelaArduino;

import java.awt.event.*;
import javax.swing.*;

/**
 * Autor: Alexandre Yuji Kajihara
 * Descrição: classe de interface gráfica com os botões controle, led, modo, contato
 * e sair.
 * Data de criação: 20/06/2018
 * Data de atualização: 20/06/2018
 */
public class MenuMain {

    /* Atributos */
    /* Tamanho da tela de controle */
    int height = 300;
    int width = 360;

    /* Tamanho dos botões */
    int buttonWidth = 100;
    int buttonHeight = 50;

    /* Coordenadas dos botões */
    int buttonX = 95;
    int buttonY = 40;

    /* Entre um botão e outro adiciona */
    int distanceOfButton = 52;

    /* Coordenadas dos labels */
    int labelX = 75;
    int labelY = 10;

    /* Tamanho dos botões */
    int labelWidth = 150;
    int labelHeight = 30;

    /**
     * O construtor MenuMain(AcessaArduino acessaArduino), é a classe que cria a interface 
     * gráfica com os botões, as labels e a barra de menu.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return é um construtor.
     */
    public MenuMain(AcessaArduino acessaArduino) {
        
        /* Criando o JDialog */
        JDialog dialog = new JDialog(new JFrame(), "Project car v2", true);

        /* Criando as variáveis da barra de menu */
        JMenuBar barMenu = new JMenuBar();
        JMenu helpMenu = new JMenu("Ajuda");
        JMenuItem duvidasMenuItem = new JMenuItem("Tire suas dúvidas");
        helpMenu.add(duvidasMenuItem);
        barMenu.add(helpMenu);

        /* Criando as variáveis da label e dos botões */
        JLabel labelMenu = new JLabel("Escolha uma das opções: ");
        JButton controleButton = new JButton("Controle");
        JButton modoButton = new JButton("Modo");
        JButton ledButton = new JButton("Led");
        JButton contatoButton = new JButton("Contato");
        JButton sairButton = new JButton("Sair");

        /* Tornando vísivel a label e os botões */
        labelMenu.setVisible(true);
        controleButton.setVisible(true);
        modoButton.setVisible(true);
        ledButton.setVisible(true);
        contatoButton.setVisible(true);
        sairButton.setVisible(true);

        /* Definindo as coordenadas da label e os botões */
        labelMenu.setBounds(labelX, labelY, labelWidth, labelHeight);
        controleButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        modoButton.setBounds(buttonX, buttonY + distanceOfButton, buttonWidth, buttonHeight);
        ledButton.setBounds(buttonX, buttonY + (2 * distanceOfButton), buttonWidth, buttonHeight);
        contatoButton.setBounds(buttonX, buttonY + (3 * distanceOfButton), buttonWidth, buttonHeight);
        sairButton.setBounds(buttonX, buttonY + (4 * distanceOfButton), buttonWidth, buttonHeight);

        /* Adicionando botões no panel */
        dialog.add(labelMenu);
        dialog.add(controleButton);
        dialog.add(modoButton);
        dialog.add(ledButton);
        dialog.add(contatoButton);
        dialog.add(sairButton);

        /* Chamando os listener dos botões */
        controleButtonListener(controleButton, acessaArduino);
        modoButtonListener(modoButton, acessaArduino);
        ledButtonListener(ledButton, acessaArduino);
        contatoButtonListener(contatoButton);
        sairButtonListener(sairButton);
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
     * O método controleButtonListener(JButton controleButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado acontece a abertura de outra interface
     * gráfica.
     * @param controleButton, é o botão presente nessa interface gráfica.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void controleButtonListener(JButton controleButton, AcessaArduino acessaArduino) {
        controleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuControle(acessaArduino);
            }

        });
    }

    /**
     * O método modoButtonListener(JButton modoButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado acontece a abertura de outra interface
     * gráfica.
     * @param modoButton, é o botão presente nessa interface gráfica.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void modoButtonListener(JButton modoButton, AcessaArduino acessaArduino) {
        modoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuModo(acessaArduino);
            }

        });
    }

     /**
     * O método ledButtonListener(JButton ledButton, AcessaArduino acessaArduino), 
     * é o listener do botão quando clicado acontece a abertura de outra interface
     * gráfica.
     * @param ledButton, é o botão presente nessa interface gráfica.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return void, ou seja, nada.
     */
    void ledButtonListener(JButton ledButton, AcessaArduino acessaArduino) {
        ledButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLed(acessaArduino);
            }

        });
    }

    /**
     * O método contatoButtonListener(JButton contatoButton), é o listener do botão
     * quando clicado acontece a abertura de outra interface gráfica.
     * @param contatoButton, é o botão presente nessa interface gráfica.
     * @return void, ou seja, nada.
     */
    void contatoButtonListener(JButton contatoButton) {
        contatoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "• Caso tenha dúvidas sobre o funcionamento mande um e-mail para: kikikiu@supermegacarrinho.com, com assunto: Dúvidas Super Mega Carrinho;\n"
                        + "• Caso tenha algum erro para reportar mande um e-mail para: tchaubrigado@supermegacarrinho.com, com assunto: Reportar Super Mega Carrinho;\n"
                        + "• Se não ligue para o telefone: (66) 6666-6666.\n";
                JOptionPane.showMessageDialog(null, message);
            }

        });
    }

    /**
     * O método sairButtonListener(JButton sairButton), é o listener do botão
     * quando clicado acontece a abertura de outra interface gráfica.
     * @param sairButton, é o botão presente nessa interface gráfica.
     * @return void, ou seja, nada.
     */
    void sairButtonListener(JButton sairButton) {
        sairButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
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
                String message = "• Se você deseja pilotar o super mega carrinho clique no botão Controle;\n"
                        + "• Se você deseja selecionar o modo de condução clique no botão Modo;\n"
                        + "• Se você deseja acender os led do super mega carrinho clique no botão Led;\n"
                        + "• Se você deseja entrar em contato conosco clique no botão Contato;\n"
                        + "• Se você deseja sair clique no botão Sair.\n";
                JOptionPane.showMessageDialog(null, message);
            }

        });
    }

}
