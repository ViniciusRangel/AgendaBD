package com.unb.agenda.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;

public class ActionCriarContato {
	
	public void salvaContato(JTextField[] text) {
		// TODO Auto-generated method stub
		
		Cliente c= new Cliente();
		
		c.setNome(text[0].getText());
		c.setEndereco(text[1].getText());
		c.setCpf(Integer.parseInt(text[2].getText()));
		
		AbstractDAO<Cliente> db= new ClienteDAO();
		
		int r = db.insert(c);
		
		String msg_corpo = "Erro ao criar um CLIENTE";
		String msg_titulo = "Erro...";
		int msg_tipo = JOptionPane.ERROR_MESSAGE;

		if (r == 1) {
			msg_corpo = "O contato foi criado!";
			msg_titulo = "OK...";
			msg_tipo = JOptionPane.INFORMATION_MESSAGE;
		}

		JOptionPane.showMessageDialog(null, msg_corpo, msg_titulo,msg_tipo);
		
	}

}
