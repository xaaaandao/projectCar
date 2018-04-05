#ifndef LEDSENSOR_H
#define LEDSENSOR_H

/* Biblioteca para utilizar funções e define como: pinMode, OUTPUT */
#include <Arduino.h>

#define pinLed 30
#define pinSensor 7

int valueSensor = 0;

class LedSensor{
  public:
    /* Protótipo dos métodos */
    void initializeLed(void);
};

#endif /* LEDSENSOR_H */
