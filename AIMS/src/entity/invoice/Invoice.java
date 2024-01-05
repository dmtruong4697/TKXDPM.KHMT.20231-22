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
//Vi phạm tiêu chí SOLID
// SRP:Class Invoice có nhiều trách nhiệm (quản lý thông tin Invoice,tương tác với Order)
//DIP: Class Invoice phụ thuộc trực tiếp vào Order,nếu thay đổi Order sẽ có thể ảnh hưởng Invoice
//OCP:Class Invoice không có khả năng mở rộng
//Solution
//SRP:Tách Class Invoice thành các lớp nhỏ hơn
//DIP:Thay vì tạo Order bên trong Invoice,inject Order từ bên ngoài
//OCP:Định nghĩa interface hoặc abstract class cho Invoice