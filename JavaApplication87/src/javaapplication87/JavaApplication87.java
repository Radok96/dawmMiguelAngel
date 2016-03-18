/*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
 * and open the template in the editor.
  */
 package actividad1basedatos;
 
 import java.sql.*;
 
 /**
  *
  * @author franlu
  */
 public class JavaApplication87 {
 
    /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {
         // TODO code application logic here
         System.out.println("Iniciando");
        // Creando la conexión
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/izv_dawm","izv_dawm","123456");
             String If = "DROP TABLE IF EXISTS `REGISTRATION`;";
             String sql = "CREATE TABLE REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " + 
                    " last VARCHAR(255), " + 
                    " age INTEGER, " + 
                    " PRIMARY KEY ( id ))"; 
            String query = "SELECT first, last from REGISTRATION";
             String sqlc = "CREATE TABLE MGComercio "+
                     "(id_Comercio INTEGER not null,"+
                     "nombre varchar(50),"+
                     "direccion varchar(50),"+
                     "tipo varchar(20),"
                     + "PRIMARY KEY(id_Comercio))";
             String sqlp = "CREATE TABLE MGHorario "+
                     "(id_Horario INTEGER not null,"+
                    "dia_semana varchar(50),"+
                     "hinicio INTEGER,"+
                     "hfin INTEGER,"+
                     "minicio INTEGER"+ 
                     "mfin INTEGER"+
                    "id_Comercio INTEGER"+
                     "PRIMARY KEY(id_Horario)";
             Statement stmt = null;
             try {
                 stmt = con.createStatement();
                 stmt.executeUpdate(If);
                 stmt.executeUpdate(sql);
                 stmt.executeUpdate(sqlc);
                 stmt.executeUpdate(sqlp);
                 ResultSet rs = stmt.executeQuery(query);
                 while (rs.next()){
                     String first = rs.getString("first");
                     String second = rs.getString("second");
                     
                 }
             }
           catch (SQLException e){
                 e.printStackTrace();
             } finally {
                 stmt.close();
                 con.close();
             }
           
         }
         catch (ClassNotFoundException ex) {
             ex.printStackTrace();
         }
         catch ( Exception e){
             e.printStackTrace();
         }
     }
     
 }