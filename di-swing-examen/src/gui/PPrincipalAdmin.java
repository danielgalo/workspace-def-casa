package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PPrincipalAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconoAddClase;
	private JLabel iconVerReservas;
	private JLabel iconCierreSesion;
	private JLabel iconVerClientes;

	/**
	 * Create the frame.
	 */
	public PPrincipalAdmin() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblLogo = new JLabel("  GYM Picasso");
		lblLogo.setIcon(new ImageIcon(PPrincipalAdmin.class.getResource("/resources/logoApp.png")));
		lblLogo.setForeground(new Color(0, 128, 192));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblLogo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 255));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		LocalDate lc = LocalDate.now();
		JLabel lblNombre = new JLabel("Daniel Galo Vega " + lc.toString());
		lblNombre.setForeground(new Color(0, 128, 192));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNombre);

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(255, 255, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JLabel lblClase = new JLabel("Añade clase");
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setBounds(85, 93, 102, 14);
		panelCentral.add(lblClase);

		JLabel lblReserva = new JLabel("Ver reservas");
		lblReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserva.setBounds(329, 93, 102, 14);
		panelCentral.add(lblReserva);

		JLabel lblCierraSesion = new JLabel("Cierra sesión");
		lblCierraSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCierraSesion.setBounds(329, 182, 102, 14);
		panelCentral.add(lblCierraSesion);

		JLabel lblCliente = new JLabel("Ver clientes");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setBounds(85, 182, 102, 14);
		panelCentral.add(lblCliente);

		iconoAddClase = new JLabel("");
		iconoAddClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addClasePressed();
			}
		});
		iconoAddClase.setIcon(new ImageIcon(PPrincipalAdmin.class.getResource("/resources/addClase.png")));
		iconoAddClase.setBounds(104, 25, 64, 57);
		panelCentral.add(iconoAddClase);

		iconVerReservas = new JLabel("");
		iconVerReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verReservasPressed();
			}
		});
		iconVerReservas.setIcon(new ImageIcon(PPrincipalAdmin.class.getResource("/resources/listarReservas.png")));
		iconVerReservas.setHorizontalAlignment(SwingConstants.CENTER);
		iconVerReservas.setBounds(329, 25, 102, 57);
		panelCentral.add(iconVerReservas);

		iconVerClientes = new JLabel("");
		iconVerClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verClientesPressed();
			}
		});
		iconVerClientes.setIcon(new ImageIcon(PPrincipalAdmin.class.getResource("/resources/listarUsuarios.png")));
		iconVerClientes.setHorizontalAlignment(SwingConstants.CENTER);
		iconVerClientes.setBounds(85, 118, 102, 53);
		panelCentral.add(iconVerClientes);

		iconCierreSesion = new JLabel("");
		iconCierreSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logoutPressed();
			}
		});
		iconCierreSesion.setIcon(new ImageIcon(PPrincipalAdmin.class.getResource("/resources/cierreSesion.png")));
		iconCierreSesion.setHorizontalAlignment(SwingConstants.CENTER);
		iconCierreSesion.setBounds(329, 118, 102, 53);
		panelCentral.add(iconCierreSesion);
	}

	protected void verReservasPressed() {
		PListaReservas listaReservas = new PListaReservas();
		listaReservas.setVisible(true);
	}

	/**
	 * Muestra pantalla con clientes
	 */
	protected void verClientesPressed() {
		PListaClientes listaClientes = new PListaClientes();
		listaClientes.setVisible(true);
	}

	/**
	 * Cierra sesion
	 */
	protected void logoutPressed() {
		this.setVisible(false);
		PLogin login = new PLogin();
		login.setVisible(true);
	}

	/**
	 * Abre ventana para registrar clase
	 */
	protected void addClasePressed() {
		PNuevaClase nuevaClase = new PNuevaClase();
		nuevaClase.setVisible(true);
	}

}
