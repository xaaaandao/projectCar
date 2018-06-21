#include "LedSensor.hpp"

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: implementação dos métodos relacionados ao sensor de luminosidade e ao led.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

/**
* O método initializeLed(void), basicamente coloca o led que no pino digital 32 como OUTPUT.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void LedSensor :: initializeLed(void){
  pinMode(pinLed, OUTPUT);
}

/**
* O método onLed(void), faz com que o led no pino digital 32 ligue.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void LedSensor :: onLed(void){
  digitalWrite(pinLed, HIGH);
}

/**
* O método offLed(void), faz com que o led no pino digital 32 desligue.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void LedSensor :: offLed(void){
  digitalWrite(pinLed, LOW);
}

/**
* O método offLed(void), retorna o valor lido pelo sensor de luminosidade
* que está presente no pino analógico 7.
* @param void, nenhum parâmetro.
* @return analogRead(pinSensor), é um inteiro com o valor lido pelo sensor de luminosidade.
*/
int LedSensor :: readLedSensor(void){
  return analogRead(pinSensor);
}


