package br.com.videoAula.exemploWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
	
	
	
	public boolean inserirUsuario(Usuario usuario){
		
		
		try {
			
			Connection con = ConectaMysql.obterConexao();
			String queryInserir = "insert into usuario values(null,?,?)";
			
			PreparedStatement ppstm = con.prepareStatement(queryInserir);
			ppstm.setString(1, usuario.getNome());
			ppstm.setInt(2, usuario.getIdade());
			
			ppstm.executeUpdate();
			
			con.close();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		}
	
		
		return true;
	}
	
	public boolean atualizarUsuario(Usuario usuario){
		
		
		
		try {
			
			Connection con = ConectaMysql.obterConexao();
			String queryInserir = "update usuario set nome=?, idade=? where id = ?";
			
			PreparedStatement ppstm = con.prepareStatement(queryInserir);
			ppstm.setString(1, usuario.getNome());
			ppstm.setInt(2, usuario.getIdade());
			ppstm.setInt(3, usuario.getId());
			
			ppstm.executeUpdate();
			
			con.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
		
		return true;
	}
	
	
	
	public boolean excluirUsuario(Usuario usuario){
		
		try {
			
			Connection con = ConectaMysql.obterConexao();
			String queryInserir = "delete from usuario where id=?";
			
			PreparedStatement ppstm = con.prepareStatement(queryInserir);
			
			ppstm.setInt(1, usuario.getId());
			
			ppstm.executeUpdate();
			
			con.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
		
		return true;
	}
	
	public ArrayList<Usuario> buscarTodosUsuarios(){
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			
			Connection con = ConectaMysql.obterConexao();
			String queryInserir = "select*from usuario";
			
			PreparedStatement ppstm = con.prepareStatement(queryInserir);

			
			ResultSet resultSet = ppstm.executeQuery();
			
			while(resultSet.next()){
				
				Usuario user = new Usuario();
				
				user.setId(resultSet.getInt(1));
				user.setNome(resultSet.getString(2));
				user.setIdade(resultSet.getInt(3));
				
				lista.add(user);
			}
			
			con.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return lista;
	}
	
	public Usuario buscarUsuarioPorId(int id){
		
		Usuario user = null;
		
		try {
			
			Connection con = ConectaMysql.obterConexao();
			String queryInserir = "select*from usuario where id=?";
			
			PreparedStatement ppstm = con.prepareStatement(queryInserir);
			
			ppstm.setInt(1, id);
			
			
			ResultSet resultSet = ppstm.executeQuery();
			
			if(resultSet.next()){
				
				user = new Usuario();
				user.setId(resultSet.getInt(1));
				user.setNome(resultSet.getString(2));
				user.setIdade(resultSet.getInt(3));
			}else{
				
				
				return user;
			}
			
			con.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return user;
	}
	
	
	public boolean excluirUsuario(int id){
		
		return excluirUsuario(new Usuario(id,"",0));
	}
	
	

}//fim da classe UsuarioDAO
