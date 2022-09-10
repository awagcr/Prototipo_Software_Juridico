package formularios;

import javax.swing.JFrame;

import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JPanel;

import dominio.PessoaJuridica;
import dominio.PessoaNatural;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.text.ParseException;

public class janelaDeCadastroPJ extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldRazãoSocial;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereco;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	
	private boolean ehNovoCliente;
	private JTextField textFieldRespLegal;
	protected boolean EhNovoCliente() {
		return ehNovoCliente;
	}

	protected void setNovoCliente(boolean ehNovoCliente) {
		this.ehNovoCliente = ehNovoCliente;
	}

	/**
	 * Create the frame.
	 */
	public janelaDeCadastroPJ() {
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBackground(new Color(240, 240, 240));
		
		JLabel lblRazãoSocial = new JLabel("Razão Social");
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		JLabel lblEmail = new JLabel("E-mail");
		
		JLabel lblCEP = new JLabel("CEP");
		
		JLabel lblCidade = new JLabel("Cidade");
		
		JLabel lblEstado = new JLabel("Estado");
		
		JLabel lblConsultar = new JLabel("Consulte");
		
		JLabel lblRespLegal = new JLabel("Responsável Legal");
		
		textFieldRazãoSocial = new JTextField();
		textFieldRazãoSocial.setColumns(10);
		pessoaJuridica.setRazaoSocial(textFieldRazãoSocial.getText());
		
		textFieldRespLegal = new JTextField();
		textFieldRespLegal.setColumns(10);
		pessoaJuridica.setResponsavelLegal(textFieldRespLegal.getText());
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		
		MaskFormatter mascaraCNPJ = null;
		MaskFormatter mascaraTel = null;
		MaskFormatter mascaraCEP = null;
		
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTel = new MaskFormatter("(##)#####-####");
			mascaraCEP = new MaskFormatter("#####-###");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}

		JFormattedTextField formattedTextFieldCNPJ = new JFormattedTextField(mascaraCNPJ);
		pessoaJuridica.setCNPJ(Integer.parseInt(formattedTextFieldCNPJ.getText()));

		JFormattedTextField formattedTextFieldTel = new JFormattedTextField(mascaraTel);

		JFormattedTextField formattedTextFieldCEP = new JFormattedTextField(mascaraCEP);
		
		JButton btnCriar = new JButton("Novo");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!EhNovoCliente())
				{
					JOptionPane confimaAlteracao = new JOptionPane();
					confimaAlteracao.showConfirmDialog(btnSalvar, "Confirma alteração?", "Alterar cadastro", JOptionPane.YES_NO_OPTION);
				}
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaDeCadastroPJ.this.dispose();
			}
		});
		
		JComboBox comboBox = new JComboBox();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblConsultar)
									.addGap(18)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(317)
									.addComponent(lblCNPJ, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblRazãoSocial, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereco)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(formattedTextFieldCEP)
										.addComponent(lblCEP, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldCidade, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEstado)
										.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblRespLegal)
								.addComponent(textFieldRespLegal, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldRazãoSocial, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(formattedTextFieldCNPJ, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
								.addComponent(textFieldEndereco)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(formattedTextFieldTel)
										.addComponent(lblTelefone, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(215)
							.addComponent(lblClientes)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(200, Short.MAX_VALUE)
					.addComponent(btnCriar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblClientes)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsultar)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRazãoSocial)
						.addComponent(lblCNPJ))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldRazãoSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextFieldCNPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRespLegal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldRespLegal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextFieldTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEndereco)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCEP)
						.addComponent(lblCidade)
						.addComponent(lblEstado))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextFieldCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnSalvar)
						.addComponent(btnCriar))
					.addGap(77))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
