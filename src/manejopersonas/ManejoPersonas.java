
package manejopersonas;

import datos.PersonasJDBC;
import datos.Conexion;
import java.sql.*;



public class ManejoPersonas {

    public static void main(String[] args){
            PersonasJDBC personasJDBC= new PersonasJDBC();
     
            Connection conn = null;

            try {
            conn = Conexion.getConnection();
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            PersonasJDBC personas= new PersonasJDBC(conn);
            //provocamos un error superando los 45 caracteres del campo apellido
            
            personas.update(2,"Regreso2","Regreso");
            personas.insert("Miguel", " Ayala123412341234");
            //guardamos los cambios
            conn.commit();
            
            }catch (SQLException e){
                //Hacemos rollback en caso de error
                
                try{
                    System.out.println("Entramos al Rollback");
                    e.printStackTrace(System.out);
                    
                    conn.rollback();
                } catch(SQLException el){
                    el.printStackTrace(System.out);
                }
                
        }
        
        
       
    }
    
}
