package projeto2;

import javax.swing.*;

public class InitializeArduino {

    /* Tamanho da tela principal */
    int height = 320;
    int width = 140;

    /* Tamanho da barra de progresso */
    int progressBarWidth = 120;
    int progressBarHeight = 25;

    /* Coordenadas da barra de progresso */
    int progressBarX = 95;
    int progressBarY = 40;

    /* Coordenadas dos labels */
    int labelX = 65;
    int labelY = 10;

    /* Tamanho dos bot�es */
    int labelWidth = 200;
    int labelHeight = 30;

    /* Minimo e máximo da barra de progresso */
    int minimo = 0;
    int maximo = 100;

    public InitializeArduino() throws InterruptedException {
        AcessaArduino acessaArduino = new AcessaArduino();
        /* Criando o JDialog */
        JDialog dialog = new JDialog(new JFrame(), "Conexão com arduino", true);

        JLabel labelInitialize = new JLabel("Tentando conexão com arduino");
        JProgressBar progressBar = new JProgressBar(minimo, maximo);

        labelInitialize.setVisible(true);
        progressBar.setVisible(true);

        labelInitialize.setBounds(labelX, labelY, labelWidth, labelHeight);
        progressBar.setBounds(progressBarX, progressBarY, progressBarWidth, progressBarHeight);

        dialog.add(labelInitialize);
        dialog.add(progressBar);

        dialog.setLayout(null);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(height, width);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                dialog.setVisible(true);
            }
        });
        t.start();
        
        for (int i = minimo; i <= maximo; i++) {
            if (i < 35) {
                labelInitialize.setText("Procurando a porta do arduino...");
            } else if (i < 65) {
                labelInitialize.setText("Porta encontrada! porta é: " + acessaArduino.getPortaSelecionada());
            } else {
                labelInitialize.setText("Terminando contato com arduino...");
            }
            progressBar.setValue(i);
            progressBar.setStringPainted(true);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        dialog.dispose();
        MenuMain menuMain = new MenuMain(acessaArduino);
    }
}
