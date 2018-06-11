/* Para comparar a serial */
#include <WString.h>

/* Bibliotecas nossas */
#include "LedSensor.hpp"
#include "Wheels.hpp"

/* Variáveis globais */
LedSensor ledSensor;
Wheels wheels;

void setup(){
  /* Inicializa o serial */
  Serial.begin(9600);

  /* Inicializa o LED */
  ledSensor.initializeLed();

  /* Iniciliza o carrinho no modo Dodo */ 
  wheels.dodoMode();
}

void loop(){
  if(Serial.available()){
    String input = Serial.readString();
    /* Liga o led */
    if(input.compareTo("onLed") == 0){
      Serial.println("serial");
      ledSensor.onLed();
    /* Desliga o led */
    } else if(input.compareTo("offLed") == 0)
      ledSensor.offLed();
    /* Ativa o modo dodo*/
    else if(input.compareTo("dodoModo") == 0)
      wheels.dodoMode();
    /* Ativa o modo xandão */
    else if(input.compareTo("xandaoModo") == 0)
      wheels.xandaoMode();
    /* Faz o carro ir para frente */
    else if(input.compareTo("frenteCarro") == 0)
      wheels.wheelsFront();
    /* Faz o carro ir para trás */
    else if(input.compareTo("reCarro") == 0)
      wheels.wheelsBack();
    /* Faz o carro ir para esquerda */
    else if(input.compareTo("esquerdaCarro") == 0)
      //Serial.print("1");/* Dodo verificar qual sentindo está indo */
      wheels.wheelsRight();
    /* Faz o carro ir para direita */
    else if(input.compareTo("direitaCarro") == 0)
      Serial.print("1");/* Dodo verificar qual sentindo está indo */
    else if(input.compareTo("pareCarro") == 0)
      wheels.wheelsStop();    
  }
}
