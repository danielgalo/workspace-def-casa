package psp.act303.utils;

/**
 * Constants class
 */
public class Constants {

	/**
	 * Private constructor
	 */
	private Constants() {

	}

	/** Default port for the server */
	public static final int DEFAULT_PORT = 2121;

	/** Path to the server.properties file */
	public static final String SERVER_PROPERTIES = "server.properties";
	/** Port property */
	public static final String PORT_PROPERTY = "puerto";

	/** Command to stop server/client */
	public static final String QUIT_COMMAND = "quit";

	/** Command to list files from a path */
	public static final String LIST_COMMAND = "list";

	/** Command to delete files from a path */
	public static final String DELETE_COMMAND = "delete";

	/** Command to show files from a path */
	public static final String SHOW_COMMAND = "show";

	/** KO message */
	public static final String KO = "KO\n";

	/** OK message */
	public static final String OK = "OK\n";

}
