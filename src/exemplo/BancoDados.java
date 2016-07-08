/*
com.mysql.jdbc.Driver - String disponível na internet
a conexão é feita passando


 */
package exemplo;

import java.sql.*;
import java.util.Scanner;

public class BancoDados {
    private static Object conexao;

    public static void main(String[] args) throws SQLException {
       final String DRIVER = "com.mysql.jdbc.Driver";
       final String URL = "jdbc:mysql://localhost:3306/";
       final String BANCO = URL + "db_teste"; 
       final String USUARIO = "root";
       final String SENHA = "senac";
       
       
       Scanner sc = new Scanner(System.in);
              
        try{
        Class.forName(DRIVER); //String de Driver de conexão
        Connection conexao = DriverManager.getConnection(
                "BANCO", // endereço banco de dados
                "USUARIO", // usuario do banco
                "SENHA");  // senha do banco
        
        
          //  System.out.println("Conexão feita com sucesso!")   
  
        Usuario usuario = new Usuario();
        System.out.println("Nome: ");
        usuario.setNome(sc.next());
        
        System.out.println("Idade: ");
        usuario.setIdade(sc.nextInt());
        
        String sql = "INSERT INTO tb_teste(tst_nome,tst_idade) VALUES(?,?))";
        
        PreparedStatement statement = conexao.prepareStatement(sql); 
        
        statement.setString(1,usuario.getNome());
        statement.setInt(2,usuario.getIdade());
        
        
        
        statement.execute();
        
        conexao.close();
        
        }catch (ClassNotFoundException erro){
            System.out.println(erro.toString());  
        }catch (SQLException erro){
            System.out.println(erro.toString());  
         
        
        
        
}}}
