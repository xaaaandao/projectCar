#include "Wheels.hpp"

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: implementações dos métodos que foram definidos como protótipos no arquivo Wheels.hpp.
* Esses métodos estão relacionados as operações que são realizadas pelas motores do shield.
* Data de criação: 04/04/2018
* Data de atualização: 05/04/2018
**/

using namespace std;

/* Variáveis relacionadas aos motores */
AF_DCMotor motor1(WHEEL_ONE); 
AF_DCMotor motor2(WHEEL_TWO);
AF_DCMotor motor3(WHEEL_THREE);
AF_DCMotor motor4(WHEEL_FOUR);

/**
* O método wheelsSetSpeedMax(void), coloca a velocidade máxima nos motores.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsSetSpeedMax(void){
  /* Seleciona a velocidade para a velocidade máxima */
  motor1.setSpeed(SPEED_MAX);
  motor2.setSpeed(SPEED_MAX);
  motor3.setSpeed(SPEED_MAX);
  motor4.setSpeed(SPEED_MAX);
}

/**
* O método wheelsFront(void), faz os motores se movimentarem no sentido horário,
* consequentemente fazem as mesmas se movimentarem para frente.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsFront(void){
  Wheels: wheelsSetSpeedMax();

  /* Movimenta o motor no sentido horário */
  motor1.run(GO);
  motor2.run(GO);
  motor3.run(GO);
  motor4.run(GO);
}

/**
* O método wheelsStop(void), faz com que os motores parem e consequentemente
* fazendo com que o motor pare.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsStop(void){
  Wheels: wheelsSetSpeedMax();

  /* Motor no estado de parado */
  motor1.run(STOP);
  motor2.run(STOP);
  motor3.run(STOP);
  motor4.run(STOP);
}

/**
* O método wheelsBack(void), faz os motores se movimentarem no sentido anti-horário,
* consequentemente fazem as mesmas se movimentarem para trás.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsBack(void){
  Wheels: wheelsSetSpeedMax();

  /* Movimenta o motor no sentido anti-horário */
  motor1.run(GO_BACK);
  motor2.run(GO_BACK);
  motor3.run(GO_BACK);
  motor4.run(GO_BACK);
}

/**
* O método wheelsBack(void), faz com que os motores de apenas um dos lados se movimentem
* para que o mesmo consiga rotacionar.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsRotate(void){
  Wheels: wheelsSetSpeedMax();

  /* Movimenta o motor para rotacionar */
  motor1.run(GO); 
  motor2.run(GO_BACK);
  motor3.run(GO);
  motor4.run(GO_BACK);
}
