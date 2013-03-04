package com.unb.agenda.controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;

public class ActionSalvarCliente {

	public void salvaContato(JTextField[] text) {
		// TODO Auto-generated method stub
		
		Cliente c= new Cliente();
		
		c.setNome(text[0].getText());
		c.setEndereco(text[1].getText());
		
		try {
			c.setCpf(Integer.parseInt(text[2].getText()));
			
			AbstractDAO<Cliente> db= new ClienteDAO();
			
			int r = db.insert(c);
	
			if (r == 1) {
				String msg_corpo = "O Cliente foi criado!";
				String msg_titulo = "OK...";
				int msg_tipo = JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog(null, msg_corpo, msg_titulo,msg_tipo);
			}
			
		} catch (IllegalArgumentException e) {
			
			String msg_corpo = "Erro ao criar um Cliente";
			String msg_titulo = "Erro...";
			int msg_tipo = JOptionPane.ERROR_MESSAGE;
			
			JOptionPane.showMessageDialog(null, msg_corpo, msg_titulo,msg_tipo);
			
		}
				
	}
}
