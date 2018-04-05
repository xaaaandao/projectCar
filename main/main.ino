#include "Wheels.hpp"
#include "LedSensor.hpp"
#include "UltrasonicSensor.hpp"

/* Cria as variáveis, para pode invocar os métodos presentes nessas classes */
LedSensor ledSensor;
UltrasonicSensor ultrasonicSensor;
Wheels wheels;

void setup(){
  /* Inicializa o sensor de luz */
  ledSensor.initializeLed();
  /* Inicializa o sensor ultrasônico */
  ultrasonicSensor.initializeSensor();
}
 
void loop(){
  /* Sensor de luz */
  if(ledSensor.readSensor() < 30)
    /* Acende o led */
    ledSensor.onLed();
  else
    /* Apaga o led */
    ledSensor.offLed();

  long distancia = ultrasonicSensor.readSensor();
  if(distancia < 10){
    /* Faz as rodas parar */
    wheels.wheelsStop();
    delay(1000);

    /* Faz as rodas andar para trás */
    wheels.wheelsBack();
    delay(3000);

    /* Faz as rodas parar */
    wheels.wheelsStop();
    delay(1000);

    /* Faz as rodas rotacionar */
    wheels.wheelsRotate();
    delay(4000);
    
  } else if(distancia > 10){
    /* Faz as rodas ir para frente */
    wheels.wheelsFront();
  }
}
