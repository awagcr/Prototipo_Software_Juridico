package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class formularioBase extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPFCNPJ;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereco;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	
	private boolean ehNovoCliente;
	protected boolean EhNovoCliente() {
		return ehNovoCliente;
	}

	protected void setNovoCliente(boolean ehNovoCliente) {
		this.ehNovoCliente = ehNovoCliente;
	}

	/**
	 * Create the frame.
	 */
	public formularioBase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setBounds(228, 16, 49, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(15, 81, 132, 14);
		
		JLabel cpfLabel = new JLabel("CPF");
		cpfLabel.setBounds(332, 81, 89, 14);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(15, 101, 299, 20);
		textFieldNome.setColumns(10);
		
		textFieldCPFCNPJ = new JTextField();
		textFieldCPFCNPJ.setBounds(332, 101, 142, 20);
		textFieldCPFCNPJ.setColumns(10);
		
		JLabel telefoneLabel = new JLabel("Telefone");
		telefoneLabel.setBounds(15, 183, 132, 14);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(165, 183, 89, 14);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(15, 203, 132, 20);
		textFieldTelefone.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(165, 203, 161, 20);
		textFieldEmail.setColumns(10);
		
		JLabel enderecoLabel = new JLabel("Endere\u00E7o");
		enderecoLabel.setBounds(15, 234, 45, 14);
		enderecoLabel.setBackground(new Color(240, 240, 240));
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(15, 259, 449, 20);
		textFieldEndereco.setColumns(10);
		
		JLabel CEPLabel = new JLabel("CEP");
		CEPLabel.setBounds(15, 297, 132, 14);
		
		JLabel cidadeLabel = new JLabel("Cidade");
		cidadeLabel.setBounds(153, 297, 89, 14);
		
		JLabel lblNewLabel_5 = new JLabel("Estado");
		lblNewLabel_5.setBounds(309, 297, 33, 14);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(153, 317, 138, 20);
		textFieldCidade.setColumns(10);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(309, 317, 130, 20);
		textFieldEstado.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(242, 355, 63, 23);
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!EhNovoCliente()) {
					JOptionPane.showConfirmDialog(btnSalvar, "Confirma alteração?", "Alterar cadastro", JOptionPane.YES_NO_OPTION);
				}
				
			}
		});
		
		JFormattedTextField textFieldCEP = new JFormattedTextField();
		textFieldCEP.setBounds(15, 317, 109, 20);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(323, 355, 63, 23);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento");
		lblNewLabel_2.setBounds(15, 132, 96, 14);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(15, 152, 96, 20);
		
		JLabel lblNewLabel_3 = new JLabel("Consulte");
		lblNewLabel_3.setBounds(15, 45, 42, 14);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(75, 41, 30, 22);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(404, 355, 75, 23);
		
		JButton btnCriar = new JButton("Novo");
		btnCriar.setBounds(156, 355, 57, 23);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_3);
		contentPane.add(comboBox);
		contentPane.add(cpfLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textFieldNome);
		contentPane.add(textFieldCPFCNPJ);
		contentPane.add(telefoneLabel);
		contentPane.add(emailLabel);
		contentPane.add(textFieldTelefone);
		contentPane.add(textFieldEmail);
		contentPane.add(enderecoLabel);
		contentPane.add(textFieldEndereco);
		contentPane.add(CEPLabel);
		contentPane.add(textFieldCEP);
		contentPane.add(textFieldCidade);
		contentPane.add(cidadeLabel);
		contentPane.add(lblNewLabel_5);
		contentPane.add(textFieldEstado);
		contentPane.add(formattedTextField);
		contentPane.add(lblNewLabel_2);
		contentPane.add(btnCriar);
		contentPane.add(btnSalvar);
		contentPane.add(btnExcluir);
		contentPane.add(btnCancelar);
		contentPane.add(lblNewLabel);
	}
}