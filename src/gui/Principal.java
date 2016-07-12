/*
com.mysql.jdbc.Driver - String disponível na internet
a conexão é feita passando


 */
package gui;

import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;


public class Principal {
    
    public static void main(String[] args){
     
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
//        
//        usuario.setNome(
//                JOptionPane.showInputDialog("Nome do Usuario")
//        );
//        
//        usuario.setIdade(
//                Integer.parseInt(
//                JOptionPane.showInputDialog("Idade do Usuario")
//             )           
//        );
//        
//        usuario.setId(
//                Integer.parseInt(
//                JOptionPane.showInputDialog("Id do Usuario")
//        
//                ) );
//        
//        if (dao.excluir(usuario)){
//             JOptionPane.showMessageDialog(null,"Sucesso");
//             
//////        }else{
//////             JOptionPane.showMessageDialog(null,"Falha");
//////            
//////                     
////            
////        }
        
        
        
        String texto = "";
        
        for (Usuario u: dao.listarTudo()){
            texto += u.getId() + "\t" + u.getNome()+ "t" + u.getIdade() + "\n";
 
        }
        
        JOptionPane.showMessageDialog(null, texto);
        
        
    }
}