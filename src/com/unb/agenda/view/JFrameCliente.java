package com.unb.agenda.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.unb.agenda.controller.ActionAtualizarCliente;
import com.unb.agenda.controller.ActionDeletarCliente;
import com.unb.agenda.controller.ActionSalvarCliente;
import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;

import javax.swing.JComboBox;

public class JFrameCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameCliente frame = new JFrameCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 535, 49);
		contentPane.add(panel);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblCadastroCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 341, 535, 21);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Dados Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(21, 75, 466, 213);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNome = new JLabel("ID");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 57, 46, 14);
		panel_2.add(lblNome);
				JLabel lblNewLabel = new JLabel("Endereco");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 128, 62, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 164, 46, 14);
		panel_2.add(lblCpf);
		
		textField = new JTextField();
		textField.setBounds(66, 85, 388, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 125, 388, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 161, 388, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 54, 388, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("Nome");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 88, 46, 14);
		panel_2.add(label);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnLimpar.setBounds(387, 299, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextField[] text= new JTextField[3];
				text[0]=textField;
				text[1]=textField_1;
				text[2]=textField_2;
				
				ActionSalvarCliente criador =new ActionSalvarCliente();
				criador.salvaContato(text);
			}
		});
		btnSalvar.setBounds(31, 299, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ActionDeletarCliente deletar = new ActionDeletarCliente();
				deletar.deletarCliente(textField_3);
			}
		});
		btnDeletar.setBounds(147, 299, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextField[] text= new JTextField[4];
				text[0]=textField;
				text[1]=textField_1;
				text[2]=textField_2;
				text[3]=textField_3;
				
				ActionAtualizarCliente criador =new ActionAtualizarCliente();
				criador.atualizarCliente(text);
				
			}
		});
		btnAtualizar.setBounds(269, 299, 89, 23);
		contentPane.add(btnAtualizar);
		
		comboBox = new JComboBox();		
		
		montaClientes();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comb = (JComboBox) e.getSource();

				if (comb.getSelectedIndex() != -1) {
					Cliente cliente = (Cliente) comb.getSelectedItem();
					
					AbstractDAO<Cliente> db = new ClienteDAO();

					Cliente c = db.select(cliente.getId());

					textField_3.setText(String.valueOf(c.getId()));
					textField.setText(c.getNome());
					textField_1.setText(c.getEndereco());
					textField_2.setText(String.valueOf(c.getCpf()));
					
				}
			}
		});
		comboBox.setBounds(66, 23, 388, 20);
		panel_2.add(comboBox);						
	}
	
	public void montaClientes() {
		
		AbstractDAO<Cliente> db = new ClienteDAO();
        Collection<Cliente>  list =db.select();
		 
        comboBox.removeAllItems();
        
		 for (Cliente cliente : list) {
			  comboBox.addItem(cliente);
		 } 
	}
	
}
