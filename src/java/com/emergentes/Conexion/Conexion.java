package com.emergentes.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
public class Conexion {
    
    private String url = "jdbc:mysql://localhost:3306/bd_proyectos";
    private String usuario = "root";
    private String password = "";
    
    
    protected Connection conn = null;

    public Conexion() {
        try{
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion ok: "+ conn);
            }
        }catch(ClassNotFoundException ex){
                System.out.println("Se presento un error con el Driver del Sistema: " + ex.getMessage());
        
        }catch(SQLException ex){
                System.out.println("Error con la Conexion: "+ ex.getMessage());
        }
    }
    
    public Connection conetar(){
    return conn;
    }
    
    public void desconectar(){
        System.out.println("Cerrando la Base de Datos: "+conn);
        try{
           conn.close();
        }catch(SQLException e){
            System.out.println("Error al cerra: "+ e.getMessage());
        }
    }
    
    
}
