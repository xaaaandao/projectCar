#ifndef WHEELS_H
#define WHEELS_H

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: protótipo dos métodos implementados no arquivo Wheels.cpp, a inclusão de algumas bibliotecas e alguns
* define de valores.
* Data de criação: 04/04/2018
* Data de atualização: 05/04/2018
**/

/* Biblioteca para usar os delays */
#include <Arduino.h>

/* Biblioteca relacionada ao shield do motor */
#include <AFMotor.h>

#define WHEEL_ONE 1
#define WHEEL_TWO 2
#define WHEEL_THREE 3
#define WHEEL_FOUR 4

#define SPEED_MAX 0xFF
#define SPEED_STOPPED 0x00

class Wheels{
	public:
    /* Protótipo dos métodos */
    void wheelsSetSpeedMax(void);
    void wheelsFront(void);
    void wheelsStop(void);
    void wheelsBack(void);
    void wheelsRotate(void);
};

#endif /* WHEELS_H */
