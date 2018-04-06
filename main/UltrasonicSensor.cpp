#include "UltrasonicSensor.hpp"

/**
* O método initializeSensor(void), faz com que inicialize o sensor ultrasônico.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void UltrasonicSensor :: initializeUltrasonic(void){
  pinMode(pinTrigger,OUTPUT);
  pinMode(pinEcho,INPUT);
}

/**
* O método readSensor(void), faz com que retorne a distância de algo que se aproxima
* do sensor ultrasônico.
* @param void, nenhum parâmetro.
* @return (duracao / 2) / 29.1, que é um long com o valor da distância de algo que se aproxima.
*/
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

