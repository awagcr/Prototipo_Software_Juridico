package formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Cliente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class janelaDeConsulta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel textoConsulta;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			janelaDeConsulta dialog = new janelaDeConsulta("Consulta de Clientes");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public janelaDeConsulta(String tipoConsulta) {
		setBounds(100, 100, 328, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		String texto = "";
		if(tipoConsulta.equals("cliente")) {
			texto = "Insira um nome, CPF ou CNPJ para iniciar a consulta";
			try {
				janelaDeConsultaPF consultaPF = new janelaDeConsultaPF();
				consultaPF.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				consultaPF.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			texto = "Insira o número do processo para iniciar a consulta";
			janelaDeConsultaPJ consultaPJ = new janelaDeConsultaPJ();
			consultaPJ.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			consultaPJ.setVisible(true);
		}

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			textoConsulta = new JLabel(texto);
			textoConsulta.setBounds(127, 10, 68, 0);
		}
		contentPanel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(28, 28, 266, 20);
		textField.setColumns(10);
		contentPanel.add(textField);
		contentPanel.add(textoConsulta);
		{
			JPanel buttonPane = new JPanel(); 
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						janelaDeConsulta.this.dispose();
					}
				});
				

				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
