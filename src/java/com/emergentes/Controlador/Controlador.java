package com.emergentes.Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import com.emergentes.Modelo.Tarea;
import com.emergentes.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op"):"list";
        ArrayList<Tarea> listatar = (ArrayList<Tarea>)new ArrayList<Tarea>();
        
        Conexion canal = new Conexion();
        Connection conn = canal.conetar();
        PreparedStatement ps;
        ResultSet rs;
        
        if (op.equals("list")) {
            
            try{
               String sql = "select * from tarea";
               ps = conn.prepareStatement(sql);
               rs = ps.executeQuery();
               
               while (rs.next()){
                 Tarea tar = new Tarea();
                 tar.setId(rs.getInt("id"));
                 tar.setNombre(rs.getString("nombre"));
                 tar.setPrioridad(rs.getInt("prioridad"));
                 tar.setCompletado(rs.getInt("completado"));
                 
                 listatar.add(tar);
               }
               
               request.setAttribute("lista", listatar);
               request.getRequestDispatcher("index.jsp").forward(request, response);
               
            }catch(SQLException ex){
                System.out.println("Ocurrio un error en la BD. " + ex.getMessage());
            }finally{
                canal.desconectar();
            }
        }
        
        if (op.equals("nuevo")) {
            Tarea uno = new Tarea();
            request.setAttribute("tarea", uno);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        
        if (op.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
               String sql = "delete from tarea where id = ?";
               ps = conn.prepareStatement(sql);
               ps.setInt(1, id);
               ps.executeUpdate();
            }catch (SQLException ex){
                System.out.println("Error en la BD_TAREA_ _ " + ex.getMessage());
            }finally{
                canal.desconectar();
            }
            response.sendRedirect("Controlador");
        }
        
        
        if (op.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
            String sql = "select * from tarea where id = ?";
               ps = conn.prepareStatement(sql);
               ps.setInt(1, id);
               rs = ps.executeQuery();
              
               Tarea dos = new Tarea();
               while (rs.next()){   
                 dos.setId(rs.getInt("id"));
                 dos.setNombre(rs.getString("nombre"));
                 dos.setPrioridad(Integer.parseInt(rs.getString("prioridad")));
                 dos.setCompletado(Integer.parseInt(rs.getString("completado")));
               }
       
               request.setAttribute("tarea", dos );
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               
            }catch (SQLException ex){
                System.out.println("Error en la BD_TAREAS _ _ " + ex.getMessage());
            }
            
        }
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int prioridad =  Integer.parseInt(request.getParameter("prioridad"));
        int completado = Integer.parseInt(request.getParameter("completado"));
        
        Tarea uno = new Tarea();
        
        uno.setId(id);
        uno.setNombre(nombre);
        uno.setPrioridad(prioridad);
        uno.setCompletado(completado);
        
        Conexion canal = new Conexion();
        Connection conn = canal.conetar();
        PreparedStatement ps;
        ResultSet rs;
        
        if (id == 0) {
            try{
               String sql = "insert into tarea (nombre, prioridad, completado) values (?,?,?)";
               ps = conn.prepareStatement(sql);
               ps.setString(1,uno.getNombre());
               ps.setInt(2,uno.getPrioridad());
               ps.setInt(3,uno.getCompletado());
               ps.executeUpdate();
            }catch(SQLException ex){
                System.out.println("Error en SQL. " + ex.getMessage());
            }finally{
               canal.desconectar();
            }
        }
        if (id  != 0) {
            try{
                
               String sql = "update tarea set nombre=?, prioridad=?, completado=? where id = ? ";
               
               ps = conn.prepareStatement(sql);
               ps.setString(1,uno.getNombre());
               ps.setInt(2,uno.getPrioridad());
               ps.setInt(3,uno.getCompletado());
               ps.setInt(4,uno.getId());
               ps.executeUpdate();
            }catch(SQLException ex){
                System.out.println("Error en SQL. " + ex.getMessage());
            }finally{
               canal.desconectar();
            }
        }
        
        response.sendRedirect("Controlador");
    }

}
