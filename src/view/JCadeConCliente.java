package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JCadeConCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadeConCliente frame = new JCadeConCliente();
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
	public JCadeConCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 375);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 489, 44);
		contentPane.add(panel);
		
		JLabel lblConsultaCliente = new JLabel("Consulta Cliente");
		lblConsultaCliente.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel.add(lblConsultaCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 306, 489, 31);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(29, 125, 437, 115);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBounds(10, 26, 417, 64);
		panel_2.add(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setForeground(Color.GRAY);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBackground(Color.WHITE);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(30, 71, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(79, 68, 387, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con;
					
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/agenda","root","root");
					
					String query ="SELECT * FROM cliente where name=?";
					
					PreparedStatement cmd;
					
					cmd = con.prepareStatement(query);
					
					cmd.setString(1,textField.getText());
					
					ResultSet rs;
					
					rs= cmd.executeQuery();
					
					DefaultTableModel model= (DefaultTableModel) table.getModel();
					
					model.setNumRows(0);
					
					while(rs.next()){
						model.addRow(new Object[]{rs.getString("id"),rs.getString("name"),rs.getString("endereco"),rs.getString("cpf")});
					}
					
				} catch (ClassNotFoundException e1) {
					
					System.out.println("não foi possivel encontrar a classe");
				} catch (SQLException e) {
					System.out.println("Ocorreu um erro de" + e.getMessage());
				} 
			}
		});
		btnNewButton.setBounds(332, 261, 89, 23);
		contentPane.add(btnNewButton);
	}
}
