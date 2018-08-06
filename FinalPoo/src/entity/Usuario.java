package entity;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Formatter;

/**
 * Representa um usuário do sistema.
 * 
 * @author giovane richard
 * @version 1.0, 13 de junho de 2018
 * @since 0.1
 * @see UsuarioDao
 * 
 */
public class Usuario {
    
    private int id;
    private String usuario;
    private String senha;
    private boolean ativo;
    //private Date expiracao;
    private String expiracao;
    private boolean administrador;
    private static final String SALTO = "1FnW6";
    
    public Usuario(){
    }
    
    /**
     * Construtro de objetos do tipo <b>usuário<\b>.
     * <pre>
     * usuario u = new Usuario(1, "giovane", "123456", true, new Date(), false);
     * <\pre>
     * 
     * @param id
     * @param usuario
     * @param senha
     * @param ativo
     * @param expiracao
     * @param administrador
     */
    
    public Usuario(int id, String usuario, String senha, boolean ativo, String expiracao, boolean administrador){
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.ativo = ativo;
        this.expiracao = expiracao;
        this.administrador = administrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(String expiracao) {
        this.expiracao = expiracao;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    
    private static String encriptaSenha(String senha){
        String sha1 = "";
        
       try {
            MessageDigest codificador = MessageDigest.getInstance("SHA-1");
            codificador.reset();
            codificador.update(senha.getBytes("UTF-8"));
            sha1 = byteToHex(codificador.digest());

        } catch (NoSuchAlgorithmException nsaex) {
        	System.out.println("NoSuchAlgorithmException");
        } catch (UnsupportedEncodingException ueex) {
        	System.out.println("UnsupportedEncodingException");
        }

        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatador = new Formatter();
        for (byte b : hash) {
            formatador.format("%02x", b);
        }
        String result = formatador.toString();
        formatador.close();
        return result;
    }

    @Override
    public String toString() {
        return this.usuario;
    }
    
    
}
