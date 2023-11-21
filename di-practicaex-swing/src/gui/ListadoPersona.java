package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ListadoPersona extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtFiltro;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnVolver;
	public DefaultTableModel modelo;
	TableRowSorter<TableModel> rowSorter;

	/**
	 * Create the frame.
	 */
	public ListadoPersona() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 160);
		contentPane.add(scrollPane);

		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Edad" });

		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);

		rowSorter = new TableRowSorter<>(modelo);
		table.setRowSorter(rowSorter);

		txtFiltro = new JTextField();
		txtFiltro.setBounds(121, 230, 86, 20);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);

		lblNewLabel = new JLabel("Filtrar");
		lblNewLabel.setBounds(10, 233, 46, 14);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("filtra");
		btnNewButton.setBounds(335, 229, 89, 23);
		contentPane.add(btnNewButton);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolverPressed();
			}
		});
		btnVolver.setBounds(335, 195, 89, 23);
		contentPane.add(btnVolver);
	}

	/**
	 * 
	 */
	protected void btnFiltrarPressed() {
		String text = txtFiltro.getText();
		if (text.length() == 0) {
			rowSorter.setRowFilter(null);
		} else {
			rowSorter.setRowFilter(RowFilter.regexFilter(text));
		}
	}

	protected void btnVolverPressed() {

		this.setVisible(false);

	}
}
