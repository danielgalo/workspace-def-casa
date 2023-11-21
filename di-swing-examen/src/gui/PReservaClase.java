package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Clase;
import dto.Reserva;
import dto.User;
import main.GymPicassoMain;

public class PReservaClase extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnReservar;
	private JComboBox<String> cboxClase;
	DefaultComboBoxModel<String> modeloClase;
	DefaultComboBoxModel<String> modeloTurno;
	User cliente;
	private JComboBox<String> cboxTurno;

	/**
	 * Create the dialog.
	 */
	public PReservaClase(User cliente) {
		this.cliente = cliente;
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelTitulo = new JPanel();
			panelTitulo.setBackground(new Color(0, 128, 255));
			contentPanel.add(panelTitulo, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Reservar Clase");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				panelTitulo.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblNewLabel_1 = new JLabel("Clase");
			lblNewLabel_1.setBounds(10, 66, 93, 14);
			panel.add(lblNewLabel_1);

			modeloClase = new DefaultComboBoxModel<String>();

			for (Clase c : GymPicassoMain.clases) {
				modeloClase.addElement(c.getNombreClase());
			}

			cboxClase = new JComboBox<String>();
			cboxClase.setBounds(186, 54, 228, 39);

			cboxClase.setModel(modeloClase);
			panel.add(cboxClase);

			modeloTurno = new DefaultComboBoxModel<String>();

			Clase clase = null;

			for (Clase c : GymPicassoMain.clases) {
				if (cboxClase.getSelectedItem().toString().equals(c.getNombreClase())) {
					clase = c;
				}
			}

			modeloTurno.addElement(clase.getTurno());

			cboxTurno = new JComboBox<String>();
			cboxTurno.setModel(modeloTurno);
			cboxTurno.setBounds(186, 104, 228, 39);
			panel.add(cboxTurno);

			JLabel lblNewLabel_1_1 = new JLabel("Turno");
			lblNewLabel_1_1.setBounds(10, 116, 93, 14);
			panel.add(lblNewLabel_1_1);

			btnReservar = new JButton("Reservar");
			btnReservar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bntReservarPressed();
				}
			});
			btnReservar.setBounds(186, 174, 228, 34);
			panel.add(btnReservar);
		}
	}

	protected void bntReservarPressed() {

		Clase clase = null;

		for (Clase c : GymPicassoMain.clases) {
			if (c.getNombreClase().equals(cboxClase.getSelectedItem().toString())) {
				clase = c;
			}
		}

		Reserva reserva = new Reserva(cliente, clase, cboxTurno.getSelectedItem().toString());
		GymPicassoMain.reservas.add(reserva);
		JOptionPane.showMessageDialog(null, "Clase reservada correctamente");

		this.setVisible(false);
	}
}
