package com.unb.agenda.controller;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;

public class ActionSelecionarCliente {
	
	public void selecionarCliente(JTextField[] text, JComboBox comb){
		
			
			if (comb.getSelectedIndex() != -1) {
				Cliente cliente = (Cliente) comb.getSelectedItem();
				
				AbstractDAO<Cliente> db = new ClienteDAO();

				Cliente c = db.select(cliente.getId());

				text[3].setText(String.valueOf(c.getId()));
				text[0].setText(c.getNome());
				text[1].setText(c.getEndereco());
				text[2].setText(String.valueOf(c.getCpf()));
				
			}		
	}

}
