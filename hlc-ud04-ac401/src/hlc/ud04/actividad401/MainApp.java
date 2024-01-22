package hlc.ud04.actividad401;

import hlc.ud04.actividad401.autenticador.AutenticadorPassword;
import hlc.ud04.actividad401.controlacceso.ControlAccesoSimple;
import hlc.ud04.actividad401.seguridad.SistemaSeguridadPassword;
import hlc.ud04.appsec.core.Clientes;
import hlc.ud04.appsec.core.GestorPersistencia;
import hlc.ud04.appsec.interfaz.Interfaz;
import hlc.ud04.appsec.interfaz.consola.InterfazConsola;
import hlc.ud04.appsec.persistencia.GestorPersistenciaSqlite;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;

public class MainApp {

	private static final String DB_PATH = "db/base.db";

	public static void main(String[] args) {

		// Gestor de persistencias de base de datos (SQLite)
		GestorPersistencia gestor = new GestorPersistenciaSqlite(DB_PATH);
		// Gestor de clientes (Contiene CRUD)
		Clientes clientes = new Clientes(gestor);

		// Sistema de seguridad (Autenticación (¿Eres quien dices que eres?) y Control
		// de acceso(¿Puedes hacer x operaciones?))
		SistemaSeguridad sistSeguridad = new SistemaSeguridadPassword(new AutenticadorPassword(),
				new ControlAccesoSimple());

		// Interfaz de consola
		Interfaz interfaz = new InterfazConsola(clientes, sistSeguridad);
		interfaz.run();

	}

}
