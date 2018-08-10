package dao;

import dao.ConectaBanco;
import dao.DaoInterface;
import dao.Dao;
import static dao.Dao.getUltimoId;
import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author giovane richard
 */
public class ClienteDao implements DaoInterface<Cliente> {

    @Override
    public Integer salvar(Cliente o) {

        int idResposta = 0;

        try {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt = null;

            // Inserir um novo objeto
            if (o.getId() == 0) {
                
                pstmt = con.prepareStatement("INSERT INTO cliente(nome, telefone, email, cpf, rua, bairro, cidade, uf, sexo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            } else {
                //Atualiza um objeto existente
                pstmt = con.prepareStatement("UPDATE cliente "
                        + "SET nome = ?, telefone = ?, email = ?, "
                        + "cpf = ?,  rua = ?, bairro = ?, cidade = ?, "
                        + "uf = ?, sexo = ?,  id = ? "
                        + "where id = ?;");
                pstmt.setInt(12, o.getId());
            }

            pstmt.setString(1, o.getNome());
            pstmt.setString(2, o.getTelefone());
            pstmt.setString(3, o.getEmail());
            pstmt.setString(4, o.getCpf());
            pstmt.setString(6, o.getRua());
            pstmt.setString(7, o.getBairro());
            pstmt.setString(8, o.getCidade());
            pstmt.setString(9, o.getUf());
            pstmt.setString(10, o.getSexo());
            
            
            // Persiste os dados no banco
            pstmt.executeUpdate();

            //idResposta = o.getId() == 0 ? getUltimoId() : o.getId();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");

            // Fecha comando e a conexão
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Não foi possível salvar os dados!");
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!");
        }
        System.out.println("IdResposta: " + idResposta);

        return idResposta;
    }

    public boolean Salve(Cliente o) {

        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt;

        try {
            pstmt = con.prepareStatement("INSERT INTO cliente(nome, telefone, email, cpf, rua, bairro, cidade, uf, sexo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
          
            pstmt.setString(1, o.getNome());
            pstmt.setString(2, o.getTelefone());
            pstmt.setString(3, o.getEmail());
            pstmt.setString(4, o.getCpf());
            pstmt.setString(6, o.getRua());
            pstmt.setString(7, o.getBairro());
            pstmt.setString(8, o.getCidade());
            pstmt.setString(9, o.getUf());
            pstmt.setString(10, o.getSexo());
            
            pstmt.executeQuery();
            return true;
        } catch (SQLException ex) {
            System.out.println("Possíveis Erros: " + ex);
            JOptionPane.showMessageDialog(null,"Erro ao salvar os dados");
            return false;
        }
        
    }

    public List<Cliente> read(String descricao) {

        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {

            pstmt = con.prepareStatement("SELECT * FROM Cliente WHERE nome LIKE ?");
            pstmt.setString(1, "%" + descricao + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Cliente cl = new Cliente();

                cl.setId(rs.getInt("id"));
                cl.setNome(rs.getString("nome"));
                cl.setTelefone(rs.getString("telefone"));
                cl.setEmail(rs.getString("email"));
                cl.setCpf(rs.getString("cpf"));
                cl.setRua(rs.getString("rua"));
                cl.setBairro(rs.getString("bairro"));
                cl.setCidade(rs.getString("cidade"));
                cl.setUf(rs.getString("uf"));
                cl.setSexo(rs.getString("sexo"));

                //Adiciona a lista
                clientes.add(cl);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pelo cliente!" + e);
        }

        return clientes;
    }

    /**
     * Recupera conjunto de objetos segundo objeto exemplo passado.
     *
     * @param o Exemplo de Cliente a ser buscada (id).
     * @return Lista de objetos recuperados do banco de dados.
     */
    @Override
    public List<Cliente> buscar(Cliente o) {

        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt = null;

        try {

            //pstmt = con.prepareStatement("SELECT id, nome, telefone, email FROM cliente;");
            pstmt = con.prepareStatement("SELECT * FROM cliente;");

            if (o.getId() == null) {
                o.setId(0);
            }

            pstmt.setInt(1, o.getId());

        } catch (SQLException sqlex) {
            System.out.println("Erro ao tentar buscar no banco!\n" + sqlex);
        }

        return realizarConsulta(pstmt);
    }

//    @Override
//    public List<Cliente> buscar(Cliente o) {
//        return buscar(o, 0);
//    }
//    
    public ArrayList<Cliente> buscarPorNomeInicial_2(Cliente o) {

        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            pstmt = con.prepareStatement("SELECT * FROM cliente WHERE like nome% ?;");

        } catch (SQLException sqlex) {
            System.out.println("Erro ao buscar nomes no banco " + sqlex);
        }
        return realizarConsulta(pstmt);
    }

    /**
     * Recupera conjunto de objetos segundo objeto exemplo passado com restrição
     * de quantidade de objetos retornados.
     *
     * @param o Exemplo de Cliente a ser buscada (id).
     * @param limite Quantidade limite de objetos retornados.
     * @return Lista de objetos recuperados do banco de dados.
     */
//    public List<Cliente> buscar(Cliente o, int limite){
//        
//        Connection con = ConectaBanco.getConexao();
//        PreparedStatement pstmt = null;
//        
//        try {
//            if(o == null){
//                // Seleciona todos os empregados se nenhum exemplo for passado
//                if(limite == 0){
//                    //pstmt = con.prepareStatement("SELECT * FROM cliente;");
//                    pstmt = con.prepareStatement("SELECT id, nome, telefone, cpf FROM cliente;");
//                }else{
//                    pstmt = con.prepareStatement("SELECT * FROM cliente limit ?;");
//                    pstmt.setInt(1, limite);
//                }
//            }else{
//                // Seleciona cliente a partir do exemplo
//               if(limite == 0){
//                    pstmt = con.prepareStatement("SELECT * FROM cliente WHERE id = ?;");
//                }else{
//                    pstmt = con.prepareStatement("SELECT * FROM cliente WHERE id = ? limit = ?;");
//                    pstmt.setInt(2, limite);
//                }
//                pstmt.setInt(1, o.getId());
//            }
//        } catch (SQLException sqlex) {
//            System.out.println("SQLException");
//        }
//        
//        return realizarConsulta(pstmt);
//   }
    /**
     * Recupera conjunto de Clientes segundo objeto exemplo passado com base na
     * inicial do nome e sem restrição de quantidade de objetos retornados.
     *
     * @param o Exemplo de Cliente a ser buscada (id).
     * @return Lista de objetos recuperados do banco de dados
     */
    public ArrayList<Cliente> buscarPorNomeInicial(Cliente o) {
        return buscarPorNomeInicial(o, 0);
    }

    /**
     * Recupera conjunto de Clientes segundo objeto exemplo passado com base na
     * inicial do nome e com restrição de quantidade de objetos retornados.
     *
     * @param o Exemplo de Pessoa a ser buscada (id).
     * @param limite Quantidade limite de objetos retornados.
     * @return Lista de objetos recuperados do banco de dados.
     */
    public ArrayList<Cliente> buscarPorNomeInicial(Cliente o, int limite) {

        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt = null;

        try {
            if (o == null) {
                // Seleciona todos os empregados se nenhum exemplo for passado
                if (limite == 0) {
                    pstmt = con.prepareStatement("SELECT * FROM cliente;");
                } else {
                    pstmt = con.prepareStatement("SELECT * FROM cliente limit ?;");
                    pstmt.setInt(1, limite);
                }
            } else {
                // Seleciona a pessoa a partir do exemplo
                if (limite == 0) {
                    pstmt = con.prepareStatement("SELECT * FROM cliente "
                            + "WHERE nome like ?;");
                } else {
                    pstmt = con.prepareStatement("SELECT * FROM cliente "
                            + "WHERE nome like ? "
                            + "limit ?;");
                }

                pstmt.setString(1, o.getNome() + "%");
            }
        } catch (SQLException sqlex) {
            System.out.println("SQLException");
        }

        return realizarConsulta(pstmt);
    }

    /**
     * Recupera conjunto de Pessoas segundo objeto exemplo passado com base no
     * nome e sem restrição de quantidade de objetos retornados.
     *
     * @param o Exemplo de Pessoa a ser buscada (id).
     * @return Lista de objetos reperados do banco de dados.
     */
    public ArrayList<Cliente> buscarPorNomeParcial(Cliente o) {

        return buscarPorNomeParcial(o, 0);
    }

    /**
     * Recupera conjunto de Cliente segundo objeto exemplo passado com base no
     * RG e com restrição de quantidade de objetos retornados.
     *
     * @param o Exemplo de Cliente a ser buscada (id).
     * @param limite Quantidade limite de objetos retornados.
     * @return Lista de objetos reperados do banco de dados.
     */
    public ArrayList<Cliente> buscarPorNomeParcial(Cliente o, int limite) {

        Connection con = ConectaBanco.getConexao();
        PreparedStatement pstmt = null;

        try {

            if (o == null) {
                // Seleciona todos os cliente se nenhum exemplo é passado

                if (limite == 0) {
                    pstmt = con.prepareStatement("select * from cliente;");

                } else {
                    pstmt = con.prepareStatement("select * from cliente limit ?;");
                    pstmt.setInt(1, limite);
                }

            } else {
                // Seleciona cliente a partir do exemplo

                if (limite == 0) {
                    pstmt = con.prepareStatement("select * from cliente "
                            + "where nome like ?;");

                } else {
                    pstmt = con.prepareStatement("select * from cliente "
                            + "where nome like ? "
                            + "limit ?;");
                    pstmt.setInt(2, limite);
                }

                pstmt.setString(1, "%" + o.getNome() + "%");
            }

        } catch (SQLException sqlex) {
            System.out.println("SQLException");
        }

        return realizarConsulta(pstmt);
    }

    /**
     * Realiza a efetiva consulta no banco de dados.
     *
     * @param pstmt Consulta preparada
     * @return Clietes localizada
     */
    private ArrayList<Cliente> realizarConsulta(PreparedStatement pstmt) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                clientes.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getString("sexo")
                ));
            }

            rs.close();
            pstmt.close();

        } catch (SQLException sqlex) {
            System.out.println("SQLException");
            JOptionPane.showMessageDialog(null, "Erro no ResultSet!");
        }

        if (clientes.isEmpty()) {
            return null;
        } else {
            return clientes;
        }
    }

    @Override
    public int excluir(Cliente o) {

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
