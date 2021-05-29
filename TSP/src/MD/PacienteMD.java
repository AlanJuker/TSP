/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.Interface.IPropertiesDB;

/**
 *
 * @author alang
 */
public class PacienteMD {

    IPropertiesDB _properties;

    //CONSTRUCTOR
    public PacienteMD(IPropertiesDB properties) {
        _properties = properties;
    }
    //METODO INSERTAR

    public boolean insertar(Modelos.ModeloPaciente paciente) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = _properties.getInsertPaciente() + "('" + paciente.id + "','" + paciente.nombre
                + "','" + paciente.genero + "','" + paciente.usuario + "','" + paciente.contrasenia + "','"
                + paciente.altura + "','" + paciente.peso + "','" + paciente.edad + "')";

        return datosDB.CUD(sqlOp);
    }

    public boolean modificar(Modelos.ModeloPaciente paciente) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = "Instrucción prueba";

        return datosDB.CUD(sqlOp);
    }

    public boolean eliminar(Modelos.ModeloPaciente paciente) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = "Instrucción prueba";

        return datosDB.CUD(sqlOp);
    }
    
}
