#ifndef WHEELS_H
#define WHEELS_H

/* Biblioteca para usar os delays */
#include <Arduino.h>

/* Biblioteca relacionada ao shield do motor */
#include <AFMotor.h>

/* Definindo as rodas */
#define WHEEL_ONE 1
#define WHEEL_TWO 2
#define WHEEL_THREE 3
#define WHEEL_FOUR 4

/* Definindo a velocidade máxima */
#define SPEED_MAX 0x00

/* Definindo estado da roda */
#define GO FORWARD
#define STOP RELEASE
#define GO_BACK BACKWARD

class Wheels{
	public:
    /* Protótipo dos métodos */
    void wheelsSetSpeedMax(void);
    void wheelsFront(void);
    void wheelsStop(void);
    void wheelsBack(void);
    void wheelsLeft(void);
    void wheelsLeftStop(void);
    void wheelsRight(void);
    void wheelsRightStop(void);
};

#endif /* WHEELS_H */
