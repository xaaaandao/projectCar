/* Para manipulação do Wemos D1 R2 */
#include <ESP8266WiFi.h>

/* Para poder utilizar as funções relacionada as variáveis do tipo String, como a função indexOf */
#include <Arduino.h>

/* Definindo o nome do Wi-Fi e a senha do mesmo (detalhe, a senha deve ser de 8 a 32 characteres), caso contrário não será mudado o nome e a senha */
const char* ssid = "carroPancadao";
const char* password = "carroPancadao";

/* Definindo a porta do servidor que no caso é a porta 80 */
WiFiServer server(80);

void setup(){
  Serial.begin(115200);

  /* Inicializa o Wemos como Acess Point, com o nome e a senha que foi definida anteriormente nas variáveis ssid e password */
  WiFi.softAP(ssid, password);

  /* Pega o endereço do roteador */
  IPAddress myIP = WiFi.softAPIP();
  
  Serial.print("AP IP address: ");
  Serial.println(myIP);
  
  /* Inicializa o servidor */
  server.begin();
}

void loop(){
  /* Arquivo requerido */
  String feature = "";
  
  /* Cliente verifica se o servidor está disponível */
  WiFiClient client = server.available();
  
  /* Espera um cliente conectar */
  if (client){
    
    /* Enquanto o cliente estiver conectado */
    while (client.connected()){

      /* Fica lendo linha por linha a requisição do cliente */
      if (client.available()){
        
        /* Lendo a linha da requisição do cliente */
        String line = client.readStringUntil('\r');
        
        /* Tem que ser 0, porque na primeira linha que vem na requisição o GET começa na posição 0*/
        if(line.indexOf("GET") == 0)
          feature = line;
        
        /* Espera até o final da requisição do cliente, e é marcado fim de linha */
        if (line.length() == 1 && line[0] == '\n'){
          
          /* Envia para o cliente o cabeçalho e o corpo */
//          client.println(headerClient() + bodyClient());
          getFeature(feature);
          break;
          
        }
        
      }
      
    }

    /* Tempo para o navegador receber os dados */
    delay(1);

    /* Fecha a conexão */
    client.stop();
    Serial.println("[Client disonnected]");
  }
}

void getFeature(String line){
  line.replace("GET ", "");
  line.replace(" HTTP/1.1", "");
  Serial.println(line);  
}


/*
String headerClient(){
  return String("HTTP/1.1 200 OK\r\n") +
            "Content-Type: text/html\r\n" +
            "Connection: close\r\n" +  // the connection will be closed after completion of the response
            //"Refresh: 5\r\n" +  // refresh the page automatically every 5 sec
            "\r\n";
}

String bodyClient(){
  return String("<!DOCTYPE HTML>") +
            "<html>" +
              "<header>" +
                "<title>" +
                  "Project Car v2" +
                "</title>" +
              "</header>" +
              "<body>" +
              "</body>" +
            "</html>" +
            "\r\n";
}*/

