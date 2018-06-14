/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.text.*;
import java.util.*;

/**
 *
 * @author suporte
 */
public class ValuesOfSensor implements Runnable{

    AcessaArduino acessaArduino;

    public ValuesOfSensor(AcessaArduino acessaArduino) {
        this.acessaArduino = acessaArduino;
    }
    
    @Override
    public void run() {
        while(true){
            /* Recebe o dado vindo do arduino */
            String value = this.acessaArduino.getDadosArduino();
            String valuesSensor[] = value.split(" ");
            
            /* Dá um split para pegar o valor do sensor ultrasônico e sensor de luminosidade */
            int valueUltrasonic = Integer.parseInt(valuesSensor[0]);
            int valueLed = Integer.parseInt(valuesSensor[1]);            
            
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
