package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.Clase;
import main.GymPicassoMain;

public class PNuevaClase extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreClase;
	private JTextField txtProfesor;
	private JRadioButton rdbtnMorning;
	private JRadioButton rdbtnTarde;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnEnviar;

	/**
	 * Create the dialog.
	 */
	public PNuevaClase() {
		setResizable(false);
		iniciaComponentes();
	}

	private void iniciaComponentes() {
		setBounds(100, 100, 450, 305);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		contentPanel.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Nueva Clase");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);

		JPanel panelCentral = new JPanel();
		contentPanel.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 44, 122, 14);
		panelCentral.add(lblNombre);

		txtNombreClase = new JTextField();
		txtNombreClase.setBounds(189, 35, 225, 33);
		panelCentral.add(txtNombreClase);
		txtNombreClase.setColumns(10);

		txtProfesor = new JTextField();
		txtProfesor.setColumns(10);
		txtProfesor.setBounds(189, 79, 225, 33);
		panelCentral.add(txtProfesor);

		JLabel lblProfesor = new JLabel("Profesor/a");
		lblProfesor.setBounds(10, 88, 122, 14);
		panelCentral.add(lblProfesor);

		rdbtnMorning = new JRadioButton("Mañana");
		buttonGroup.add(rdbtnMorning);
		rdbtnMorning.setBounds(189, 126, 109, 23);
		panelCentral.add(rdbtnMorning);

		rdbtnTarde = new JRadioButton("Tarde");
		buttonGroup.add(rdbtnTarde);
		rdbtnTarde.setBounds(189, 152, 109, 23);
		panelCentral.add(rdbtnTarde);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEnviarPressed();
			}
		});
		btnEnviar.setBounds(189, 182, 225, 33);
		panelCentral.add(btnEnviar);

		JLabel lblNewLabel_1_1_1 = new JLabel("Turno");
		lblNewLabel_1_1_1.setBounds(10, 130, 89, 14);
		panelCentral.add(lblNewLabel_1_1_1);
	}

	/**
	 * Registra una clase con los datos introducidos
	 */
	protected void btnEnviarPressed() {

		boolean isClaseOk = false;

		// Recoger datos
		String nombreClase = txtNombreClase.getText();
		String profesor = txtProfesor.getText();
		String turno = "";

		if (rdbtnMorning.isSelected()) {
			turno = rdbtnMorning.getText();
			isClaseOk = true;
		} else if (rdbtnTarde.isSelected()) {
			turno = rdbtnTarde.getText();
			isClaseOk = true;
		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un turno");
		}

		if (isClaseOk) {
			// Crear clase
			Clase clase = new Clase(nombreClase, profesor, turno);
			// Registrar la clase, mostrar confirmacion y cerrar ventana
			if (clase != null) {
				GymPicassoMain.clases.add(clase);
				JOptionPane.showMessageDialog(null, "Clase registrada correctamente");
				this.setVisible(false);
			}
		}

	}
}
