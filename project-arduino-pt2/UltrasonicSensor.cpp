#include "UltrasonicSensor.hpp"

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: implementação dos métodos relacionados ao sensor ultrasônico.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

/**
* O método initializeUltrasoniczeLed(void), basicamente coloca o trigger do sensor
* (que envia o sinal) no pino digital 44 como OUTPUT e o echo (que é o sinal de retorno)
* no pino digital 42 como INPUT.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void UltrasonicSensor :: initializeUltrasonic(void){
  /* Pino de enviar o sinal */
  pinMode(pinTrigger, OUTPUT);
  
  /* Pino de retorno de sinal */
  pinMode(pinEcho, INPUT);
}

/**
* O método readUltrasonicSensor(void), envia um sinal e recebe um o sinal de retorno
* e através de um cálculo retorna a distância do objeto em relação ao carro.
* @param void, nenhum parâmetro.
* @return (duracao / 2) / 29.1, que é um long com a distância do objeto em relação ao carro.
*/
long UltrasonicSensor :: readUltrasonicSensor(void){
  /* Pino de enviar o sinal fica no comprimento de onda baixo */
  digitalWrite(pinTrigger, LOW);
  delayMicroseconds(2);
  
  /* Pino de enviar o sinal fica no comprimento de onda alto */
  digitalWrite(pinTrigger, HIGH);
  delayMicroseconds(10);

  /* Pino de enviar o sinal fica no comprimento de onda alto */
  digitalWrite(pinTrigger, LOW);

  /* Pega a duração do valor do sinal de retorno */
  long duracao = pulseIn(pinEcho, HIGH);

  /* Retorna a distância */
  return (duracao / 2) / 29.1;
}

void UltrasonicSensor :: objectClose(void){
  long distancia = readUltrasonicSensor();
  Wheels wheels;
  if(distancia < 10)
    wheels.wheelsStop();  
}

