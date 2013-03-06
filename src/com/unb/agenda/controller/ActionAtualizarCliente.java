package com.unb.agenda.controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;
import com.unb.agenda.view.JFrameCliente;

public class ActionAtualizarCliente {
	
	public void atualizarCliente(JTextField[] text){
		
		
		Cliente cliente = new Cliente();
		
		try {
			
			cliente.setNome(text[0].getText());
			cliente.setEndereco(text[1].getText());
			cliente.setCpf(Integer.parseInt(text[2].getText()));
			cliente.setId(Integer.parseInt(text[3].getText()));

			AbstractDAO<Cliente> db= new ClienteDAO();

			int result = db.update(cliente);
			
			if (result == 1) {
				
				JFrameCliente jframe= new JFrameCliente();
				jframe.montaClientes();
				String msg_corpo = "O Cliente foi Atuaizado!";
				String msg_titulo = "OK...";
				int msg_tipo = JOptionPane.INFORMATION_MESSAGE;
				
				JOptionPane.showMessageDialog(null, msg_corpo, msg_titulo,
						msg_tipo);
			}
			else{
				
			}
			
		} catch( IllegalArgumentException e) {
		
			String msg_corpo = "Erro ao Atualizar um Cliente";
			String msg_titulo = "Erro...";
			int msg_tipo = JOptionPane.ERROR_MESSAGE;
			
			JOptionPane.showMessageDialog(null, msg_corpo, msg_titulo,
					msg_tipo);
		}
		
	}

}
