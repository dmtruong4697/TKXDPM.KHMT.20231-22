package entity.invoice;

import entity.order.Order;

public class Invoice { //Functional Cohesion :mangage information about Invoice and Order,Procedural Cohesion

    private Order order;
    private int amount;
    
    public Invoice(){
//data coupling with saveInvoice use data from Order
    }

    public Invoice(Order order){
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void saveInvoice(){
        //data coupling with Invoice use data from Order
        //Communication Cohesion relate to Invoice and Order
    }
}
