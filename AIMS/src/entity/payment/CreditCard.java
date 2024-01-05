package entity.payment;

import java.sql.Timestamp;

public class CreditCard {//Functional Cohesion:manage information about CreditCard,Procedural Cohesion
	private String cardCode;
	private String owner;
	private int cvvCode;
	private String dateExpired;

	public CreditCard(String cardCode, String owner, int cvvCode, String dateExpired) {
		super();
		this.cardCode = cardCode;
		this.owner = owner;
		this.cvvCode = cvvCode;
		this.dateExpired = dateExpired;
	}
}

//Không vi phạm tiêu chí SOLID nào