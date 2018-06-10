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
	
	/* Minimo e m�ximo da barra de progresso */
	int minimo = 0;
	int maximo = 100;
	
	public InitializeArduino() throws InterruptedException {
		/* Criando o JDialog */
		JDialog dialog = new JDialog(new JFrame(), "Acenda e apague o Led", true);

		JLabel labelInitialize = new JLabel("Tentando conex�o com arduino");
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
		
		for(int i = minimo; i <= maximo; i++){
			if(i < 20){
				labelInitialize.setText("Conectando com arduino...");
                                AcessaArduino acessaArduino;
                        } else if(i < 30)
				labelInitialize.setText("Conectado!!!");
			else
				labelInitialize.setText("Definindo algumas configura��es...");
			progressBar.setValue(i);
			progressBar.setStringPainted(true);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
