#include "Mode.hpp"

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: implementação dos métodos relacionados ao sensor ultrasônico.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

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

