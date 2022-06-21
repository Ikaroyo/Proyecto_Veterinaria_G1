/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria_MODELO;

import veterinaria_CONTROLADOR.TratamientoData;
import veterinaria_CONTROLADOR.MascotaData;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import veterinaria_CONTROLADOR.ClienteData;
import veterinaria_CONTROLADOR.Conexion;
import veterinaria_CONTROLADOR.VisitaData;


/**
 *
 * @author Barbara
 */
public class Veterinaria_Test_Main {

      public Connection con = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            // TODO code application logic here
            Conexion conexion = new Conexion();
            ClienteData cd = new ClienteData(conexion);
            MascotaData md = new MascotaData(conexion);
            TratamientoData td = new TratamientoData(conexion);
            VisitaData vd = new VisitaData(conexion);


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Veterinaria_Test_Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
