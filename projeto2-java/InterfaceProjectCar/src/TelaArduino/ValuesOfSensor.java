package TelaArduino;

import java.text.*;
import java.util.*;

/**
 * Autor: Alexandre Yuji Kajihara
 * Descrição: classe que é uma thread que fica recebendo os dados vindo do arduino.
 * Data de criação: 20/06/2018
 * Data de atualização: 20/06/2018
 */
public class ValuesOfSensor implements Runnable{

    /* Atributos */
    AcessaArduino acessaArduino;

    /**
     * O construtor ValuesOfSensor(AcessaArduino acessaArduino), é a classe que 
     * faz o parâmetro virar atributo.
     * @param acessaArduino, variável que tem a conexão com o arduino.
     * @return é um construtor.
     */
    public ValuesOfSensor(AcessaArduino acessaArduino) {
        this.acessaArduino = acessaArduino;
    }
    
    /**
     * O método run(), é uma thread que fica recebendo os dados vindo do arduino.
     * @param nenhum parâmetro.
     * @return void, ou seja, nada.
     */
    @Override
    public void run() {
        int valueUltrasonic, valueLed;
        while(true){
            /* Recebe o dado vindo do arduino */
            String value = this.acessaArduino.getDadosArduino();
            String valuesSensor[] = value.split(" ");
            
            /* Dá um split para pegar o valor do sensor ultrasônico e sensor de luminosidade */
            valueUltrasonic = Integer.parseInt(valuesSensor[0]);
            //System.out.println(valueUltrasonic);
            /*if(valueUltrasonic < 10){ 
                this.acessaArduino.setDataToArduino(this.acessaArduino.getSerialPort(), "pareCarro");
            }*/
            valueLed = Integer.parseInt(valuesSensor[1]);            
            
            /* Pega a hora para inserir no banco */
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            
            /* Pega o banco o minuto e o segundo */
            int minute = cal.get(Calendar.MINUTE);
            int seconds = cal.get(Calendar.SECOND);
            
            /* Se o valor do minuto for par e do segundo for zero */
            if(minute % 2 == 0 && seconds == 0){
                /* Insere no banco */
                System.out.println(sdf.format(cal.getTime()));
                System.out.println("ultrasonic"+valueUltrasonic);
                System.out.println("led"+valueLed);
            }
            
        }
    }
    
}
