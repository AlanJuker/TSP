
import GUI.Login;
import MD.PacienteMD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Alan
 */
public class TSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PacienteMD p = new PacienteMD();
        p.insertar();
        new Login().setVisible(true);
    }
    
}
