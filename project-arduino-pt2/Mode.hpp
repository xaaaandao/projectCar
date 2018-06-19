#ifndef MODE_H
#define MODE_H

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: definição de alguns valores necessários para se utilizar o sensor ultrasônico,
* a inclusão de biblioteca, para poder utilizar o pinMode, etc. e os protótipos dos métodos.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

/* Biblioteca para utilizar funções e define como: pinMode, OUTPUT */
#include <Arduino.h>

/* Bibliotecas nossas */
#include "LedSensor.hpp"
#include "UltrasonicSensor.hpp"
#include "Wheels.hpp"

class Mode{
  public:
    /* Protótipo dos métodos */
    void isAutoPilot(LedSensor, UltrasonicSensor, Wheels);
};

#endif /* MODE_H */
