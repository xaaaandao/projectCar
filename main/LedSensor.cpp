#include "LedSensor.hpp"

void LedSensor :: initializeLed(void){
  /* Inicializa o LED */
  pinMode(pinLed, OUTPUT);
}

void LedSensor :: onLed(void){
  /* Inicializa o LED */
  digitalWrite(pinLed, HIGH);
}

void LedSensor :: offLed(void){
  /* Inicializa o LED */
  digitalWrite(pinLed, LOW);
}

int LedSensor :: readSensor(void){
  /* Faz a leitura do sensor */
  return analogRead(pinSensor);
}
