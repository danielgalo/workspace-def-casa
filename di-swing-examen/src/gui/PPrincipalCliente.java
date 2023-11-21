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

import dto.User;

public class PPrincipalCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconoAddClase;
	private JLabel iconCierreSesion;
	User cliente;

	/**
	 * Create the frame.
	 */
	public PPrincipalCliente(User cliente) {
		this.cliente = cliente;
		setResizable(false);

		iniciaComponentes();
	}

	private void iniciaComponentes() {
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
		lblLogo.setIcon(new ImageIcon(PPrincipalCliente.class.getResource("/resources/logoApp.png")));
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

		JLabel lblClase = new JLabel("Reservar clase");
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setBounds(121, 135, 102, 14);
		panelCentral.add(lblClase);

		JLabel lblReserva = new JLabel("Cerrar sesión");
		lblReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserva.setBounds(305, 135, 102, 14);
		panelCentral.add(lblReserva);

		iconoAddClase = new JLabel("");
		iconoAddClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resevarClase();
			}
		});
		iconoAddClase.setIcon(new ImageIcon(PPrincipalCliente.class.getResource("/resources/apuntaAClase.png")));
		iconoAddClase.setBounds(140, 60, 64, 64);
		panelCentral.add(iconoAddClase);

		iconCierreSesion = new JLabel("");
		iconCierreSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logout();
			}
		});
		iconCierreSesion.setIcon(new ImageIcon(PPrincipalCliente.class.getResource("/resources/cierreSesion.png")));
		iconCierreSesion.setHorizontalAlignment(SwingConstants.CENTER);
		iconCierreSesion.setBounds(305, 67, 102, 57);
		panelCentral.add(iconCierreSesion);
	}

	protected void logout() {
		this.setVisible(false);
		PLogin login = new PLogin();
		login.setVisible(true);
	}

	protected void resevarClase() {
		PReservaClase reservaClase = new PReservaClase(cliente);
		reservaClase.setVisible(true);
	}

}
