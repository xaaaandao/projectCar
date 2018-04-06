#include "LedSensor.hpp"
#include "UltrasonicSensor.hpp"
#include "Wheels.hpp"

LedSensor ledSensor;
UltrasonicSensor ultrasonicSensor;
Wheels wheels;
  
void setup(){
  Serial.begin(9600);

  ledSensor.initializeLed();
  ultrasonicSensor.initializeUltrasonic();
 
}
 
void loop(){
  //sensor de distancia
  long distancia = ultrasonicSensor.readUltrasonicSensor();
  //Serial.println("dis"+distancia);
  
  // SENSOR DE LUZ
  if(ledSensor.readLedSensor() < 30)
    ledSensor.onLed();
  else
    ledSensor.offLed();
  
  
  if(distancia <10){
    wheels.wheelsStop();
    wheels.wheelsBack();
    wheels.wheelsStop();
    wheels.wheelsRotate();
     
  } else if(distancia > 10){
    wheels.wheelsFront();
  }
 
} //end loop
