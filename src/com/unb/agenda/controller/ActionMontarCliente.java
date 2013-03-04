package com.unb.agenda.controller;

import java.util.Collection;

import javax.swing.JComboBox;

import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;

public class ActionMontarCliente {
	
		
	public void montar(JComboBox comboBox){
	
		AbstractDAO<Cliente> db = new ClienteDAO();
        Collection<Cliente>  list =db.select();
		 
        comboBox.removeAllItems();
        
		 for (Cliente cliente : list) {
			  comboBox.addItem(cliente);
		 } 
	
	}
}
