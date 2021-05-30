/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.Interface.IPropertiesDB;
import Modelos.ModeloAlimento;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alang
 */
public class AlimentoMD {

    IPropertiesDB _properties;

    //CONSTRUCTOR
    public AlimentoMD(IPropertiesDB properties) {
        _properties = properties;
    }
    //METODO INSERTAR

    public boolean insertar(ModeloAlimento alimento) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = _properties.getInsertAlimento() + "('" + alimento.codigo_alimento + "','" + alimento.nombre_alimento
                + "','" + alimento.tipo_alimento + "','" + alimento.cantidad + "','" + alimento.unidadmedida + "')";

        return datosDB.CUD(sqlOp);
    }

    public boolean modificar(String codigo_alimento, String nombre_alimento, String tipo_alimento, double cantidad, String unidadmedida) {
        boolean inserta = false;
        String sqlOp = _properties.getModificarAlimento() + " nombre_alimento=?,tipo_alimento=?,cantidad=?,unidadmedida=?"
                + " WHERE codigo_alimento=?";

        String raiz = _properties.getRaiz();
        String conexion = _properties.getConexion();
        String db = _properties.getDB();

        try {
            Connection con = DriverManager.getConnection(conexion + raiz + db);
            Statement st = con.createStatement();

            PreparedStatement pst = con.prepareStatement(sqlOp);
            pst.setString(1, nombre_alimento);
            pst.setString(2, tipo_alimento);
            pst.setDouble(3, cantidad);
            pst.setString(4, unidadmedida);
            pst.setString(5, codigo_alimento);

            inserta = (pst.executeUpdate() == 1);

            con.close();
            pst.close();
        } catch (Exception e) {

        } finally {
        }
        return inserta;
    }

    public boolean eliminar(String codigo_alimento) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sqlOp = _properties.getEliminarAlimento() + "'" + codigo_alimento + "'";
        return datosDB.CUD(sqlOp);

    }

    public ArrayList<ModeloAlimento> consultaGeneral() {
        ArrayList<ModeloAlimento> alimentos = new ArrayList<ModeloAlimento>();
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);

        String sqlOp = _properties.getConsultarAlimento();

        ResultSet ResultSet = datosDB.Consultar(sqlOp);
        try {
            while (ResultSet.next()) {
                ModeloAlimento alimento = new ModeloAlimento();
                alimento.codigo_alimento = ResultSet.getString("codigo_alimento");
                alimento.nombre_alimento = ResultSet.getString("nombre_alimento");
                alimento.tipo_alimento = ResultSet.getString("tipo_alimento");
                alimento.cantidad = ResultSet.getDouble("cantidad");
                alimento.unidadmedida = ResultSet.getString("unidadmedida");
                alimentos.add(alimento);
            }
        } catch (Exception e) {

        }
        return alimentos;
    }

    public ModeloAlimento consultaParametro(String codigo_alimento) {
        ManejoDeDatosDB datosDB = new ManejoDeDatosDB(_properties);
        String sqlOp = _properties.getConsultarAlimento() + " WHERE codigo_alimento = '" + codigo_alimento + "'";
        ResultSet ResultSet = datosDB.Consultar(sqlOp);
        ModeloAlimento alimento = new ModeloAlimento();

        try {
            ResultSet.next();
            alimento.codigo_alimento = ResultSet.getString("codigo_alimento");
            alimento.nombre_alimento = ResultSet.getString("nombre_alimento");
            alimento.tipo_alimento = ResultSet.getString("tipo_alimento");
            alimento.cantidad = ResultSet.getDouble("cantidad");
            alimento.unidadmedida = ResultSet.getString("unidadmedida");
        } catch (Exception e) {

        }
        return alimento;
    }
}
