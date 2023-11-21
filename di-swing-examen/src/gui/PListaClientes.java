package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dto.User;
import main.GymPicassoMain;

public class PListaClientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	DefaultTableModel modelo;
	List<User> clientes = new ArrayList<>();
	private JTextField txtApellidosFiltro;
	private JButton btnFiltrar;
	private TableRowSorter<DefaultTableModel> rowSorter;

	/**
	 * Create the dialog.
	 */
	public PListaClientes() {
		setResizable(false);

		getClientes();

		setBounds(100, 100, 823, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 128, 255));
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Listar Clientes");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panelCentral = new JPanel();
			contentPanel.add(panelCentral, BorderLayout.CENTER);
			panelCentral.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 797, 346);
			panelCentral.add(scrollPane);

			iniciaTabla(scrollPane);
		}
		{
			JPanel panelBajo = new JPanel();
			contentPanel.add(panelBajo, BorderLayout.SOUTH);
			panelBajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblFiltra = new JLabel("Apellido");
				panelBajo.add(lblFiltra);
			}
			{
				txtApellidosFiltro = new JTextField();
				panelBajo.add(txtApellidosFiltro);
				txtApellidosFiltro.setColumns(20);
			}
			{
				btnFiltrar = new JButton("Filtrar");
				btnFiltrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnFiltrarPressed();
					}
				});
				panelBajo.add(btnFiltrar);
			}
		}
	}

	private void getClientes() {
		for (User u : GymPicassoMain.users) {
			if (u.getPerfil().equals("Cliente")) {
				clientes.add(u);
			}
		}
	}

	/**
	 * Inicia la tabla
	 * 
	 * @param scrollPane
	 */
	private void iniciaTabla(JScrollPane scrollPane) {

		modelo = new DefaultTableModel();

		table = new JTable();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Fecha de Nacimiento");
		modelo.addColumn("Email");

		scrollPane.setViewportView(table);

		// Añade filas con datos de clientes
		for (User user : clientes) {

			// Formatea la fecha
			SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
			String fechaFormateada = formato.format(user.getFechaNacimiento());

			Object[] fila = { user.getNombre(), user.getApellidos(), fechaFormateada, user.getEmail() };
			modelo.addRow(fila);
		}
		rowSorter = new TableRowSorter<>(modelo);
		table.setRowSorter(rowSorter);

		table.setModel(modelo);

	}

	/**
	 * Filtra por apellidos
	 */
	protected void btnFiltrarPressed() {

		int apellidoColumn = 1;

		RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter((String) txtApellidosFiltro.getText(),
				apellidoColumn);

		rowSorter.setRowFilter(rowFilter);
	}
}
