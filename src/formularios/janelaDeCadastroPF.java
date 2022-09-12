package formularios;

import javax.swing.border.EmptyBorder;
//import javax.swing.text.MaskFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dominio.PessoaNatural;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
//import javax.swing.JFormattedTextField;
//import javax.swing.AbstractButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.io.FileWriter;

//import java.text.ParseException;


public class janelaDeCadastroPF extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfEndereco;
	private JTextField tfCidade;
	private JTextField tfEstado;	
	private JTextField tfCPF;
	private JTextField tfDate;
	private JTextField tfTel;
	private JTextField tfCEP;
//	private AbstractButton ftdCPF;
//	private AbstractButton ftdDate;
//	private AbstractButton ftdTel;
//	private AbstractButton ftdCEP;
	private boolean ehNovoCliente;
	
	protected boolean EhNovoCliente() {
		return ehNovoCliente;
	}

	protected void setNovoCliente(boolean ehNovoCliente) {
		this.ehNovoCliente = ehNovoCliente;
	}
	
	public void limparCadastro() {
		PessoaNatural pessoaFisica = new PessoaNatural();
		tfNome.setText("");
		tfEmail.setText("");
		tfEndereco.setText("");
		tfCidade.setText("");
		tfEstado.setText("");
		tfCPF.setText(String.valueOf(pessoaFisica.getCPF()));
		tfDate.setText(String.valueOf(pessoaFisica.getDataDeNascimento()));
		tfTel.setText(String.valueOf(pessoaFisica.getTelefone()));
		tfCEP.setText(String.valueOf(pessoaFisica.getCEP()));
//		ftdCPF.setText("");
//		ftdDate.setText("");
//		ftdTel.setText("");
//		ftdCEP.setText("");
	}

	/**
	 * Create the frame.
	 */
	public janelaDeCadastroPF() {
		
		PessoaNatural pessoaFisica = new PessoaNatural();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(213, 16, 49, 19);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(15, 234, 75, 14);
		lblEndereco.setBackground(new Color(240, 240, 240));
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(15, 132, 120, 14);
		
		JLabel lblConsultar = new JLabel("Consulte");
		lblConsultar.setBounds(15, 45, 75, 14);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(15, 183, 132, 14);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(321, 297, 63, 14);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(165, 297, 89, 14);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(165, 183, 89, 14);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(15, 81, 132, 14);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(332, 81, 89, 14);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(15, 297, 132, 14);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(15, 259, 449, 20);
		tfEndereco.setColumns(10);
		pessoaFisica.setEndereco(tfEndereco.getText());
		
		tfEstado = new JTextField();
		tfEstado.setBounds(321, 317, 143, 20);
		tfEstado.setColumns(10);
		pessoaFisica.setEstado(tfEstado.getText());
		
		tfCidade = new JTextField();
		tfCidade.setBounds(165, 317, 138, 20);
		tfCidade.setColumns(10);
		pessoaFisica.setCidade(tfCidade.getText());
		
		tfEmail = new JTextField();
		tfEmail.setBounds(165, 203, 161, 20);
		tfEmail.setColumns(10);
		pessoaFisica.setEmail(tfEmail.getText());
		
		tfNome = new JTextField();
		tfNome.setBounds(15, 101, 299, 20);
		tfNome.setColumns(10);
		pessoaFisica.setNome(tfNome.getText());
		
		try {
			tfCPF = new JTextField();
			tfCPF.setBounds(332, 101, 132, 20);
			tfCPF.setColumns(10);
			pessoaFisica.setCPF(Integer.parseInt(tfCPF.getText()));
			
			tfDate = new JTextField();
			tfDate.setBounds(15, 152, 120, 20);
			tfDate.setColumns(10);
			pessoaFisica.setDataDeNascimento(Integer.parseInt(tfDate.getText()));
			
			tfTel = new JTextField();
			tfTel.setBounds(15, 203, 140, 20);
			tfTel.setColumns(10);
			pessoaFisica.setTelefone(Integer.parseInt(tfTel.getText()));
			
			tfCEP = new JTextField();
			tfCEP.setBounds(15, 317, 126, 20);
			tfCEP.setColumns(10);
			pessoaFisica.setCEP(Integer.parseInt(tfCEP.getText()));
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormat Exception: invalid input string");
		}
		
		
//		MaskFormatter mascaraDate = null;
//		MaskFormatter mascaraCPF = null;
//		MaskFormatter mascaraTel = null;
//		MaskFormatter mascaraCEP = null;
//		
//		try {
//			mascaraDate = new MaskFormatter("##/##/####");
//			mascaraCPF = new MaskFormatter("###.###.###-##");
//			mascaraTel = new MaskFormatter("(##)#####-####");
//			mascaraCEP = new MaskFormatter("#####-###");
//		} catch (ParseException excp) {
//			System.err.println("Erro na formatação: " + excp.getMessage());
//			System.exit(-1);
//		}
//		
//		JFormattedTextField ftdDate = new JFormattedTextField(mascaraDate);
//		ftdDate.setBounds(15, 152, 122, 20);
//		pessoaFisica.setDataDeNascimento(Integer.parseInt(ftdDate.getText()));
//		
//		JFormattedTextField ftdCPF = new JFormattedTextField(mascaraCPF);
//		ftdCPF.setBounds(332, 101, 149, 20);
//		pessoaFisica.setCPF(Integer.parseInt(ftdCPF.getText()));
//		
//		JFormattedTextField ftdTel = new JFormattedTextField(mascaraTel);
//		ftdTel.setBounds(15, 203, 132, 20);
//		pessoaFisica.setTelefone(Integer.parseInt(ftdTel.getText()));
//		
//		JFormattedTextField ftdCEP = new JFormattedTextField(mascaraCEP);
//		ftdCEP.setBounds(15, 317, 120, 20);
//		pessoaFisica.setCEP(Integer.parseInt(ftdCEP.getText()));
		
		JButton btnCriar = new JButton("Novo");
		btnCriar.setBounds(87, 355, 89, 23);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCadastro();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(186, 355, 89, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s1 = tfNome.getText();
				String s2 = tfEmail.getText();
				String s3 = tfEndereco.getText();
				String s4 = tfCidade.getText();
				String s5 = tfEstado.getText();
//				String s6 = tfCPF.getText();
//				String s7 = tfDate.getText();
//				String s8 = tfTel.getText();
//				String s9 = tfCEP.getText();
//				String s6 = ftdCPF.getText();
//				String s7 = ftdDate.getText();
//				String s8 = ftdTel.getText();
//				String s9 = ftdCEP.getText();
//				
				if(e.getSource() == btnSalvar) {
					try {
						FileWriter w = new FileWriter("ClientePF.txt", true);
						
						w.write(s1 + "\n");
						w.write(s2 + "\n");
						w.write(s3 + "\n");
						w.write(s4 + "\n");
						w.write(s5 + "\n");
//						w.write(s6 + "\n");
//						w.write(s7 + "\n");
//						w.write(s8 + "\n");
//						w.write(s9 + "\n");
						w.close();
					} catch (Exception ae) {
						System.out.println(ae);
					}

					JOptionPane.showConfirmDialog(btnSalvar, "Confirma alteração?", "Alterar cadastro", JOptionPane.YES_NO_OPTION);
				}
//				if(!EhNovoCliente()) {
//					JOptionPane.showConfirmDialog(btnSalvar, "Confirma alteração?", "Alterar cadastro", JOptionPane.YES_NO_OPTION);
//				}
				limparCadastro();
			}
			
		});
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(285, 355, 87, 23);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(382, 355, 97, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaDeCadastroPF.this.dispose();
			}
		});
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(117, 41, 30, 22);
		contentPane.setLayout(null);
		contentPane.add(lblCPF);
		contentPane.add(lblCEP);
		contentPane.add(lblNome);
		contentPane.add(lblEmail);
		contentPane.add(lblCidade);
		contentPane.add(lblEstado);
		contentPane.add(lblEndereco);
		contentPane.add(lblTelefone);
		contentPane.add(lblClientes);
		contentPane.add(lblConsultar);
		contentPane.add(lblDataDeNascimento);
		contentPane.add(btnCriar);
		contentPane.add(btnSalvar);
		contentPane.add(btnExcluir);
		contentPane.add(btnCancelar);
		contentPane.add(comboBox);
		try {
			contentPane.add(tfCPF);
			contentPane.add(tfDate);
			contentPane.add(tfTel);
			contentPane.add(tfCEP);
		} catch (NullPointerException npe) {
			System.out.println("Erro de NullPointerException");
		}		
		contentPane.add(tfNome);
		contentPane.add(tfEmail);
		contentPane.add(tfCidade);
		contentPane.add(tfEstado);
		contentPane.add(tfEndereco);
//		contentPane.add(ftdCPF);
//		contentPane.add(ftdCEP);
//		contentPane.add(ftdDate);
//		contentPane.add(ftdTel);

	}
}
