#include "Mode.hpp"

/**
* Autor: Alexandre Yuji Kajihara
* Descrição: implementação do método que deixa o carro no modo autônomo.
* Data de criação: 18/06/2018
* Data de atualização: 18/06/2018
**/

/**
* O método isAutoPilot(LedSensor ledSensor, UltrasonicSensor ultrasonicSensor, Wheels wheels), basicamente irá funcionar sozinho
* irá para frente, e quando encontrar obstáculos irá dar ré e girar o carrinho. Além disso, quando a sensor de luminosidade está abaixo
* do 250, ele irá acender o led.
* @param ledSensor, variável da classe LedSensor que lê o sensor de luminosidade e acender o led.
* @param ultrasonicSensor, variável da classe UltrasonicSensor que lê o sensor de ultrasônico.
* @param wheels, variável da classe Wheels que rotaciona as rodas do carro.
* @return void, não retorna nada.
*/
void Mode :: isAutoPilot(LedSensor ledSensor, UltrasonicSensor ultrasonicSensor, Wheels wheels){
  /* Faz a leitura do sensor de distância */
  long distancia = ultrasonicSensor.readUltrasonicSensor();
  
  /* Faz a leitura do sensor de luminosidade */
  if(ledSensor.readLedSensor() < 250)
    ledSensor.onLed();
  else
    ledSensor.offLed();

  /* Caso a distância lida for menor de 10 cm */
  if(distancia < 10){
    /* Os motores param */
    wheels.wheelsStop();

    /* Os motores começam a se movimentar no sentido anti-horário */
    wheels.wheelsBack();

    /* Os motores param */
    wheels.wheelsStop();

    /* Dois motores movimentam no sentido horário e os demais no sentido anti-horário */
    wheels.wheelsLeft();
    
  /* Caso a distância lida for maior que 10 cm */
  } else if(distancia > 10){
    /* Os motores começam a se movimentar no sentido horário */
    wheels.wheelsFront();
  }
}

