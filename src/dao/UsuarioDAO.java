/*

 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {
    
    private Usuario usuario;
    public DB db;
    private PreparedStatement statement;
    private String sql;
    
    
    public UsuarioDAO(){
        usuario = new Usuario();
        db = new DB();
    }
    
    public void inserir (Usuario usuario){
        if(db.getConexao()){
        try{
            sql = "INSERT INTO tb_teste (tst_nome_tst_idade)VALUES (?,?)";
            statement = db.conexao.prepareStatement(sql);
            statement.setString(1,usuario.getNome());
            statement.setInt(2,usuario.getIdade());
            statement.execute();
            statement.close();
            
        }catch (SQLException erro){
            System.out.println("Falha na operação");
            System.out.println("Erro: " + erro);
            
            
        }finally{
            db.fechar();
                   
        }}
         
    }
            
    
    public boolean excluir (Usuario usuario){
        if(db.getConexao()){
            String sql = "DELETE FROM tb_teste where tst_id = ?";
            try{
                 statement = db.conexao.prepareStatement(sql);
                 statement.setInt(1,usuario.getId());
                 if(statement.executeUpdate()==1){
                     return true;
                 }
              
                 
               //  statement.execute();
                // statement.close();

                 
            }catch (SQLException erro){
            System.out.println("Falha na operação");
            System.out.println("Erro: " + erro);
            return false;    
     
            }           
        }
        return false;
    }
    
    public List<Usuario> listarTudo(){
        if (db.getConexao()){
        List<Usuario> usuarios = new ArrayList();
        sql = "SELECT * FROM tb_teste";
        try{
            statement = db.conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("tst_id"));
                usuario.setNome(resultSet.getString("tst_nome"));
                usuario.setIdade(resultSet.getInt("tst_idade"));
                usuarios.add(usuario);
                     
            }
            
          
        }catch (SQLException erro){
            System.out.println("Falha na operação");
            System.out.println("Erro: " + erro);
                            
        }
        return usuarios;
    }
    
    return null;
            
    }}
        
        
    
    
        
        
        
