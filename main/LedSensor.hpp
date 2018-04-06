#ifndef LEDSENSOR_H
#define LEDSENSOR_H

/* Biblioteca para utilizar funções e define como: pinMode, OUTPUT */
#include <Arduino.h>

#define pinLed 32
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
