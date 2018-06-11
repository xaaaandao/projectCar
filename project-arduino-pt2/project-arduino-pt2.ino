#include <WString.h>
#include "LedSensor.hpp"

LedSensor ledSensor;

void setup(){
  /* Inicializa o serial */
  Serial.begin(9600);

  /* Inicializa o LED */
  ledSensor.initializeLed();
}

void loop(){
  if(Serial.available()){
    String input = Serial.readString();
    /* Liga o led */
    if(input.compareTo("onLed") == 0)
      ledSensor.onLed();
    /* Desliga o led */
    else if(input.compareTo("offLed") == 0)
      ledSensor.offLed();
//      digitalWrite(pinled, LOW);
    /* Ativa o modo dodo*/
    else if(input.compareTo("dodoModo") == 0)
      Serial.print("1");
    /* Ativa o modo xandão */
    else if(input.compareTo("xandoModo") == 0)
      Serial.print("1");
    /* Faz o carro ir para frente */
    else if(input.compareTo("frenteCarro") == 0)
      Serial.print("1");
    /* Faz o carro ir para trás */
    else if(input.compareTo("reCarro") == 0)
      Serial.print("1");
    /* Faz o carro ir para esquerda */
    else if(input.compareTo("esquerdaCarro") == 0)
      Serial.print("1");
    /* Faz o carro ir para direita */
    else if(input.compareTo("direitaCarro") == 0)
      Serial.print("1");    
  }
}
