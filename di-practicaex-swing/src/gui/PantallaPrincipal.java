package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.Persona;
import utils.PersonaManagement;

public class PantallaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtNombreElim;
	private JButton btnAdd;
	private ListadoPersona listado;

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {

		listado = new ListadoPersona();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Edad");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtNombre = new JTextField();
		txtNombre.setBounds(178, 8, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setBounds(178, 33, 86, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);

		btnAdd = new JButton("añadir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddPressed();
			}
		});
		btnAdd.setBounds(10, 61, 89, 23);
		contentPane.add(btnAdd);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 114, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtNombreElim = new JTextField();
		txtNombreElim.setBounds(178, 111, 86, 20);
		contentPane.add(txtNombreElim);
		txtNombreElim.setColumns(10);

		JButton btnElim = new JButton("eliminar");
		btnElim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminarPressed();
			}
		});
		btnElim.setBounds(10, 139, 89, 23);
		contentPane.add(btnElim);

		JButton btnNewButton_1 = new JButton("ver ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnVerPressed();
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	protected void btnEliminarPressed() {

		PersonaManagement.removePersona(txtNombreElim.getText());
		// actualizar tabla
		listado.modelo.setRowCount(0);

		for (Persona per : PersonaManagement.personas) {
			Object[] fila = { per.getNombre(), per.getEdad() };
			listado.modelo.addRow(fila);
		}
	}

	protected void btnAddPressed() {

		// registrar persona
		Persona p = new Persona(txtNombre.getText(), Integer.parseInt(txtEdad.getText()));
		PersonaManagement.addPersona(p);

		// actualizar tabla
		listado.modelo.setRowCount(0);

		for (Persona per : PersonaManagement.personas) {
			Object[] fila = { per.getNombre(), per.getEdad() };
			listado.modelo.addRow(fila);
		}

	}

	protected void btnVerPressed() {

		listado.setVisible(true);
	}
}
