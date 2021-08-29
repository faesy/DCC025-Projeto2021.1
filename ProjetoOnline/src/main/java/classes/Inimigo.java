/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package classes;

/**
 *
 * @author Usuario
 */
public class Inimigo extends Deus {

    public Inimigo() {
    }

    @Override
    public void setNivel(int nivelJogador) {
        super.setNivel(1 + nivelJogador); //To change body of generated methods, choose Tools | Templates.
    }
    

}
