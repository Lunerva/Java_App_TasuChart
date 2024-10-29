package app_reportegraficas;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionMySQL {
    //atributos
    private Connection conexion;
    boolean estadoConeccion = false;
    String user, password;
    
    //metodos
    //constructor
    public ConexionMySQL(){
        this.conexion = null;
    }
    //conectar a la base de datos
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/ChartProyecto?autoReconnect=true&useSSL=false",this.user,this.password);
            estadoConeccion = true;
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error mySQL: " + ex.getMessage());
            }
        
        return conexion;
    }
    
    public Connection conectar(String user, String password){
        this.user = user;
        this.password = password;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/ChartProyecto?autoReconnect=true&useSSL=false",user,password);
            estadoConeccion = true;
            JOptionPane.showMessageDialog(null, "Conection succeed");
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error mySQL: " + ex.getMessage());
            }
        
        return conexion;
    }
    
    //desconectarse de la base de datos
    public void desconectar(){
        try {
            conexion.close();
            estadoConeccion = false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mySQL: " + ex.getMessage());
        }
    }
    
    
    //mostrar los datos en la tabla
    public void mostrarTabla(JTable tabla,String nombreTabla){
        conectar();

        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);

            Statement sT = (Statement) conexion.createStatement();
            ResultSet rS = sT.executeQuery("Select * from "+nombreTabla);

            Object[] arreglo = new Object[4];

            while (rS.next()) {
                arreglo[0] = rS.getInt(1);
                arreglo[1] = rS.getString(2);
                arreglo[2] = rS.getInt(3);
                arreglo[3] = rS.getInt(4);
                modelo.addRow(arreglo);
            }

            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mySQL: " + ex.getMessage());
        }
        
        desconectar();
    }
    
}
