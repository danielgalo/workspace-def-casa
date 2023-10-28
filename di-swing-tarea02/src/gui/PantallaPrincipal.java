package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JCalendar;

import dao.Cliente;
import utils.ClienteManagement;

public class PantallaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPaneGeneral;
	private JPanel panelClientes;
	private JPanel panelIzquierda;
	private JPanel panelDerecha;
	private JLabel lblNewLabel_1;
	private JPanel panelProductos;
	private JTabbedPane tabbedPaneClientes;
	private JPanel panelAltaCliente;
	private JPanel panelBajaCliente;
	private JPanel panelListadoClientes;
	private JTabbedPane tabbedPaneProductos;
	private JPanel panelAltaProducto;
	private JPanel panelBajaProducto;
	private JPanel panelListarProducto;
	private JTextField txtNombreCliente;
	private JTextField txtApellidosCliente;
	private JTextField txtEdadCliente;
	private JTextField txtNombreClienteElim;
	private JButton btnBajaCliente;
	private JTextField txtApellidosClienteElim;
	private JComboBox<String> cboxProvincias;
	DefaultTableModel model;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel tableClienteModel;
	JCalendar calendar;
	private JCalendar calendarClientes;
	private JButton btnFiltrar;
	private JComboBox cboxFiltros;

	/**
	 * Launch the application.
	 */
	public void runPantallaPrincipal(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
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
	public PantallaPrincipal() {

		ImageIcon logoPicasso = new ImageIcon(PantallaPrincipal.class.getResource("/images/picasso-logo.png"));
		ImageIcon imagenCliente = new ImageIcon(PantallaPrincipal.class.getResource("/images/usuario.png"));
		ImageIcon imagenProducto = new ImageIcon(PantallaPrincipal.class.getResource("/images/product-29.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(logoPicasso);
		panelSuperior.add(lblNewLabel);

		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);

		lblNewLabel_1 = new JLabel("Daniel Galo Vega");
		panelInferior.add(lblNewLabel_1);

		tabbedPaneGeneral = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneGeneral.setToolTipText("sasa");
		contentPane.add(tabbedPaneGeneral, BorderLayout.CENTER);

		iniciaApartadoClientes(imagenCliente);

		panelProductos = new JPanel();
		panelProductos.setBackground(new Color(255, 255, 255));
		panelProductos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPaneGeneral.addTab("Productos", imagenProducto, panelProductos, null);
		panelProductos.setLayout(null);

		tabbedPaneProductos = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneProductos.setBounds(10, 11, 604, 280);
		panelProductos.add(tabbedPaneProductos);

		panelAltaProducto = new JPanel();
		tabbedPaneProductos.addTab("Alta Producto", null, panelAltaProducto, null);

		panelBajaProducto = new JPanel();
		tabbedPaneProductos.addTab("Baja Producto", null, panelBajaProducto, null);

		panelListarProducto = new JPanel();
		tabbedPaneProductos.addTab("Listar Productos", null, panelListarProducto, null);
		tabbedPaneGeneral.setBackgroundAt(1, new Color(255, 255, 255));

		panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);

		panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
	}

	/**
	 * Inicia todos los componentes del panel de clientes
	 * 
	 * @param imagenCliente
	 */
	private void iniciaApartadoClientes(ImageIcon imagenCliente) {
		panelClientes = new JPanel();
		panelClientes.setBackground(new Color(255, 255, 255));
		panelClientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPaneGeneral.addTab("Clientes", imagenCliente, panelClientes, null);
		panelClientes.setLayout(null);

		tabbedPaneClientes = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneClientes.setBounds(10, 11, 604, 280);
		panelClientes.add(tabbedPaneClientes);

		panelAltaCliente = new JPanel();
		tabbedPaneClientes.addTab("Alta Cliente", null, panelAltaCliente, null);

		JLabel lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setBounds(10, 11, 100, 14);

		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(114, 8, 145, 20);
		txtNombreCliente.setColumns(10);

		txtApellidosCliente = new JTextField();
		txtApellidosCliente.setBounds(114, 39, 145, 20);
		txtApellidosCliente.setColumns(10);

		txtEdadCliente = new JTextField();
		txtEdadCliente.setBounds(114, 70, 145, 20);
		txtEdadCliente.setColumns(10);

		JLabel lblApellidosCliente = new JLabel("Apellidos");
		lblApellidosCliente.setBounds(10, 42, 100, 14);

		JLabel lblEdadCliente = new JLabel("Edad:");
		lblEdadCliente.setBounds(10, 73, 100, 14);

		cboxProvincias = new JComboBox<String>();
		cboxProvincias.setBounds(114, 101, 145, 22);
		cboxProvincias.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Málaga", "Sevilla", "Córdoba", "Granada", "Jaén", "Huelva", "Almería", "Cádiz" }));

		JLabel lblProvinciaCliente = new JLabel("Provincia");
		lblProvinciaCliente.setBounds(10, 105, 100, 14);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(277, 8, 312, 155);

		JButton btnAltaCliente = new JButton("Alta");
		btnAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAltaClientePressed();
			}
		});
		btnAltaCliente.setBounds(200, 140, 59, 23);

		calendarClientes = new JCalendar();
		calendarClientes.setBackground(new Color(255, 255, 255));
		calendarClientes.getMonthChooser().setBackground(new Color(255, 255, 255));
		calendarClientes.getYearChooser().setBackground(new Color(255, 255, 255));
		calendarClientes.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(calendarClientes);
		panelAltaCliente.setLayout(null);
		panelAltaCliente.add(lblProvinciaCliente);
		panelAltaCliente.add(cboxProvincias);
		panelAltaCliente.add(lblEdadCliente);
		panelAltaCliente.add(txtEdadCliente);
		panelAltaCliente.add(lblApellidosCliente);
		panelAltaCliente.add(txtApellidosCliente);
		panelAltaCliente.add(lblNombreCliente);
		panelAltaCliente.add(txtNombreCliente);
		panelAltaCliente.add(btnAltaCliente);
		panelAltaCliente.add(scrollPane_1);

		panelBajaCliente = new JPanel();
		tabbedPaneClientes.addTab("Baja Cliente", null, panelBajaCliente, null);
		panelBajaCliente.setLayout(null);

		JLabel lblNombreClienteElim = new JLabel("Introduzca el nombre del cliente a eliminar:");
		lblNombreClienteElim.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreClienteElim.setBounds(10, 44, 579, 14);
		panelBajaCliente.add(lblNombreClienteElim);

		txtNombreClienteElim = new JTextField();
		txtNombreClienteElim.setBounds(10, 69, 579, 20);
		panelBajaCliente.add(txtNombreClienteElim);
		txtNombreClienteElim.setColumns(10);

		btnBajaCliente = new JButton("Baja");
		btnBajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bntBajaClientePressed();

			}
		});
		btnBajaCliente.setBounds(251, 218, 89, 23);
		panelBajaCliente.add(btnBajaCliente);

		JLabel lblApellidosClienteElim = new JLabel("Introduzca los apellidos del cliente a eliminar:");
		lblApellidosClienteElim.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidosClienteElim.setBounds(10, 105, 579, 14);
		panelBajaCliente.add(lblApellidosClienteElim);

		txtApellidosClienteElim = new JTextField();
		txtApellidosClienteElim.setColumns(10);
		txtApellidosClienteElim.setBounds(10, 130, 579, 20);
		panelBajaCliente.add(txtApellidosClienteElim);

		panelListadoClientes = new JPanel();
		tabbedPaneClientes.addTab("Listado Clientes", null, panelListadoClientes, null);
		panelListadoClientes.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 599, 190);
		panelListadoClientes.add(scrollPane);

		tableClienteModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Apellidos", "Edad", "Provincia", "Fecha de Alta" });

		table = new JTable();
		table.setModel(tableClienteModel);
		scrollPane.setViewportView(table);

		JLabel lblFiltrar = new JLabel("Filtrar por:");
		lblFiltrar.setBounds(10, 201, 114, 14);
		panelListadoClientes.add(lblFiltrar);

		cboxFiltros = new JComboBox();
		cboxFiltros.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Apellidos", "Edad" }));
		cboxFiltros.setBounds(134, 197, 114, 22);
		panelListadoClientes.add(cboxFiltros);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFiltrarPressed();
			}
		});
		btnFiltrar.setBounds(500, 197, 89, 23);
		panelListadoClientes.add(btnFiltrar);
	}

	/**
	 * 
	 */
	protected void btnFiltrarPressed() {

		// TODO sorter.setRowFilter(rowFilter) ??
		RowFilter<DefaultTableModel, Integer> rowFilter = RowFilter.regexFilter((String) cboxFiltros.getSelectedItem(),
				0);

		TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
		table.setRowSorter(rowSorter);

	}

	/**
	 * 
	 */
	protected void btnAltaClientePressed() {
		insertaCliente();
		actualizaTablaClientes();

	}

	/**
	 * Acciones realizadas al presionar el botón de baja clientes
	 */
	protected void bntBajaClientePressed() {
		eliminaCliente();
		actualizaTablaClientes();
	}

	/**
	 * Elimina a un cliente cuyos nombre y apellidos coincidan con los introducidos
	 * de la lista de clientes
	 */
	private void eliminaCliente() {

		String nombreElim = txtNombreClienteElim.getText();
		String apellidosElim = txtApellidosClienteElim.getText();

		// Recorrer lista clientes
		for (int i = 0; i < ClienteManagement.listaClientes.size(); i++) {

			// Si el nombre y apellidos coinciden eliminar cliente
			if (nombreElim.equalsIgnoreCase(ClienteManagement.listaClientes.get(i).getNombre())
					&& apellidosElim.equalsIgnoreCase(ClienteManagement.listaClientes.get(i).getApellidos())) {
				ClienteManagement.listaClientes.remove(i);
			}

		}

	}

	/**
	 * Añade el cliente a la lista de clientes
	 */
	private void insertaCliente() {

		String nombre = null;
		String apellidos = null;
		int edad = 0;
		String provincia = null;

		try {

			nombre = txtNombreCliente.getText();
			apellidos = txtApellidosCliente.getText();
			edad = Integer.parseInt(txtEdadCliente.getText());
			provincia = (String) cboxProvincias.getSelectedItem();

		} catch (Exception e) {

			e.printStackTrace();

			edad = 18;
			provincia = cboxProvincias.getItemAt(0);

		}

		Cliente cliente = new Cliente(nombre, apellidos, edad, provincia);

		ClienteManagement.addCliente(cliente);

	}

	/**
	 * Actualiza la tabla con los datos de los clientes de la lista de clientes
	 */
	private void actualizaTablaClientes() {

		// Borro los datos anteriores
		tableClienteModel.setRowCount(0);

		Date fechaAlta = calendarClientes.getDate();

		// Actualizo los datos con los elementos de la lista de clientes
		for (Cliente c : ClienteManagement.listaClientes) {
			Object[] fila = { c.getNombre(), c.getApellidos(), c.getEdad(), c.getProvincia(), fechaAlta.toString() };
			tableClienteModel.addRow(fila);
		}
	}
}
