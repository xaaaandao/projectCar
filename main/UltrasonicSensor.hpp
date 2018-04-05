#ifndef ULTRASONICSENSOR_H
#define ULTRASONICSENSOR_H

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: protótipo dos métodos implementados no arquivo UltrasonicSensor.cpp, a inclusão de algumas bibliotecas e alguns
* define de valores.
* Data de criação: 04/04/2018
* Data de atualização: 05/04/2018
**/

/* Biblioteca para utilizar funções e define como: pinMode, OUTPUT */
#include <Arduino.h>

#define pinTrigger 44
#define pinEcho 42

class UltrasonicSensor{
  public:
    /* Protótipo dos métodos */
    void initializeSensor(void);
    long readSensor(void);
};

#endif /* ULTRASONICSENSOR_H */
