#ifndef WHEELS_H
#define WHEELS_H

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: definição de alguns valores necessários para se utilizar o shield com os motores,
* a inclusão de biblioteca, para poder utilizar o pinMode, etc. e os protótipos dos métodos.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

/* Biblioteca para usar os delays */
#include <Arduino.h>

/* Biblioteca relacionada ao shield do motor */
#include <AFMotor.h>

/* Definição dos motores */
#define WHEEL_ONE 1
#define WHEEL_TWO 2
#define WHEEL_THREE 3
#define WHEEL_FOUR 4

/* Definição da velocidade */
#define SPEED_MAX 0xFF /* 255 */
#define SPEED_NORMAL 0xC8 /* 200 */
#define SPEED_STOPPED 0x00 /* 000 */

class Wheels{
	public:
    /* Protótipo dos métodos */
    void wheelsFront(void);
    void wheelsStop(void);
    void wheelsBack(void);
    void wheelsRight(void);
    void wheelsLeft(void);
    void xandaoMode(void);
    void dodoMode(void);
    void speedStop(void);
};

#endif /* WHEELS_H */
