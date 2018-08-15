package dao;

import entity.Profissional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author giovane richard
 */
public class ProfissionalDao implements DaoInterface<Profissional>{
    Dao dao = new Dao();
    
    @Override
    public Integer salvar(Profissional o) {
        
        int idresposta = 0;
        
        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt;
        
        try {
            
            pstmt = con.prepareStatement("INSERT INTO profissional(id, nome, cbo, cpf, celular, telefone, email) VALUES(?, ?, ?, ?, ?, ?, ?);");
            
            pstmt.setInt(1, o.getId());
            pstmt.setString(2, o.getNome());
            pstmt.setInt(3, o.getCbo());
            pstmt.setString(4, o.getCpf());
            pstmt.setString(5, o.getCelular());
            pstmt.setString(6, o.getTelefone());
            pstmt.setString(7, o.getEmail());
            
            idresposta = dao.getUltimoId();
            
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println("Possíveis Erros: " + ex);
            JOptionPane.showMessageDialog(null,"Erro ao salvar os dados");
        }
        return idresposta;
    }

    public int Salve(Profissional o) {
        int idResposta =0;
        
        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;
            
            pstmt = con.prepareStatement("INSERT INTO profissional " 
                    + "(id, nome, cbo, cpf, celular, telefone, email) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?);");
            
            pstmt.setInt(1, o.getId());
            pstmt.setString(2, o.getNome());
            pstmt.setInt(3, o.getCbo());
            pstmt.setString(4, o.getCpf());
            pstmt.setString(5, o.getCelular());
            pstmt.setString(5, o.getTelefone());
            pstmt.setString(6, o.getEmail());
            
            idResposta = dao.getUltimoId();
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            return idResposta;
        } catch (SQLException ex) {
            System.out.println("Possíveis Erros: " + ex);
            JOptionPane.showMessageDialog(null,"Erro ao salvar os dados" + ex);
            return idResposta;
        }
        
    }
    
    
    
    @Override
    public List<Profissional> buscar(Profissional o) {
        return null;
    }
    
    
    
    public List<Profissional> read(String descricao) {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Profissional> profisssional = new ArrayList<>();

        try {

            pstmt = con.prepareStatement("SELECT * FROM profissional WHERE nome LIKE ?");
            pstmt.setString(1, "%" + descricao + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Profissional pro = new Profissional();

                pro.setId(rs.getInt("id"));
                pro.setNome(rs.getString("nome"));
                pro.setCbo(rs.getInt("cbo"));
                pro.setCpf(rs.getString("cpf"));
                pro.setTelefone(rs.getString("celular"));
                pro.setTelefone(rs.getString("telefone"));
                pro.setEmail(rs.getString("email"));

                //Adiciona a lista
                profisssional.add(pro);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pelo cliente!" + e);
        }

        return profisssional;
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
