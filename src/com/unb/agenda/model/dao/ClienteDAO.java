/**************************************************************************
 * @author vinicius
 * @version 1.0
 * Notice: Agenda Universiy Brazilian . All rights reserved.
 * 
 ***************************************************************************/
package com.unb.agenda.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.vo.Cliente;

/**
 * 
 * @author vinicius
 * Classe principal da model onde se implemeta as funções de  atualizar selecionar e deletar
 * e mais cadastrar especificadas na abstractDao 
 *
 */

public class ClienteDAO extends AbstractDAO<Cliente>  {
	private static final String SQL_INSERT = "INSERT INTO cliente(name,endereco,cpf) values(?,?,?);";
	private static final String SQL_DELETE = "delete from cliente where id = ? ;";
	private static final String SQL_UPDATE = "update cliente set name = ? ,endereco = ?,cpf =? where id = ?;";
	private static final String SQL_SELECT = "select * from cliente where id = ? ;";
	private static final String SQL_SELECTALL = "select * from cliente;";

	
	/**
	 *função de inserção que recebe uma variavel do tipo cliente como parametro 
	 */
	
	@Override
	public int insert(Cliente arg1) {
		int r = 0;
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			Class.forName(SQL_DRIVER);
			conn = DriverManager.getConnection(SQL_URL, SQL_USER,SQL_PASS);

			stm = conn.prepareStatement(SQL_INSERT);
			stm.setString(1, arg1.getNome());
			stm.setString(2, arg1.getEndereco());
			stm.setInt(3, arg1.getCpf());
			

			r = stm.executeUpdate();
		} catch (Exception e) {
            e.printStackTrace();
		}
		finally{
			try {
				stm.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return r;
	}
	
	/**
	 * função de atualização que recebe uma variavel do tipo cliente como parametro 
	 */
	
	@Override
	public int update(Cliente arg1) {
		int r = 0;
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			Class.forName(SQL_DRIVER);
			conn = DriverManager.getConnection(SQL_URL, SQL_USER,SQL_PASS);

			stm = conn.prepareStatement(SQL_UPDATE);
			stm.setString(1, arg1.getNome());
			stm.setString(2, arg1.getEndereco());
			stm.setInt(3, arg1.getCpf());
			stm.setInt(4, arg1.getId());

			r = stm.executeUpdate();
		} catch (Exception e) {
            e.printStackTrace();
		}
		finally{
			try {
				stm.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return r;
	}
	
	/**
	 * função de deleção que recebe uma variavek do tipo cliente
	 */

	@Override
	public int delete(Cliente arg1) {
		int r = 0;
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			Class.forName(SQL_DRIVER);
			conn = DriverManager.getConnection(SQL_URL, SQL_USER,SQL_PASS);

			stm = conn.prepareStatement(SQL_DELETE);
			stm.setInt(1, arg1.getId());
			
			r = stm.executeUpdate();
	
		} catch (Exception e) {
            e.printStackTrace();
		}
		finally{
			try {
				stm.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return r;
	}
	
	/**
	 * função de seleção que recebe uma varivael do tipo cliente
	 */
	@Override
	public Cliente select(int cpf) {
		
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente c = new Cliente();
		
		try {
			Class.forName(SQL_DRIVER);
			conn = DriverManager.getConnection(SQL_URL, SQL_USER,SQL_PASS);

			stm = conn.prepareStatement(SQL_SELECT);
			stm.setInt(1, cpf);
		
			rs = stm.executeQuery();
			
			if(rs.next()){
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("name"));
				c.setEndereco(rs.getString("endereco"));
				c.setCpf(rs.getInt("cpf"));				
			}
			
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return c;
	}

	@Override
	public Collection<Cliente> select() {
		
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		Collection<Cliente> list = new ArrayList<Cliente>();
	
		try {
			Class.forName(SQL_DRIVER);
			conn = DriverManager.getConnection(SQL_URL, SQL_USER,SQL_PASS);

			stm = conn.prepareStatement(SQL_SELECTALL);
		
		
			rs = stm.executeQuery();
			
			while(rs.next()){
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("name"));
				c.setEndereco(rs.getString("endereco"));
				c.setCpf(rs.getInt("cpf"));
					
				list.add(c);
			}
			
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}