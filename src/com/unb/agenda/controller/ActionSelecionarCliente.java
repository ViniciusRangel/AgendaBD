package com.unb.agenda.controller;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;

public class ActionSelecionarCliente {
	
	public void selecionarCliente(JTextField[] text, JComboBox<?> comb){
		
			
			if (comb.getSelectedIndex() != -1) {
				Cliente cliente = (Cliente) comb.getSelectedItem();
				
				AbstractDAO<Cliente> db = new ClienteDAO();

				Cliente cliente1 = db.select(cliente.getId());

				text[3].setText(String.valueOf(cliente1.getId()));
				text[0].setText(cliente1.getNome());
				text[1].setText(cliente1.getEndereco());
				text[2].setText(String.valueOf(cliente1.getCpf()));
				
			}else{
				
			}		
	}

}
