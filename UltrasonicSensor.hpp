#ifndef ULTRASONICSENSOR_H
#define ULTRASONICSENSOR_H

/* Biblioteca para utilizar funções e define como: pinMode, OUTPUT */
#include <Arduino.h>

#define pinTrigger 44
#define pinEcho 42

class UltrasonicSensor{
  public:
    /* Protótipo dos métodos */
    void initializeSensor(void);
    void readSensor(void);
};

#endif /* ULTRASONICSENSOR_H */
