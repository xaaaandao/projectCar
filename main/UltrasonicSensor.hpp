#ifndef ULTRASONICSENSOR_H
#define ULTRASONICSENSOR_H

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: definição de alguns valores necessários para se utilizar o sensor ultrasônico,
* a inclusão de biblioteca, para poder utilizar o pinMode, etc. e os protótipos dos métodos.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

/* Biblioteca para utilizar funções e define como: pinMode, OUTPUT */
#include <Arduino.h>

/* É o pino que envia o sinal */
#define pinTrigger 44

/* É o pino que recebe o sinal */
#define pinEcho 42


class UltrasonicSensor{
  public:
    /* Protótipo dos métodos */
    void initializeUltrasonic(void);
    long readUltrasonicSensor(void);
};

#endif /* ULTRASONICSENSOR_H */
