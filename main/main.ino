#include "LedSensor.hpp"
#include "UltrasonicSensor.hpp"
#include "Wheels.hpp"

LedSensor ledSensor;
UltrasonicSensor us;
Wheels w;

/*teste*/
void setup(){
  Serial.begin(9600);

  ledSensor.initializeLed();
  us.initializeUltrasonic();
}
 
void loop(){
  //sensor de distancia
  long distancia = us.readUltrasonicSensor();

  // SENSOR DE LUZ
   if(ledSensor.readLedSensor() < 30)
      ledSensor.onLed();
   else
      ledSensor.offLed();

  if(distancia <10){
     w.wheelsStop();
     w.wheelsBack();
     w.wheelsStop();
     w.wheelsRotate();
     
  } else if(distancia > 10){
    w.wheelsFront();
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
