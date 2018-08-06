package entity;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author giovane richard
 */
public class ClienteTableModel extends AbstractTableModel{
    
    private List<Cliente> linhas;
   // private String[] colunas = new String[]{"código", "nome", "telefone", "email", "cpf", "rg", "rua", "bairro", "cidade", "uf", "sexo", "dtnascimento"};
    private String[] colunas = new String[]{"código", "nome", "telefone", "email", "cpf"};

    public ClienteTableModel() {
        linhas = new ArrayList<Cliente>();
    }
    
    public ClienteTableModel(ArrayList<Cliente> lista){
        linhas = new ArrayList<Cliente>(lista);
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        Cliente c =  linhas.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return c.getId();
            case 1:
                return c.getNome();
            case 2:
                return c.getTelefone();
            case 3:
                return c.getEmail();
            case 4:
                return c.getCpf();
//            case 5:
//                return c.getRg();
//            case 6:
//                return c.getRua();
//            case 7:
//                return c.getBairro();
//            case 8:
//                return c.getCidade();
//            case 9:
//                return c.getUf();
//            case 10:
//                return c.getSexo();
//            case 11:
//                return c.getDtnascimento();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIdex){
        Cliente c = linhas.get(rowIndex);
        
        switch(columnIdex){ // seta o valor do campo respectivo
            case 0:
                c.setId(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                c.setNome(aValue.toString());
                break;
            case 2:
                c.setTelefone(aValue.toString());
                break;
            case 3:
                c.setEmail(aValue.toString());
                break;
            case 4:
                c.setCpf(aValue.toString());
                break;
//            case 5:
//                c.setRg(aValue.toString());
//                break;
//            case 6:
//                c.setRua(aValue.toString());
//                break;
//            case 7:
//                c.setBairro(aValue.toString());
//                break;
//            case 8:
//                c.setCidade(aValue.toString());
//                break;
//            case 9:
//                c.setUf(aValue.toString());
//                break;
//            case 10:
//                c.setSexo(aValue.toString());
//                break;
//            case 11:
//                c.setDtnascimento(aValue.toString());
//                break;    
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds"); 
        }
        fireTableCellUpdated(rowIndex, columnIdex);
    }
    
    // Modifica na linha especificada
    public void setValueAt(Cliente aValue, int rowIndex){
        
        Cliente c = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado
        
        c.setId(aValue.getId());
        c.setNome(aValue.getNome());
        c.setTelefone(aValue.getTelefone());
        c.setEmail(aValue.getEmail());
        c.setCpf(aValue.getCpf());
//        c.setRg(aValue.getRg());
//        c.setRua(aValue.getRua());
//        c.setBairro(aValue.getBairro());
//        c.setCidade(aValue.getCidade());
//        c.setUf(aValue.getUf());
//        c.setSexo(aValue.getSexo());
//        c.setDtnascimento(aValue.getDtnascimento());
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
//        fireTableCellUpdated(rowIndex, 5);
//        fireTableCellUpdated(rowIndex, 6);
//        fireTableCellUpdated(rowIndex, 7);
//        fireTableCellUpdated(rowIndex, 8);
//        fireTableCellUpdated(rowIndex, 9);
//        fireTableCellUpdated(rowIndex, 10);
//        fireTableCellUpdated(rowIndex, 11);
        
        
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public Cliente getCliente(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    
    public void addCliente(Cliente c){
        // Adiciona o registro.
        linhas.add(c);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    // Remove a linha especificada
    public void remove(int indiceLinha){
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
   public void addLista(List<Cliente> c){
       // pega o tamanho antigo da tabela
       int tamanhoAntigo = getRowCount();
       
       //Adiciona os registros.
       fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
   } 
    
   public void limpar(){
       linhas.clear();;
       fireTableDataChanged();
   }
   
   public boolean isEmpty(){
       return linhas.isEmpty();
   }
}
