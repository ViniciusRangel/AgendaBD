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
import com.unb.agenda.controller.ActionMontarCliente;
import com.unb.agenda.controller.ActionSalvarCliente;
import com.unb.agenda.controller.ActionSelecionarCliente;
import com.unb.agenda.model.dao.AbstractDAO;
import com.unb.agenda.model.dao.ClienteDAO;
import com.unb.agenda.model.vo.Cliente;

import javax.swing.JComboBox;

public class JFrameCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nome;
	private JTextField textField_Endereco;
	private JTextField textField_Cpf;
	private JTextField textField_ID;
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
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 57, 46, 14);
		panel_2.add(lblId);
				JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereco.setBounds(10, 128, 62, 14);
		panel_2.add(lblEndereco);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 164, 46, 14);
		panel_2.add(lblCpf);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCliente.setBounds(10, 26, 46, 14);
		panel_2.add(lblCliente);
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(66, 85, 388, 20);
		panel_2.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		textField_Endereco = new JTextField();
		textField_Endereco.setBounds(66, 125, 388, 20);
		panel_2.add(textField_Endereco);
		textField_Endereco.setColumns(10);
		
		textField_Cpf = new JTextField();
		textField_Cpf.setBounds(66, 161, 388, 20);
		panel_2.add(textField_Cpf);
		textField_Cpf.setColumns(10);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(66, 54, 388, 20);
		panel_2.add(textField_ID);
		textField_ID.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 88, 46, 14);
		panel_2.add(lblNome);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_Nome.setText("");
				textField_Endereco.setText("");
				textField_Cpf.setText("");
				textField_ID.setText("");
			}
		});
		btnLimpar.setBounds(387, 299, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextField[] text= new JTextField[3];
				text[0]=textField_Nome;
				text[1]=textField_Endereco;
				text[2]=textField_Cpf;
				
				ActionSalvarCliente criador =new ActionSalvarCliente();
				criador.salvaContato(text);
				
				textField_Nome.setText("");
				textField_Endereco.setText("");
				textField_Cpf.setText("");
				textField_ID.setText("");
			}
		});
		btnSalvar.setBounds(31, 299, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ActionDeletarCliente deletar = new ActionDeletarCliente();
				deletar.deletarCliente(textField_ID);
				
				textField_Nome.setText("");
				textField_Endereco.setText("");
				textField_Cpf.setText("");
				textField_ID.setText("");
			}
		});
		btnDeletar.setBounds(147, 299, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextField[] text= new JTextField[4];
				text[0]=textField_Nome;
				text[1]=textField_Endereco;
				text[2]=textField_Cpf;
				text[3]=textField_ID;
				
				ActionAtualizarCliente criador =new ActionAtualizarCliente();
				criador.atualizarCliente(text);
				
				textField_Nome.setText("");
				textField_Endereco.setText("");
				textField_Cpf.setText("");
				textField_ID.setText("");
				
			}
		});
		btnAtualizar.setBounds(269, 299, 89, 23);
		contentPane.add(btnAtualizar);
		
		comboBox = new JComboBox();		
		
		montaClientes();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comb = (JComboBox) e.getSource();
				
				JTextField[] text= new JTextField[4];
				text[0]=textField_Nome;
				text[1]=textField_Endereco;
				text[2]=textField_Cpf;
				text[3]=textField_ID;
				
				ActionSelecionarCliente criador =new ActionSelecionarCliente();
				criador.selecionarCliente(text, comb);

				
			}
		});
		comboBox.setBounds(66, 23, 388, 20);
		panel_2.add(comboBox);						
				
	}
	
	public void montaClientes() {
		
		ActionMontarCliente montar = new ActionMontarCliente();
		montar.montar(comboBox);
	}
	
}
