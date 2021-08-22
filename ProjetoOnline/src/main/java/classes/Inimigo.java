/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        int nivelInimigo = getNivel();
        super.setNivel(nivelInimigo + nivelJogador); //To change body of generated methods, choose Tools | Templates.
    }
    

}
