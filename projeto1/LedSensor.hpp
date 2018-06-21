#ifndef LEDSENSOR_H
#define LEDSENSOR_H

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: definição de alguns valores necessários para se utilizar o sensor de luminosidade e o de led,
* a inclusão de biblioteca, para poder utilizar o pinMode, etc. e os protótipos dos métodos.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

/* Biblioteca para utilizar funções e define como: pinMode, OUTPUT */
#include <Arduino.h>

/* O led está conectado na porta digital 32 do arduino */
#define pinLed 32 

/* O sensor de luminosidade está conectado na porta analógica 7 do arduino */
#define pinSensor 7 

class LedSensor{
  public:
    /* Protótipo dos métodos */
    void initializeLed(void);
    void onLed(void);
    void offLed(void);
    int readLedSensor(void);
};

#endif /* LEDSENSOR_H */
