package dao;

import java.util.List;

/**
 *
 * @author giovane richard
 */
public interface DaoInterface<T> {
    public Integer salvar(T o);
    public List<T> buscar(T o);
    public int excluir(T o);
    
}
