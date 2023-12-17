package entity.payment;

public class PaymentTransaction {//Functional Cohesion:manage information about PaymentTransaction,Procedural Cohesion
	private String errorCode;
	private CreditCard card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent,
			int amount, String createdAt) { //PaymentTransaction and CreditCard datacoupling through card variable
		super();
		this.errorCode = errorCode;         //Communicational Cohesion:through card 
		this.card = card;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
//Không vi phạm tiêu chí SOLID nào
