package dao;

import entity.Profissional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author giovane richard
 */
public class ProfissionalDao implements DaoInterface<Profissional>{

    @Override
    public Integer salvar(Profissional o) {
        
        int idresposta = 0;
        
        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt;
        
        try {
            
            pstmt = con.prepareStatement("INSERT INTO profissional(nome, cbo, cpf, celular, telefone, email) VALUES(?, ?, ?, ?, ?, ?)");
            
            pstmt.setString(1, o.getNome());
            pstmt.setInt(2, o.getCbo());
            pstmt.setString(3, o.getCpf());
            pstmt.setString(4, o.getCelular());
            pstmt.setString(5, o.getTelefone());
            pstmt.setString(6, o.getEmail());
            
            pstmt.execute();
        } catch (SQLException ex) {
            System.out.println("Possíveis Erros: " + ex);
        }
        return idresposta;
    }

    @Override
    public List<Profissional> buscar(Profissional o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int excluir(Profissional o) {
        int resposta = 0;

        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("DELETE FROM cliente WHERE id = ?;");
            pstmt.setInt(1, o.getId());

            resposta = pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dado excluído com sucesso!");
            // Liberação de recursos
            // Está atuando precocemente no fechamento da conexão com o banco
            pstmt.close();

        } catch (SQLException sqlex) {
            System.out.println("Erro ao Excluir o Cliente...\n" + sqlex);
        }

        return resposta;
    
    }
    
    
}
