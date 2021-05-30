/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.Interface.IPropertiesDB;
import Modelos.ModeloPaciente;
import java.sql.*;
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

    public boolean modificar(String id, String Nnombre, char Ngenero, String Nusuario, String Ncontrasenia, double Naltura, double Npeso, int Nedad) {
        boolean inserta = false;
        String sqlOp = _properties.getModificarPaciente() + " nombre_paciente=?,genero_paciente=?,usuario_paciente=?,contrasenia_paciente=?,altura=?,peso=?,edad=?"
                + " WHERE id_paciente=?";

        String raiz = _properties.getRaiz();
        String conexion = _properties.getConexion();
        String db = _properties.getDB();

        try {
            Connection con = DriverManager.getConnection(conexion + raiz + db);
            Statement st = con.createStatement();

            PreparedStatement pst = con.prepareStatement(sqlOp);
            pst.setString(1, Nnombre);
            pst.setString(2, String.valueOf(Ngenero));
            pst.setString(3, Nusuario);
            pst.setString(4, Ncontrasenia);
            pst.setDouble(5, Naltura);
            pst.setDouble(6, Npeso);
            pst.setInt(7, Nedad);
            pst.setString(8, id);

            inserta = (pst.executeUpdate() == 1);

            con.close();
            pst.close();
        } catch (Exception e) {

        } finally {
        }
        return inserta;
    }

    public boolean eliminar(String id) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sqlOp = _properties.getEliminarPaciente() + "'" + id + "'";
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
                paciente.altura = ResultSet.getDouble("altura");
                paciente.peso = ResultSet.getDouble("peso");
                paciente.edad = ResultSet.getInt("edad");
                pacientes.add(paciente);
            }
        } catch (Exception e) {

        }
        return pacientes;
    }

    public ModeloPaciente consultaParametro(String id) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sqlOp = _properties.getConsultarPaciente()+ " WHERE id_paciente = '" + id + "'";
        ResultSet ResultSet = datosDB.Consultar(sqlOp);
        ModeloPaciente paciente = new ModeloPaciente();

        try {
            ResultSet.next();
            paciente.id = ResultSet.getString("id_paciente");
            paciente.nombre = ResultSet.getString("nombre_paciente");
            paciente.genero = ResultSet.getString("genero_paciente").toCharArray()[0];
            paciente.usuario = ResultSet.getString("usuario_paciente");
            paciente.contrasenia = ResultSet.getString("contrasenia_paciente");
            paciente.altura = ResultSet.getDouble("altura");
            paciente.peso = ResultSet.getDouble("peso");
            paciente.edad = ResultSet.getInt("edad");
        } catch (Exception e) {

        }
        return paciente;
    }
}
