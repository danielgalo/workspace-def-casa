package main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory sessionf = HibernateUtils.getSessionFactory();
		// Abre sesion y abro una transacción
		Session session = sessionf.openSession();
		session.getTransaction().begin();

		// 1 -
		String hql = "SELECT c.nombre AS categoria, p.nombre AS producto "
				+ "FROM Categoria c INNER JOIN c.productos p " + "WHERE p.nombre LIKE '%q%' "
				+ "ORDER BY c.nombre, p.nombre";

		List<Object[]> results = session.createQuery(hql).list();

		for (Object[] result : results) {
			String categoria = (String) result[0];
			String producto = (String) result[1];
			System.out.println("Categoria: " + categoria + ", Producto: " + producto);
		}
		// 2 -
		String hql2 = "SELECT p.id AS numeroPedido, c.pais, p.fechaPedido " + "FROM Pedido p "
				+ "INNER JOIN p.cliente c " + "WHERE p.fechaPedido BETWEEN '1997-05-01' AND '1997-05-31' "
				+ "ORDER BY p.fechaPedido, p.id";

		List<Object[]> results2 = session.createQuery(hql2).list();

		for (Object[] result : results2) {
			int numeroPedido = (int) result[0];
			String pais = (String) result[1];
			Date fechaPedido = (Date) result[2];
			System.out.println(
					"Numero de Pedido: " + numeroPedido + ", Pais: " + pais + ", Fecha de Pedido: " + fechaPedido);
		}
		// 3 -
		String hql3 = "SELECT d.pedido.id, p.fechaPedido, d.cantidad, p.nombre AS producto, d.precioUnidad "
				+ "FROM Pedido p " + "INNER JOIN p.detalles d " + "WHERE p.id IN (10285, 10298) "
				+ "ORDER BY p.id, p.fechaPedido";

		List<Object[]> results3 = session.createQuery(hql3).list();

		for (Object[] result : results3) {
			int codigoPedido = (int) result[0];
			Date fechaPedido = (Date) result[1];
			int cantidad = (int) result[2];
			String producto = (String) result[3];
			double precioUnidad = (double) result[4];
			System.out.println("Codigo de Pedido: " + codigoPedido + ", Fecha de Pedido: " + fechaPedido
					+ ", Cantidad: " + cantidad + ", Producto: " + producto + ", Precio Unidad: " + precioUnidad);
		}

		session.getTransaction().commit();
		HibernateUtils.closeSession(sessionf);
	}
}
