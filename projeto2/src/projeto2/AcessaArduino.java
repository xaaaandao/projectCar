package projeto2;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.TooManyListenersException;

/**
 * Autor: -
 * Descrição: classe responsável pela conexão com o arduino.
 * Data de criação: 21/06/2018
 * Data de atualização: 21/06/2018
 */

public class AcessaArduino extends Observable implements SerialPortEventListener {

    /* Atributos */
    private String portaSelecionada;
    private String tempString = "";
    SerialPort serialPort;
    
    /* The port we're normally going to use. */
    private static final String PORT_NAMES[] = {
        // Mac OS X
        "serial-A9007UX1",
        //linux
        "/dev/tty/usb", "/dev/ttyUSB0", "/dev/ttyUSB1", "/dev/ttyUSB2", "/dev/ttyACM0", "/dev/ttyACM1",
        "/dev/ttyACM2", "/dev/ttyACM3", "/dev/ttyACM4", "/dev/ttyACM5", "/dev/ttyACM6",
        // windows
        "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "COM10", "COM11", "COM12", "COM13"
    };
    
    /* Buffered input stream from the port */
    private BufferedReader input;
    
    /* The output stream to the port */
    private OutputStream output;
    
    /* Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    
    /* Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;

    /**
     * O construtor AcessaArduino(Observer observador), invoca um metódo que tem inicializa a conexão
     * com o arduino, recebe um classe que irá ser Observer.
     * @param observador, o parâmetro recebido irá virar um observador.
     * @return é um construtor.
     */
    public AcessaArduino(Observer observador) {
        addObserver(observador);
        initialize();
    }

     /**
     * O construtor AcessaArduino(), invoca um metódo que tem inicializa a conexão
     * com o arduino.
     * @param não tem parâmetro.
     * @return é um construtor.
     */
    public AcessaArduino() {
        initialize();
    }

    /**
     * O método getDadosArduino(), retorna o valor recebido do arduino.
     * @param não tem parâmetro.
     * @return tempString, retorna a String que é um valor recebido do arduino.
     */
    public String getDadosArduino() {
        return tempString;
    }

    /**
     * O método getPortaSelecionada(), retorna a porta do arduino.
     * @param não tem parâmetro.
     * @return portaSelecionada, retorna a String com a porta do Arduino.
     */
    public String getPortaSelecionada() {
        return portaSelecionada;
    }

    /**
     * O método getSerialPort(), retorna a serial port do arduino.
     * @param não tem parâmetro.
     * @return portaSelecionada, retorna a SerialPort do Arduino.
     */
    public SerialPort getSerialPort() {
        return serialPort;
    }

    /**
     * O método initialize(), inicializa a conexão com o arduino.
     * @param não tem parâmetro.
     * @return void, ou seja, não retorna nada.
     */
    private void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        portEnum = CommPortIdentifier.getPortIdentifiers();
        // iterate through, looking for the port
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    portaSelecionada = currPortId.getName();
                    // System.out.println("Porta selecionada=>" + currPortId.getName());
                    break;
                }
            }
        }

        if (portId == null) {
            System.out.println("Não encontrou a porta USB destinada ao Arduino");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            System.err.println(e.toString());
        }
    }

    /**
     * O método close(), fecha a conexão com a serial.
     * @param não tem parâmetro.
     * @return void, ou seja, não retorna nada.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * O método setDataToArduino(SerialPort portaDeComunicacao, String valor), envia
     * uma String para o arduino.
     * @param portaDeComunicacao, que é a porta por onde será transmitida a informação.
     * @param valor, que é o dado que será enviado.
     * @return void, ou seja, não retorna nada.
     */
    public void setDataToArduino(SerialPort portaDeComunicacao, String valor) {
        try {
            output.write(valor.getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * O método sendSingleByte(byte myByte), envia um byte para o arduino.
     * @param myByte, que é o byte que será enviado.
     * @return void, ou seja, não retorna nada.
     */
    public void sendSingleByte(byte myByte) {
        try {
            output.write(myByte);
            output.flush();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
  
    /**
     * O método serialEvent(byte myByte), observa se dados foram enviados pela serial.
     * @param oEvent, que é a serial que será monitorada.
     * @return void, ou seja, não retorna nada.
     */
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                tempString = inputLine;
               // System.out.println("tempString "+tempString);
                notifyObservers(tempString);
                setChanged();
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

}
