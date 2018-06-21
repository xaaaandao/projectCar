#ifndef MODE_H
#define MODE_H

/**
* Autor: Alexandre Yuji Kajihara
* Descrição: protótipos do método que deixa o carro no modo autônomo.
* Data de criação: 18/06/2018
* Data de atualização: 18/06/2018
**/

/* Biblioteca para utilizar alguns métodos */
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
