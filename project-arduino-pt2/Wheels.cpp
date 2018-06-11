#include "Wheels.hpp"

/* Definição dos motores do chassi */
AF_DCMotor motor1(WHEEL_ONE); 
AF_DCMotor motor3(WHEEL_THREE);
AF_DCMotor motor2(WHEEL_TWO);
AF_DCMotor motor4(WHEEL_FOUR);

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: implementação dos métodos relacionados aos motores do chassi.
* Data de criação: 04/04/2018
* Data de atualização: 06/04/2018
**/

/**
* O método wheelsFront(void), faz os motores se movimentarem no sentido horário,
* consequentemente fazem as mesmas se movimentarem para frente.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsFront(void){
     /* Motores rotacionam no sentido horário */
     motor1.run(FORWARD); 
     motor2.run(FORWARD);
     motor3.run(FORWARD);
     motor4.run(FORWARD);
}

/**
* O método wheelsStop(void), faz com que os motores parem e consequentemente
* fazendo com que o chassi não saia do lugar.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsStop(void){
     /* Motores param de funcionar */
     motor1.run(RELEASE); 
     motor2.run(RELEASE);
     motor3.run(RELEASE);
     motor4.run(RELEASE);

     /* Dá uma atraso de um segundos */
     delay(1000); 
}

/**
* O método wheelsBack(void), faz os motores se movimentarem no sentido anti-horário,
* consequentemente fazem as mesmas se movimentarem para trás.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsBack(void){
     /* Motores rotacionam no sentido anti-horário */
     motor1.run(BACKWARD); 
     motor2.run(BACKWARD);
     motor3.run(BACKWARD);
     motor4.run(BACKWARD);

     /* Dá uma atraso de três segundos */
     delay(3000);
}

/**
* O método wheelsBack(void), faz com que metade dos motores rotacionem no sentido horário
* e as demais no sentido anti-horário, consequentemente o chassi irá rotacionar.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsRight(void){
    /* Metade dos motores rotacionam no sentido anti-horário e a outra rotaciona no sentido horário */
    motor1.run(FORWARD); 
    motor2.run(FORWARD);
    motor3.run(BACKWARD);
    motor4.run(BACKWARD);

    /* Dá uma atraso de quatro segundos */
    delay(4000);
}

void Wheels :: wheelsLeft(void){
    /* Metade dos motores rotacionam no sentido anti-horário e a outra rotaciona no sentido horário */
    motor1.run(BACKWARD); 
    motor2.run(BACKWARD);
    motor3.run(FORWARD);
    motor4.run(FORWARD);

    /* Dá uma atraso de quatro segundos */
    delay(4000);
}

void Wheels :: xandaoMode(void){
    /* Velocidade recebe o valor máximo */
    motor1.setSpeed(SPEED_MAX);
    motor2.setSpeed(SPEED_MAX);
    motor3.setSpeed(SPEED_MAX);
    motor4.setSpeed(SPEED_MAX);
}

void Wheels :: dodoMode(void){
    /* Velocidade recebe o valor máximo */
    motor1.setSpeed(SPEED_NORMAL);
    motor2.setSpeed(SPEED_NORMAL);
    motor3.setSpeed(SPEED_NORMAL);
    motor4.setSpeed(SPEED_NORMAL);
}

void Wheels :: speedStop(void){
    /* Velocidade recebe o valor máximo */
    motor1.setSpeed(SPEED_STOPPED);
    motor2.setSpeed(SPEED_STOPPED);
    motor3.setSpeed(SPEED_STOPPED);
    motor4.setSpeed(SPEED_STOPPED);
}
