#include "LedSensor.hpp"
#include "UltrasonicSensor.hpp"
#include "Wheels.hpp"

/**
* Autor: Alexandre Yuji Kajihara e Clodoaldo Basaglia da Fonseca
* Descrição: invocação dos métodos presentes nas bibliotecas, que fazem com que o carro se movimente, 
* mude de orientação caso tenha um algo muito perto dele e caso esteja escuro que acenda o led.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

/* Declaração de variáveis relacionadas ao sensores */
LedSensor ledSensor;
UltrasonicSensor ultrasonicSensor;
Wheels wheels;
  
void setup(){
  /* Inicializa o led */
  ledSensor.initializeLed();

  /* Inicializa o sensor ultrasônico */
  ultrasonicSensor.initializeUltrasonic();
}
 
void loop(){
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
    wheels.wheelsRotate();
    
  /* Caso a distância lida for maior que 10 cm */
  } else if(distancia > 10){
    /* Os motores começam a se movimentar no sentido horário */
    wheels.wheelsFront();
  }
 
} //end loop
