package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dto.User;
import main.GymPicassoMain;

public class PLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuarioLogin;
	private JPasswordField txtPasswordLogin;
	private JButton btnLogin;
	private JButton btnRegister;
	private JLabel lblInfoLogin;

	/**
	 * Create the frame.
	 */
	public PLogin() {

		iniciaComponentes();
	}

	private void iniciaComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(128, 255, 255));
		contentPane.add(panelSuperior, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("  GYM Picasso");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setIcon(new ImageIcon(PLogin.class.getResource("/resources/logoApp.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelSuperior.add(lblNewLabel);

		JPanel panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		panelIzquierda.setLayout(new BorderLayout(0, 0));

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PLogin.class.getResource("/resources/imgLogin.png")));
		panelIzquierda.add(lblLogo, BorderLayout.CENTER);

		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));

		JPanel panelTextoBienvenida = new JPanel();
		panelTextoBienvenida.setBackground(new Color(0, 128, 192));
		panelCentral.add(panelTextoBienvenida, BorderLayout.NORTH);
		panelTextoBienvenida.setLayout(new BorderLayout(200, 200));

		JLabel lblNewLabel_2 = new JLabel("Bienvenido/a a la aplicación GYM Picasso");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelTextoBienvenida.add(lblNewLabel_2, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 255));
		panelCentral.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(54, 89, 98, 20);
		lblUsuario.setForeground(new Color(0, 128, 192));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblUsuario);

		txtUsuarioLogin = new JTextField();
		txtUsuarioLogin.setBounds(162, 86, 169, 30);
		panel_1.add(txtUsuarioLogin);
		txtUsuarioLogin.setColumns(10);

		txtPasswordLogin = new JPasswordField();
		txtPasswordLogin.setBounds(162, 127, 169, 30);
		panel_1.add(txtPasswordLogin);

		JLabel lblContrasenya = new JLabel("Contraseña");
		lblContrasenya.setForeground(new Color(0, 128, 192));
		lblContrasenya.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasenya.setBounds(54, 135, 98, 20);
		panel_1.add(lblContrasenya);

		btnLogin = new JButton("Inicia Sesión");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginPressed();
			}
		});
		btnLogin.setBackground(new Color(0, 128, 192));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(185, 168, 146, 23);
		panel_1.add(btnLogin);

		btnRegister = new JButton("Pulsa aquí para registrarte");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegisterPressed();
			}
		});
		btnRegister.setBackground(new Color(0, 128, 192));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBounds(137, 290, 194, 23);
		panel_1.add(btnRegister);

		lblInfoLogin = new JLabel("        ");
		lblInfoLogin.setForeground(new Color(0, 128, 192));
		lblInfoLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInfoLogin.setBounds(10, 234, 321, 20);
		panel_1.add(lblInfoLogin);
	}

	protected void btnRegisterPressed() {

		PRegistro registro = new PRegistro();
		registro.setVisible(true);

	}

	protected void btnLoginPressed() {

		// Recoger campos
		String username = txtUsuarioLogin.getText();
		char[] passwordChar = txtPasswordLogin.getPassword();
		String password = new String(passwordChar);

		User user = null;
		boolean isLogged = false;

		// Comprobar lista de usuarios
		for (User u : GymPicassoMain.users) {

			if (u.getNombre().equals(username) && u.getPassword().equals(password)) {
				user = new User(u.getNombre(), u.getApellidos(), u.getFechaNacimiento(), u.getEmail(), u.getPerfil(),
						u.getPassword());
				isLogged = true;
			}

		}

		// Si está loggeado
		if (isLogged) {

			// Vaciar mensaje de error
			lblInfoLogin.setText("");

			// Si es administrador
			if (user.getPerfil().equalsIgnoreCase("Administrador")) {

				PPrincipalAdmin pantallaAdmin = new PPrincipalAdmin();
				pantallaAdmin.setVisible(true);

				// Si es cliente
			} else if (user.getPerfil().equalsIgnoreCase("Cliente")) {
				PPrincipalCliente pantallaCliente = new PPrincipalCliente(user);
				pantallaCliente.setVisible(true);
			}
			this.setVisible(false);
			// Si no está logado, informar al usuario
		} else {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
		}

	}
}
