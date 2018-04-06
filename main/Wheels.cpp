#include "Wheels.hpp"

/* Rodas da frente */
AF_DCMotor motor1(1); 
AF_DCMotor motor3(3);

unsigned char velocidade1 = 0x00;
unsigned char velocidade3 = 0x00;

/* Rodas de trás */

AF_DCMotor motor2(2);
AF_DCMotor motor4(4);
unsigned char velocidade2 = 0x00;
unsigned char velocidade4 = 0x00;

/**
* Autor: Clodoaldo Basaglia da Fonseca
* Descrição: implementações dos métodos que foram definidos como protótipos no arquivo Wheels.hpp.
* Esses métodos estão relacionados as operações que são realizadas pelas motores do shield.
* Data de criação: 04/04/2018
* Data de atualização: 05/04/2018
**/

/**
* O método wheelsSetSpeedMax(void), coloca a velocidade máxima nos motores.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsSetSpeedMax(void){
}

/**
* O método wheelsFront(void), faz os motores se movimentarem no sentido horário,
* consequentemente fazem as mesmas se movimentarem para frente.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsFront(void){
       velocidade1 = 0xFF;           //Velocidade recebe o valor maximo
     velocidade2 = 0xFF;            // quatro velocidades diferentes para poder rodar uma roda separada da outra quando for virar
     velocidade3 = 0xFF;
     velocidade4 = 0xFF;
     motor1.setSpeed(velocidade1);
     motor2.setSpeed(velocidade2);
     motor3.setSpeed(velocidade3);
     motor4.setSpeed(velocidade4);
     motor1.run(FORWARD); 
     motor2.run(FORWARD);
     motor3.run(FORWARD);
     motor4.run(FORWARD);
}

/**
* O método wheelsStop(void), faz com que os motores parem e consequentemente
* fazendo com que o motor pare.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsStop(void){
    velocidade1 = 0x00;           //Velocidade recebe o valor mínimo
     velocidade2 = 0x00;            // quatro velocidades diferentes para poder rodar uma roda separada da outra quando for virar
     velocidade3 = 0x00;
     velocidade4 = 0x00;
     motor1.setSpeed(velocidade1);
     motor2.setSpeed(velocidade2);
     motor3.setSpeed(velocidade3);
     motor4.setSpeed(velocidade4);
     motor1.run(RELEASE); 
     motor2.run(RELEASE);
     motor3.run(RELEASE);
     motor4.run(RELEASE);
     delay(1000); 
}

/**
* O método wheelsBack(void), faz os motores se movimentarem no sentido anti-horário,
* consequentemente fazem as mesmas se movimentarem para trás.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsBack(void){
  
     velocidade1 = 0xFF;           //Velocidade recebe o valor maximo
     velocidade2 = 0xFF;            // quatro velocidades diferentes para poder rodar uma roda separada da outra quando for virar
     velocidade3 = 0xFF;
     velocidade4 = 0xFF;
     motor1.setSpeed(velocidade1);
     motor2.setSpeed(velocidade2);
     motor3.setSpeed(velocidade3);
     motor4.setSpeed(velocidade4);
     motor1.run(BACKWARD); 
     motor2.run(BACKWARD);
     motor3.run(BACKWARD);
     motor4.run(BACKWARD);
     delay(3000);
}

/**
* O método wheelsBack(void), faz com que os motores de apenas um dos lados se movimentem
* para que o mesmo consiga rotacionar.
* @param void, nenhum parâmetro.
* @return void, não retorna nada.
*/
void Wheels :: wheelsRotate(void){
  velocidade1 = 0xFF;           //Velocidade recebe o valor mínimo
     velocidade2 = 0xFF;            // quatro velocidades diferentes para poder rodar uma roda separada da outra quando for virar
     velocidade3 = 0xFF;
     velocidade4 = 0xFF;
     motor1.setSpeed(velocidade1);
     motor2.setSpeed(velocidade2);
     motor3.setSpeed(velocidade3);
     motor4.setSpeed(velocidade4);
     motor1.run(FORWARD); 
     motor2.run(BACKWARD);
     motor3.run(FORWARD);
     motor4.run(BACKWARD);
     delay(4000);
}
