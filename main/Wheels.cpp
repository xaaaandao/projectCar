#include "Wheels.hpp"

using namespace std;

AF_DCMotor motor1(WHEEL_ONE); 
AF_DCMotor motor3(WHEEL_THREE);
unsigned char velocidade1;
unsigned char velocidade3;

AF_DCMotor motor2(WHEEL_TWO);
AF_DCMotor motor4(WHEEL_FOUR);
unsigned char velocidade2;
unsigned char velocidade4;


/**
 * Caso interesse o código abaixo é controle gradativo de aceleração
  for(velocidade1 = 0x00; velocidade1 < 255; velocidade1++){
    motor1.setSpeed(velocidade1); //Atualiza velocidade
    motor1.run(FORWARD);          //Motor gira em sentido horário
    delay(10);                    //Taxa de atualização de 10 ms
  } 
*
*/

void Wheels :: wheelsSetSpeedMax(void){
  /* Velocidade recebe valor máximo */
  velocidade1 = SPEED_MAX;
  velocidade2 = SPEED_MAX;
  velocidade3 = SPEED_MAX;
  velocidade4 = SPEED_MAX;

  /* Seleciona a velocidade atual */
  motor1.setSpeed(velocidade1);
  motor2.setSpeed(velocidade2);
  motor3.setSpeed(velocidade3);
  motor4.setSpeed(velocidade4);
}

void Wheels :: wheelsFront(void){
  Wheels: wheelsSetSpeedMax();

  /* Movimenta o motor no sentido horário */
  motor1.run(GO);
  motor2.run(GO);
  motor3.run(GO);
  motor4.run(GO);
  
  delay(2000);
}

void Wheels :: wheelsStop(void){
  Wheels: wheelsSetSpeedMax();

  /* Motor no estado de parado */
  motor1.run(STOP);
  motor2.run(STOP);
  motor3.run(STOP);
  motor4.run(STOP);

  delay(2000);
}

void Wheels :: wheelsBack(void){
  Wheels: wheelsSetSpeedMax();

  /* Movimenta o motor no sentido anti-horário */
  motor1.run(GO_BACK);
  motor2.run(GO_BACK);
  motor3.run(GO_BACK);
  motor4.run(GO_BACK);
  
  delay(2000);
}

void Wheels :: wheelsLeft(void){
  /* Velocidade recebe valor máximo */
  /*velocidade1 = SPEED_MAX;
  velocidade2 = SPEED_MAX;
  velocidade3 = SPEED_MAX;
  velocidade4 = SPEED_MAX;

  /* Seleciona a velocidade atual */
  /*motor1.setSpeed(velocidade1);
  motor2.setSpeed(velocidade2);
  motor3.setSpeed(velocidade3);
  motor4.setSpeed(velocidade4);

  /* Movimenta o motor no sentido anti-horário */
  /*motor1.run(GO_BACK);
  motor2.run(GO_BACK);
  motor3.run(GO_BACK);
  motor4.run(GO_BACK);
  
  delay(2000);*/
}

void Wheels :: wheelsLeftStop(void){
  /* Velocidade recebe valor máximo */
  /*velocidade1 = SPEED_MAX;
  velocidade2 = SPEED_MAX;
  velocidade3 = SPEED_MAX;
  velocidade4 = SPEED_MAX;

  /* Seleciona a velocidade atual */
  /*motor1.setSpeed(velocidade1);
  motor2.setSpeed(velocidade2);
  motor3.setSpeed(velocidade3);
  motor4.setSpeed(velocidade4);

  /* Movimenta o motor no sentido anti-horário */
  /*motor1.run(GO_BACK);
  motor2.run(GO_BACK);
  motor3.run(GO_BACK);
  motor4.run(GO_BACK);
  
  delay(2000);*/
}

void Wheels :: wheelsRight(void){
  /* Velocidade recebe valor máximo */
  /*velocidade1 = SPEED_MAX;
  velocidade2 = SPEED_MAX;
  velocidade3 = SPEED_MAX;
  velocidade4 = SPEED_MAX;

  /* Seleciona a velocidade atual */
  /*motor1.setSpeed(velocidade1);
  motor2.setSpeed(velocidade2);
  motor3.setSpeed(velocidade3);
  motor4.setSpeed(velocidade4);

  /* Movimenta o motor no sentido anti-horário */
  /*motor1.run(GO_BACK);
  motor2.run(GO_BACK);
  motor3.run(GO_BACK);
  motor4.run(GO_BACK);
  
  delay(2000);*/
}

void Wheels :: wheelsRightStop(void){
  /* Velocidade recebe valor máximo */
  /*velocidade1 = SPEED_MAX;
  velocidade2 = SPEED_MAX;
  velocidade3 = SPEED_MAX;
  velocidade4 = SPEED_MAX;

  /* Seleciona a velocidade atual */
  /*motor1.setSpeed(velocidade1);
  motor2.setSpeed(velocidade2);
  motor3.setSpeed(velocidade3);
  motor4.setSpeed(velocidade4);

  /* Movimenta o motor no sentido anti-horário */
  /*motor1.run(GO_BACK);
  motor2.run(GO_BACK);
  motor3.run(GO_BACK);
  motor4.run(GO_BACK);
  
  delay(2000);*/
}
