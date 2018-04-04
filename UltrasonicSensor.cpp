#include "UltrasonicSensor.hpp"

void UltrasonicSensor :: initializeSensor(void){
  /* Inicializa o sensor */
  pinMode(pinTrigger, OUTPUT);
  pinMode(pinEcho, INPUT);
}

void UltrasonicSensor :: readSensor(void){
  long duracao, distancia;
  digitalWrite(pinTrigger, LOW);
  delayMicroseconds(2);
  digitalWrite(pinTrigger, HIGH);
  delayMicroseconds(10);
  digitalWrite(pinTrigger, LOW);
  duracao = pulseIn(pinEcho, HIGH);
  distancia = (duracao / 2) / 29.1;
  
  //if(distancia >= 200 || distancia <= 0)
    /* Rodas vão para frente (OU TROCAR) */
  //  Serial.println("Fora de alcance");
//  else
    /* Rodas vão para trás (OU TROCAR) */
//    Serial.println(texto);
}

