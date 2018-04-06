#include "UltrasonicSensor.hpp"

void UltrasonicSensor :: initializeUltrasonic(void){
  pinMode(pinTrigger,OUTPUT);
  pinMode(pinEcho,INPUT);
}

long UltrasonicSensor :: readUltrasonicSensor(void){
  long duracao;
  digitalWrite(pinTrigger, LOW);
  delayMicroseconds(2);
  digitalWrite(pinTrigger,HIGH);
  delayMicroseconds(10);
  digitalWrite(pinTrigger,LOW);
  duracao = pulseIn(pinEcho,HIGH);
  return (duracao / 2) / 29.1;
}

