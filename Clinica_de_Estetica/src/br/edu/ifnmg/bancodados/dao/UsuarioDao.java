package br.edu.ifnmg.bancodados.dao;

import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author giovane richard
 */
public class UsuarioDao implements DaoInterface<Usuario> {
    
    public static final String TABELA = "usuario";
    /**
	 * Efetua a verificação da autenticidade dos dados digitados pelo usuário.
	 *
	 * @param o usuário a ser verificado.
	 * @return Autenticidade dos dados fornecidos.
	 */
    
    public boolean autenticar(Usuario o) {
        
        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt = null;
        
        try {
            // Criação de consulta personalisada
            if(o == null){
                return false;
            }else{
                pstmt = con.prepareStatement("SELECT * FROM " + TABELA + " WHERE usuario = ? and senha = ?" 
                        + " and ativo = true" + " and (expiracao >= ? || expiracao is null);");
                
                pstmt.setString(1, o.getUsuario());
                pstmt.setString(2, o.getSenha());
                pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
                
            }
        } catch (SQLException sqlex) {
			System.out.println("SQLException");
        }
        
        return realizarConsulta(pstmt) != null;
    }

    @Override
    public Integer salvar(Usuario o) {
        
        int idResposta = 0;
        
        try {
            
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt = null;
            
            if(o.getId() == 0){
                // insere um novo objeto
                pstmt = con.prepareStatement("INSERT INTO usuario "
                        + "(usuario, senha, ativo, expiracao, administrador) "
                        + "value(?, ?, ?, ?, ?);");
            }else{
                pstmt = con.prepareStatement("UPDATE usuario " 
                        + "set usuario = ?, senha = ?, ativo = ?, expiracao = ?, " 
                        + "administrador = ?, id = ? " 
                        + "where id = ?;");
                pstmt.setInt(6, o.getId());
            }
            
            pstmt.setString(1, o.getUsuario());
            pstmt.setString(2, o.getSenha());
            pstmt.setBoolean(3, o.isAtivo());
            pstmt.setString(4, o.getExpiracao());
            pstmt.setBoolean(5, o.isAdministrador());
            
            // Persiste os dados no banco
            pstmt.executeUpdate();
            
            // Fecha comando e a conexão
            pstmt.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Não foi possível salvar os dados!");
        }
        
        return idResposta;
    }

    @Override
    public List<Usuario> buscar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int excluir(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
    * Realiza a efetiva consulta no banco de dados.
    *
    * @param pstmt Consulta preparada.
    * @return usuários localizados.
    */
    private ArrayList<Usuario> realizarConsulta(PreparedStatement pstmt) {

	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

            try {
		ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {

			usuarios.add(new Usuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("senha"),
				rs.getBoolean("ativo"), rs.getString("expiracao"), rs.getBoolean("administrador")));
                                      //rs.getBoolean("ativo"), rs.getTimestamp("expiracao"), rs.getBoolean("administrador")));
			}

		rs.close();
		pstmt.close();

            } catch (SQLException sqlex) {
		System.out.println("SQLException");
	}

	if (usuarios.isEmpty()) {
            return null;

	} else {
            return usuarios;
	}
    }
    
}
