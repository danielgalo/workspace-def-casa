package modelo_neptuno;
// Generated 20 ene. 2021 12:08:17 by Hibernate Tools 5.4.21.Final

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userMessage;
	private String userName;

	public User() {
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String userMessage, String userName) {
		this.id = id;
		this.userMessage = userMessage;
		this.userName = userName;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserMessage() {
		return this.userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
