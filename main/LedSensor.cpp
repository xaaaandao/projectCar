#include "LedSensor.hpp"

void LedSensor :: initializeLed(void){
  pinMode(pinLed, OUTPUT);
}

void LedSensor :: onLed(void){
  digitalWrite(pinLed, HIGH);
}

void LedSensor :: offLed(void){
  digitalWrite(pinLed, LOW);
}

int LedSensor :: readLedSensor(void){
  return analogRead(pinSensor);
}


