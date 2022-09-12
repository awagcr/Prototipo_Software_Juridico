package formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.ConexaoBancoDeDados;

public class janelaDeConsultaPJ extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			janelaDeConsultaPJ dialog = new janelaDeConsultaPJ();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	private Vector<String> getNameColumns() {
		Vector<String> nameColumns = new Vector<String>();
		nameColumns.add("Razão Social");
		nameColumns.add("CNPJ");
		nameColumns.add("Resposável Legal");
		nameColumns.add("Telefone");
		nameColumns.add("Email");
		return nameColumns;
	}
	
	private Vector<Vector<Object>> getDataColumns() {
		ConexaoBancoDeDados connection = new ConexaoBancoDeDados();
		Vector<Vector<Object>> dataColumns = null;
		
		try {
//			dataColumns = connection.getEventos(); -> precisa de um metodo getEventos() em ConexaoBancoDeDados
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(),
			JOptionPane.ERROR_MESSAGE);
		}
		
		return dataColumns;
	}
	
	public void addNewRow(Object[] valores) {
		((DefaultTableModel)table.getModel()).addRow(valores);
	}
	
	public janelaDeConsultaPJ() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						janelaDeConsultaPJ.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			setLayout(new BorderLayout(0, 0));
			
			table = new JTable(getDataColumns(), getNameColumns());
			JScrollPane scrollPane = new JScrollPane(table);
			add(scrollPane, BorderLayout.CENTER);
		}
	}

}
