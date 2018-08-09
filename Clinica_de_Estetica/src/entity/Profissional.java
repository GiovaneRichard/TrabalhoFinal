package entity;

/**
 *
 * @author giovane richard
 */
public class Profissional {
    
    private Integer id;
    private String nome;
    private Integer cbo;
    private Long cpf;
    private String telefone;
    private String celular;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCbo() {
        return cbo;
    }

    public void setCbo(Integer cbo) {
        this.cbo = cbo;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
    
    
    
    
}
