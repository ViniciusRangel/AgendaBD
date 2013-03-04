package com.unb.agenda.controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;

public class ActionConsultarCliente {
	
	public void consultarCliente(JTextField text,JTable table ){
		try {
			Cliente c =new Cliente();
			
			AbstractDAO<Cliente> db= new ClienteDAO();
			c =db.select(Integer.parseInt(text.getText()));	
					
			DefaultTableModel model= (DefaultTableModel) table.getModel();
				
			model.setNumRows(0);
			
			model.addRow(new Object[]{c.getId(),c.getNome(),c.getEndereco(),c.getCpf()});
			
		} catch (IllegalArgumentException e) {
			
			String msg_corpo = "informe um cpf valido ";
			String msg_titulo = "Erro...";
			int msg_tipo = JOptionPane.ERROR_MESSAGE;
			
			JOptionPane.showMessageDialog(null, msg_corpo, msg_titulo,msg_tipo);
		}
		
					
		
	}

}
