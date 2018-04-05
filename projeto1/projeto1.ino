/* Biblioteca relacionada ao motor shield */
#include <AFMotor.h>

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
//sensor de luz
int pinSensor = 7;
int valSensor = 0;
int ledDir = 30;
int ledEsq = 32;

// sensor de distancia
int pinTrigger = 44;
int pinEcho = 42;
void setup(){
  Serial.begin(9600);
  
  pinMode(ledEsq, OUTPUT);
  pinMode(pinTrigger,OUTPUT);
  pinMode(pinEcho,INPUT);
}
 
void loop(){
  //sensor de distancia
  long duracao, distancia;
  digitalWrite(pinTrigger, LOW);
  delayMicroseconds(2);
  digitalWrite(pinTrigger,HIGH);
  delayMicroseconds(10);
  digitalWrite(pinTrigger,LOW);
  duracao = pulseIn(pinEcho,HIGH);
  distancia=(duracao/2)/29.1;
  String texto = "Distancia: ";
  texto.concat(distancia);
  texto.concat("cm");
  if(distancia>=200 || distancia <=0){
    Serial.println("Fora de alcance");
  } else {
    Serial.println(texto);
  }

  // SENSOR DE LUZ
   valSensor = analogRead(pinSensor);
    if(valSensor < 30){
      
      digitalWrite(ledEsq, HIGH);
    } else {
      
      digitalWrite(ledEsq,LOW);
    }
   Serial.println(valSensor);

  if(distancia <10){
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

     //virando o carro
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
  } else if(distancia>10){
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
 /*
      
      // -- Controle Gradativo de Aceleração --
      for(velocidade1 = 0x00; velocidade1<255; velocidade1++)
      {
         motor1.setSpeed(velocidade1); //Atualiza velocidade
         motor1.run(FORWARD);          //Motor gira em sentido horário
         delay(10);                    //Taxa de atualização de 10 ms
      
      } //end for
      
      velocidade1 = 0x00;           //Velocidade recebe o valor mínimo
      motor1.setSpeed(velocidade1); //Seleciona velocidade atual
      motor1.run(RELEASE);          //Motor parado
      delay(2000);                  //Mantém por 2 segundos
      */


} //end loop
