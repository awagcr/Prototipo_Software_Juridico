package formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import persistencia.ConexaoBancoDeDados;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class janelaDeConsultaPF extends JDialog {

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
			janelaDeConsultaPF dialog = new janelaDeConsultaPF();
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
		nameColumns.add("Nome");
		nameColumns.add("CPF");
		nameColumns.add("Data de Nascimento");
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
	
	public janelaDeConsultaPF() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		{
			getContentPane().setLayout(new BorderLayout(0, 0));
			
			table = new JTable(getDataColumns(), getNameColumns());
			JScrollPane scrollPane = new JScrollPane(table);
			getContentPane().add(scrollPane, BorderLayout.CENTER);
		}
	}

}
