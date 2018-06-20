/* Para comparar a serial */
#include <WString.h>

/* Bibliotecas nossas */
#include "LedSensor.hpp"
#include "UltrasonicSensor.hpp"
#include "Wheels.hpp"
#include "Mode.hpp"

/* Variáveis globais */
LedSensor ledSensor;
UltrasonicSensor ultrasonicSensor;
Wheels wheels;
Mode mode;
bool isAutonomo;

void setup() {
  /* Inicializa o serial */
  Serial.begin(9600);

  /* Inicializa o LED */
  ledSensor.initializeLed();

  /* Iniciliza o carrinho no modo Dodo */
  wheels.dodoMode();

  /* Inicializa o sensor ultrasônico */
  ultrasonicSensor.initializeUltrasonic();

  /* Como modo padrão é definido como modo autônomo */
  isAutonomo = true;
}

void loop() {
  Serial.println(String(ultrasonicSensor.readUltrasonicSensor()) + " " + ledSensor.readLedSensor());
  /* Se a serial está disponível */
  if (Serial.available()) {
    String input = Serial.readString();
    Serial.println(String(ultrasonicSensor.readUltrasonicSensor()) + " " + ledSensor.readLedSensor());
    /* Liga o led */
    if (input.compareTo("onLed") == 0)
      ledSensor.onLed();
    /* Desliga o led */
    else if (input.compareTo("offLed") == 0)
      ledSensor.offLed();
    /* Ativa o modo dodo*/
    else if (input.compareTo("dodoModo") == 0)
      wheels.dodoMode();
    /* Ativa o modo xandão */
    else if (input.compareTo("xandaoModo") == 0)
      wheels.xandaoMode();
    /* Faz o carro ir para frente */
    else if (input.compareTo("frenteCarro") == 0)
      wheels.wheelsFront();
    /* Faz o carro ir para trás */
    else if (input.compareTo("reCarro") == 0)
      wheels.wheelsBack();
    /* Faz o carro ir para esquerda */
    else if (input.compareTo("esquerdaCarro") == 0)
      wheels.wheelsRight();
    /* Faz o carro ir para direita */
    else if (input.compareTo("direitaCarro") == 0)
      wheels.wheelsLeft();
    /* Faz o carro parar */
    else if (input.compareTo("pareCarro") == 0)
      wheels.wheelsStop();
    /* Ativa modo autônomo */
    else if (input.compareTo("autonomo") == 0){
      /* Se tá ativo o modo autônomo */
      if (isAutonomo){
      	/* Desativa o modo autônomo e para o carro */
        isAutonomo = false;
        wheels.wheelsStop();
      } else {
        /* Ativa o modo autônomo e o carro anda */
        isAutonomo = true;
        mode.isAutoPilot(ledSensor, ultrasonicSensor, wheels);
      }
    }
  }
  /* Se o modo autônomo tá ativado o carro anda */
  if (isAutonomo) {
    mode.isAutoPilot(ledSensor, ultrasonicSensor, wheels);
  }
}
