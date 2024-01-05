//low coupling (data coupling)

//Functional Cohesion
package common.exception;;

/**
 * The InvalidDeliveryInfoException wraps all unchecked exceptions You can use this
 * exception to inform
 * 
 * @author nguyenlm
 */

//functional cohesion
public class InvalidDeliveryInfoException extends AimsException {

	private static final long serialVersionUID = 1091337136123906298L;

	public InvalidDeliveryInfoException() {

	}

	public InvalidDeliveryInfoException(String message) {
		super(message);
	}

}