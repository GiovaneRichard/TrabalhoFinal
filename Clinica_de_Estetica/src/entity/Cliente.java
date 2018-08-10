package entity;

import java.util.Date;

/**
 *
 * @author giovane richard
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private String sexo;
   
    public Cliente(String nome, String telefone, String email, String cpf, String rua, String bairro, String cidade, String uf, String sexo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.sexo = sexo;
    }
    

    public Cliente(int id, String nome, String telefone, String email, String cpf, String rua, String bairro, String cidade, String uf, String sexo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.sexo = sexo;
       
    }

    public Cliente() {
       
    }

    

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
    @Override
    public String toString(){
        return getId() + " " + getNome() + " " + getTelefone() + " " + getEmail();
    }
    
}
