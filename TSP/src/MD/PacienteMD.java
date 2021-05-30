/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.Interface.IPropertiesDB;
import Modelos.ModeloPaciente;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public boolean insertar(ModeloPaciente paciente) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = _properties.getInsertPaciente() + "('" + paciente.id + "','" + paciente.nombre
                + "','" + paciente.genero + "','" + paciente.usuario + "','" + paciente.contrasenia + "','"
                + paciente.altura + "','" + paciente.peso + "','" + paciente.edad + "')";

        return datosDB.CUD(sqlOp);
    }

    public boolean modificar(ModeloPaciente paciente) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = "Instrucción prueba";

        return datosDB.CUD(sqlOp);
    }

    public boolean eliminar(ModeloPaciente paciente) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = "Instrucción prueba";

        return datosDB.CUD(sqlOp);
    }

    public ArrayList<ModeloPaciente> consultaGeneral() {
        ArrayList<ModeloPaciente> pacientes = new ArrayList<ModeloPaciente>();
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = _properties.getConsultarPaciente();

        ResultSet ResultSet = datosDB.Consultar(sqlOp);
        try {
            while (ResultSet.next()) {
                ModeloPaciente paciente = new ModeloPaciente();
                paciente.id = ResultSet.getString("id_paciente");
                paciente.nombre = ResultSet.getString("nombre_paciente");
                paciente.genero = ResultSet.getString("genero_paciente").toCharArray()[0];
                paciente.usuario = ResultSet.getString("usuario_paciente");
                paciente.contrasenia = ResultSet.getString("contrasenia_paciente");
                paciente.altura = ResultSet.getFloat("altura");
                paciente.peso = ResultSet.getFloat("peso");
                paciente.edad = ResultSet.getInt("edad");
                pacientes.add(paciente);
            }
        } catch (Exception e) {

        }
        return pacientes;
    }
}
