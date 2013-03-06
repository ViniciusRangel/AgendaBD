package com.unb.agenda.controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;
import com.unb.agenda.view.JFrameCliente;

public class ActionDeletarCliente {
	
	public void deletarCliente(JTextField text){
		
		
		try {
			Cliente c = new Cliente();
			c.setId(Integer.parseInt(text.getText()));

			AbstractDAO<Cliente> db= new ClienteDAO();

			int result = db.delete(c);

			if (result == 1) {
				
				JFrameCliente jframe= new JFrameCliente();
				jframe.montaClientes();
			
				String msg_corpo = "O Cliente foi Deletado!";
				String msg_titulo = "OK...";
				int msg_tipo = JOptionPane.INFORMATION_MESSAGE;
				
				JOptionPane.showMessageDialog(null, msg_corpo, msg_titulo,msg_tipo);
			}
			
		} catch (IllegalArgumentException e) {
			
			String msg_corpo = "Erro ao Deletar um Cliente";
			String msg_titulo = "Erro...";
			int msg_tipo = JOptionPane.ERROR_MESSAGE;
			
			JOptionPane.showMessageDialog(null, msg_corpo, msg_titulo,msg_tipo);
		}
				
	}

}
