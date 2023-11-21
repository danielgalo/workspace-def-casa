package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import dto.User;
import main.GymPicassoMain;

public class PRegistro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JDateChooser txtFechaNacimiento;
	private JComboBox<String> cboxPerfil;
	private JPasswordField txtPassword;
	private JPasswordField txtPassword2;
	private JTextField txtEmail;

	/**
	 * Create the dialog.
	 */
	public PRegistro() {
		setResizable(false);
		iniciaComponentes();
	}

	private void iniciaComponentes() {
		setBounds(100, 100, 450, 544);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		contentPanel.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Registro de usuario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);

		JPanel panelCentral = new JPanel();
		contentPanel.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 40, 183, 14);
		panelCentral.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(203, 37, 211, 20);
		panelCentral.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(203, 84, 211, 20);
		panelCentral.add(txtApellidos);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 87, 183, 14);
		panelCentral.add(lblApellidos);

		JLabel lblFechaNac = new JLabel("Fecha de Nacimiento");
		lblFechaNac.setBounds(10, 141, 183, 14);
		panelCentral.add(lblFechaNac);

		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(10, 198, 183, 14);
		panelCentral.add(lblPerfil);

		JLabel lblRepitePswd = new JLabel("Repite contraseña");
		lblRepitePswd.setBounds(10, 376, 183, 14);
		panelCentral.add(lblRepitePswd);

		JLabel lblPswd = new JLabel("Contraseña");
		lblPswd.setBounds(10, 317, 183, 14);
		panelCentral.add(lblPswd);

		txtFechaNacimiento = new JDateChooser();
		txtFechaNacimiento.setBounds(203, 135, 211, 20);
		panelCentral.add(txtFechaNacimiento);

		cboxPerfil = new JComboBox();
		cboxPerfil.setModel(new DefaultComboBoxModel(new String[] { "Administrador", "Cliente" }));
		cboxPerfil.setBounds(203, 194, 211, 22);
		panelCentral.add(cboxPerfil);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(203, 314, 211, 20);
		panelCentral.add(txtPassword);

		txtPassword2 = new JPasswordField();
		txtPassword2.setBounds(203, 373, 211, 20);
		panelCentral.add(txtPassword2);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEnviarPressed();
			}
		});
		btnNewButton.setBounds(203, 429, 211, 23);
		panelCentral.add(btnNewButton);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(203, 258, 211, 20);
		panelCentral.add(txtEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 261, 183, 14);
		panelCentral.add(lblEmail);
	}

	protected void btnEnviarPressed() {

		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		Date fechaNacimiento = txtFechaNacimiento.getDate();
		String perfil = (String) cboxPerfil.getSelectedItem();
		String email = txtEmail.getText();

		char[] password1 = txtPassword.getPassword();
		char[] password2 = txtPassword2.getPassword();

		String strPassword1 = new String(password1);
		String strPassword2 = new String(password2);

		if (!nombre.isBlank() && !strPassword1.isBlank()) {
			// Si las contraseñas coinciden
			if (strPassword1.equals(strPassword2)) {
				// Registrar al usuario
				User usuario = new User(nombre, apellidos, fechaNacimiento, email, perfil, strPassword1);
				GymPicassoMain.users.add(usuario);
				// Cerrar ventana
				this.setVisible(false);
			} else {
				// Si no coinciden informar al usuario
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
			}
		} else {
			JOptionPane.showMessageDialog(null, "El nombre y la contraseña son obligatorios.");
		}

	}
}
