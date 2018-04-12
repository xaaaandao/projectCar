#include <ESP8266WiFi.h>

#include <Arduino.h>

const char* ssid = "tchaubrigado";
const char* password = "123456";

WiFiServer server(80);

void setup(){
  Serial.begin(115200);
  WiFi.softAP(ssid, password);
  IPAddress myIP = WiFi.softAPIP();
  Serial.print("AP IP address: ");
  Serial.println(myIP);
  server.begin();
}

void loop(){
  WiFiClient client = server.available();
  // wait for a client (web browser) to connect
  if (client){
    Serial.println("\n[Client connected]");
    while (client.connected()){
      // read line by line what the client (web browser) is requesting
      if (client.available()){
        String line = client.readStringUntil('\r');
        Serial.print(line);
        // wait for end of client's request, that is marked with an empty line
        if (line.length() == 1 && line[0] == '\n'){
          client.println(headerClient() + bodyClient());
          break;
        }
      }
    }
    delay(1); // give the web browser time to receive the data

    // close the connection:
    client.stop();
    Serial.println("[Client disonnected]");
  }
}

String headerClient(){
  return String("HTTP/1.1 200 OK\r\n") +
            "Content-Type: text/html\r\n" +
            "Connection: close\r\n" +  // the connection will be closed after completion of the response
            "Refresh: 5\r\n" +  // refresh the page automatically every 5 sec
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
}

