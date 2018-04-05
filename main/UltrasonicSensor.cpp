#include "UltrasonicSensor.hpp"

void UltrasonicSensor :: initializeSensor(void){
  /* Inicializa o sensor */
  pinMode(pinTrigger, OUTPUT);
  pinMode(pinEcho, INPUT);
}

long UltrasonicSensor :: readSensor(void){
  /* */
  digitalWrite(pinTrigger, LOW);
  delayMicroseconds(2);

  /* */
  digitalWrite(pinTrigger, HIGH);
  delayMicroseconds(10);

  /* */
  digitalWrite(pinTrigger, LOW);
  long duracao = pulseIn(pinEcho, HIGH);
  return (duracao / 2) / 29.1;
}

