package model.exceptions;

/*
 * RuntimeException: é um tipo de exceção que o compilador não obriga você a tratar. Não precisa usar try-catch. 
 * Exception: vai ser preciso tratar ou propagar. Na classe Reserva precisou propagar colocando throws DomainException no método
 */
public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/*
	 * É para permitir que a classe DomainException possa ser instanciada passando
	 * uma mensagem que ficará armazenada dentro da exceção
	 */

	public DomainException(String msg) {
		super(msg);
	}

}
