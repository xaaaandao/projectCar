/* Para manipulação do Wemos D1 R2 */
#include <ESP8266WiFi.h>

/* Para poder utilizar as funções relacionada as variáveis do tipo String, como a função indexOf */
#include <Arduino.h>

/* Definindo o nome do Wi-Fi e a senha do mesmo (detalhe, a senha deve ser de 8 a 32 characteres), caso contrário não será mudado o nome e a senha */
const char* ssid = "carroPancadao";
const char* password = "carropancada";

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
          client.println(getFeature(feature));
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

String getFeature(String line){
  /* Removo o GET e o HTTP/1.1 */
  line.replace("GET ", "");
  line.replace(" HTTP/1.1", "");
  
  if((line.indexOf("/home.html") == 0) || (line.charAt(0) == '/' && line.length() == 1))
    return headerResponse() + bodyResponseHome();
  else if(line.indexOf("/contato.html") == 0)
    return headerResponse() + bodyResponseContato();
  else if(line.indexOf("/controlar.html") == 0)
    return headerResponse() + bodyResponseControlar();
  else if(line.indexOf("/led.html") == 0)
    return headerResponse() + bodyResponseLed();
  else if(line.indexOf("/modo.html") == 0)
    return headerResponse() + bodyResponseModo();
  else
    return headerResponse() + bodyResponse404();
}

String headerResponse(){
  return String("HTTP/1.1 200 OK\r\n") +
            "Content-Type: text/html\r\n" +
            "Connection: close\r\n" +
            "\r\n\r\n";
}

String bodyResponseHome(){
  return String("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">") +
            "<html><head>" +
            "<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">" +
            "<title>Home - Project Car v2</title>" + 
            "<style></style></head><body>"+
            "<h1>Bem vindo ao projeto carro v2</h1>" +
            "<p>Desfrute do seu novo carro." +
            "<ul style=\"list-style-type:circle\">" +
            "<a href=\"home.html\"><li>Home</li></a>" +
            "<a href=\"controlar.html\"><li>Controlar</li></a>" +
            "<a href=\"led.html\"><li>LED</li></a>" +
            "<a href=\"modo.html\"><li>Modos de conducao</li></a>" +
            "<a href=\"contato.html\"><li>Contato</li></a>" +
            "</ul>" +
            "</p></body></html>" +
            "\r\n";
}

String bodyResponseContato(){
  return String("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">") +
          "<html><head>" +
          "<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">" +
          "<title>Contato - Project Car v2</title>" +
          "<style>" +
          "textarea{" +
              "resize: none;" +
          "}" +
          "</style></head><body>" +
          "<h1>Entre em contato consco</h1>" +
          "<form>" +
              "Nome completo:<br>" + 
              "<input type=\"text\" name=\"name_lastname\"><br>" +
              "E-mail:<br>" +
              "<input type=\"email\" name=\"email\"><br>" +
              "Mensagem:<br>" +
              "<textarea rows=\"4\" cols=\"50\"></textarea><br>" +
              "<button type=\"button\">Enviar!</button>" +
          "</form>" + 
          "<p>Mais opcoes: <a href=\"home.html\">Home</a> | <a href=\"controlar.html\">Controlar</a> | <a href=\"led.html\">LED</a> | <a href=\"modo.html\">Modos de conducao</a> | <a href=\"contato.html\">Contato</a></p>" +
          "</body></html>\r\n";
}

String bodyResponseControlar(){
    return String("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">") +
          "<html><head>" +
          "<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">" +
          "<title>Controlar - Project Car v2</title>" +
          "<style>" +
          "</style></head><body>" +
          "<h1>Diriga o seu carrinho</h1>" +
          "<p> Diriga o carrinho da maneira que mais lhe agradar</p>" +
          "<form>" +
              "<button type=\"button\">VA EM FRENTE!</button>" +
              "<button type=\"button\">PARE!</button>" +
              "<button type=\"button\">VA PRA TRAS!</button>" +
          "</form>" +
          "<p>Mais opcoes: <a href=\"home.html\">Home</a> | <a href=\"controlar.html\">Controlar</a> | <a href=\"led.html\">LED</a> | <a href=\"modo.html\">Modos de conducao</a> | <a href=\"contato.html\">Contato</a></p></body></html>\r\n";
}

String bodyResponseLed(){
     return String("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">") +
            "<html>"
                "<head>" +
                  "<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">" +
                  "<title>LED - Project Car v2</title>" +
                "</head>" +
                "<body>" +
                  "<h1>Apague ou acenda o LED</h1>" +
                  "<p> Apague ou acenda o LED pelos botões abaixo.</p>" +
                  "<form>" +
                    "<button type=\"button\">Dodo :(</button>" +
                    "<button type=\"button\">Xandao :D</button>" +
                  "</form>" +
                  "<p>Mais opcoes: " +
                    "<a href=\"home.html\">Home</a> | " +
                    "<a href=\"controlar.html\">Controlar</a> | " +
                    "<a href=\"led.html\">LED</a> | " +
                    "<a href=\"modo.html\">Modos de conducao</a> | " +
                    "<a href=\"contato.html\">Contato</a>" +
                  "</p>"+
                "</body>" +
            "</html>" +
            "\r\n";
}

String bodyResponseModo(){
  return String("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">") +
            "<html>"
                "<head>" +
                  "<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">" +
                  "<title>Modo - Project Car v2</title>" +
                "</head>" +
                "<body>" +
                  "<h1>Escolha seu modo de conducao</h1>" +
                  "<p> Se voce deseja uma direcao mais confortavel, aperte o botao dodo.</p>" +
                  "<p> Se voce deseja um direcao mais agressiva, aperte o botao xandao.</p>" +
                  "<form>" + 
                    "<button type=\"button\">Dodo :(</button>" +
                    "<button type=\"button\">Xandao :D</button>" +
                  "</form>" +
                  "<p>Mais opcoes: " +
                    "<a href=\"home.html\">Home</a> | " +
                    "<a href=\"controlar.html\">Controlar</a> | " +
                    "<a href=\"led.html\">LED</a> | " +
                    "<a href=\"modo.html\">Modos de conducao</a> | " +
                    "<a href=\"contato.html\">Contato</a>" +
                  "</p>"+
                "</body>" +
            "</html>" +
            "\r\n";
}

String bodyResponse404(){
   return String("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">") +
            "<html>"
                "<head>" +
                  "<meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1252\">" +
                  "<title>404 Page not found</title>" +
                "</head>" +
                "<body>" +
                  "<h1>Page not found :(</h1>" +
                  "<p>The requested URL was not found on this server.</p>" +
                  "<p>Mais opcoes: " +
                    "<a href=\"home.html\">Home</a> | " +
                    "<a href=\"controlar.html\">Controlar</a> | " +
                    "<a href=\"led.html\">LED</a> | " +
                    "<a href=\"modo.html\">Modos de conducao</a> | " +
                    "<a href=\"contato.html\">Contato</a>" +
                  "</p>"+
                "</body>" +
            "</html>" +
            "\r\n";
}

