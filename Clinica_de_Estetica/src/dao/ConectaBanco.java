package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giovane richard
 */
public class ConectaBanco {
    
    private static Connection conexao;
    private static String url = "jdbc:mysql://127.0.0.1/test";
    private static String usuario = "root";
    private static String senha = "";
    private static String banco = "dbestetica";
    
    
    public static Connection getConexao(){
        
        try {
            if( conexao == null)
                setUrl("jdbc:mysql://127.0.0.1/dbestetica");
            
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(getUrl(), usuario, senha);
                
        }  catch (ClassNotFoundException | SQLException e) {
//            System.out.println("Não foi possívle encontrar a Classe!");
        }
        
        return conexao;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConectaBanco.url = url;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        ConectaBanco.usuario = usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        ConectaBanco.senha = senha;
    }

    public static String getBanco() {
        return banco;
    }

    public static void setBanco(String banco) {
        ConectaBanco.banco = banco;
    }
            
     
    
}
