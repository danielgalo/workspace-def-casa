package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.Pelicula;
import utils.SakilaManagement;

public class PantallaPeliculas {

	private JFrame frame;
	private JButton btnSiguiente;
	private JButton btnAnterior;
	private JButton btnPrimero;
	private JButton bntUltimo;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JTextField txtID;
	private JTextField txtTitle;
	private JTextField txtRating;
	private JTextField txtReleaseYear;
	private JTextArea textAreaDesc;
	SakilaManagement sakila;
	ResultSet rsetPeliculas;
	ResultSet rsetActores;
	private JScrollPane scrollPane_1;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public void inicializa() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPeliculas window = new PantallaPeliculas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaPeliculas() {
		initialize();

		sakila = new SakilaManagement();

		sakila.getAllPeliculas();

		sakila.getActoresByPeliculas(1);

		rsetPeliculas = sakila.getResultSetPeliculas();

		rsetActores = sakila.getResultSetActores();

		iniciaPelicula();

		setCampos();

		iniciaActores();

		setActores();

	}

	private void setActores() {

		sakila.getActoresByPeliculas(Integer.parseInt(txtID.getText()));

		try {

			Object[] fila = new Object[3];

			while (rsetActores.next()) {
				fila[0] = rsetActores.getInt("actor_id");
				fila[1] = rsetActores.getString("first_name");
				fila[2] = rsetActores.getString("last_name");
				model.addRow(fila);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		iniciaComponentes();

		model = new DefaultTableModel();

		table = new JTable(model);

		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");

		scrollPane_1.setViewportView(table);
	}

	protected void bntGuardarPressed() {
		btnNuevo.setEnabled(true);
		insertaPelicula();

	}

	private void insertaPelicula() {

		Pelicula currentPeli = new Pelicula(0, txtTitle.getText(), textAreaDesc.getText(),
				Integer.parseInt(txtReleaseYear.getText()), txtRating.getText());

		sakila.insertaPelicula(currentPeli);

	}

	protected void btnNuevoPressed() {

		clearAllCampos();
		btnNuevo.setEnabled(false);

	}

	private void clearAllCampos() {

		txtID.setText("");
		txtTitle.setText("");
		textAreaDesc.setText("");
		txtRating.setText("");
		txtReleaseYear.setText("");
	}

	private void iniciaPelicula() {
		try {
			rsetPeliculas.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void iniciaActores() {
		try {
			rsetActores.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void setCampos() {

		try {

			Pelicula pelicula = getPelicula();

			txtID.setText(String.valueOf(pelicula.getId()));
			txtTitle.setText(pelicula.getTitle());
			textAreaDesc.setText(pelicula.getDescription());
			txtRating.setText(pelicula.getRating());
			txtReleaseYear.setText(String.valueOf(pelicula.getReleaseYear()));

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private Pelicula getPelicula() throws SQLException {
		return new Pelicula(rsetPeliculas.getInt("film_id"), rsetPeliculas.getString("title"),
				rsetPeliculas.getString("description"), rsetPeliculas.getInt("release_year"),
				rsetPeliculas.getString("rating"));
	}

	/**
	 * Mueve el cursor del resultset hacia alante
	 */
	private void siguientePelicula() {
		try {

			if (rsetPeliculas.next()) {

				setCampos();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		btnNuevo.setEnabled(true);
	}

	protected void btnPrimeroPressed() {

		try {
			rsetPeliculas.first();
			setCampos();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnNuevo.setEnabled(true);

	}

	protected void btnSiguientePressed() {

		siguientePelicula();
		siguienteActor();
		btnNuevo.setEnabled(true);

	}

	private void siguienteActor() {

		try {
			if (rsetActores.next()) {

				setActores();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void btnAnteriorPressed() {

		peliculaAnterior();
		btnNuevo.setEnabled(true);
	}

	private void peliculaAnterior() {
		try {

			if (rsetPeliculas.previous()) {

				setCampos();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void bntUltimoPressed() {

		try {
			rsetPeliculas.last();
			setCampos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		btnNuevo.setEnabled(true);
	}

	private void iniciaComponentes() {
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSiguientePressed();
			}
		});
		btnSiguiente.setBounds(10, 316, 89, 23);
		frame.getContentPane().add(btnSiguiente);

		bntUltimo = new JButton("Último");
		bntUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bntUltimoPressed();
			}
		});
		bntUltimo.setBounds(307, 316, 89, 23);
		frame.getContentPane().add(bntUltimo);

		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnAnteriorPressed();

			}
		});
		btnAnterior.setBounds(109, 316, 89, 23);
		frame.getContentPane().add(btnAnterior);

		btnPrimero = new JButton("Primero");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrimeroPressed();
			}
		});
		btnPrimero.setBounds(208, 316, 89, 23);
		frame.getContentPane().add(btnPrimero);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNuevoPressed();
			}
		});
		btnNuevo.setBounds(406, 316, 89, 23);
		frame.getContentPane().add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bntGuardarPressed();
			}
		});
		btnGuardar.setBounds(505, 316, 89, 23);
		frame.getContentPane().add(btnGuardar);

		JLabel lblNewLabel = new JLabel("PELÍCULAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 584, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		txtID = new JTextField();
		txtID.setBounds(112, 36, 155, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);

		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(112, 67, 155, 20);
		frame.getContentPane().add(txtTitle);

		txtRating = new JTextField();
		txtRating.setColumns(10);
		txtRating.setBounds(112, 98, 155, 20);
		frame.getContentPane().add(txtRating);

		JLabel lblNewLabel_1_1 = new JLabel("Título:");
		lblNewLabel_1_1.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Rating:");
		lblNewLabel_1_2.setBounds(10, 101, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_2);

		txtReleaseYear = new JTextField();
		txtReleaseYear.setColumns(10);
		txtReleaseYear.setBounds(112, 129, 155, 20);
		frame.getContentPane().add(txtReleaseYear);

		JLabel lblNewLabel_1_2_1 = new JLabel("Año de salida:");
		lblNewLabel_1_2_1.setBounds(10, 132, 89, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 67, 317, 80);
		frame.getContentPane().add(scrollPane);

		textAreaDesc = new JTextArea();
		scrollPane.setViewportView(textAreaDesc);

		JLabel lblNewLabel_1_3 = new JLabel("Descripción:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(277, 39, 317, 14);
		frame.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Actores:");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setBounds(10, 173, 584, 14);
		frame.getContentPane().add(lblNewLabel_1_3_1);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 198, 585, 96);
		frame.getContentPane().add(scrollPane_1);
	}
}
