package projeto2;

/**
 * Autor: Alexandre Yuji Kajihara
 * Descrição: classe responsável por instanciar a
 * classe que tem a conexão com arduino e interface gráfica.
 * Data de criação: 20/06/2018
 * Data de atualização: 20/06/2018
 */
public class JacarGUI {

    /**
     * O método main(String[] args), é o método principal que instancia a classe que
     * tem a conexão com arduino e interface gráfica.
     * @param args, vetor de String com argumentos.
     * @return void, nenhum parâmetro.
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new InitializeArduino();
    }

}
