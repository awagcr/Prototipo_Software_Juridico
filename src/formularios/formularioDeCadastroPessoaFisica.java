package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;

public class formularioDeCadastroPessoaFisica extends formularioBase {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=174,189
	 */
	private final JFormattedTextField textFieldDataDeNascimento = new JFormattedTextField();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioDeCadastroPessoaFisica frame = new formularioDeCadastroPessoaFisica();
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
	public formularioDeCadastroPessoaFisica() {
	
		textFieldDataDeNascimento.setVisible(true);
	}

}
