package entity.invoice;

import entity.cart.CartMedia;
import entity.media.Media;
import entity.order.OrderMedia;
import entity.payment.PaymentTransaction;
import utils.Configs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Invoice {

	//Functional Cohesion :mangage information about Invoice and Order,Procedural Cohesion
    private List<OrderMedia> listOrderMedia;
    private int totalPrice;
    private int shippingFees;
    private int totalProductIncludeVAT;
    private int totalProductNoVAT;
    private PaymentTransaction paymentTransaction;
    
    public Invoice(List<Media> listOrderMedia){
        ArrayList<OrderMedia> tmpList = new ArrayList<>();
        for (Object object : listOrderMedia) {
            CartMedia cartMedia = (CartMedia) object;
            OrderMedia orderMedia = new OrderMedia(cartMedia.getMedia(),
                    cartMedia.getQuantity(),
                    cartMedia.getPrice());
            tmpList.add(orderMedia);
        }
        this.listOrderMedia = tmpList;
        totalPrice = calculateTotalPrice();
        totalProductIncludeVAT = calculateTotalProductIncludeVAT();
        totalProductNoVAT = calculateTotalProductNoVAT();
        shippingFees = 0;
    }

    public void setShippingFees(int shippingFees) {
        this.shippingFees = shippingFees;
    }

    public List<OrderMedia> getListOrderMedia() {
        return listOrderMedia;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getShippingFees() {
        return shippingFees;
    }

    public int getTotalProductIncludeVAT() {
        return totalProductIncludeVAT;
    }

    public int getTotalProductNoVAT() {
        return totalProductNoVAT;
    }

    public int calculateTotalPrice(){
        return calculateTotalProductIncludeVAT() + shippingFees;
    }

    // Method to calculate total product price including VAT
    public int calculateTotalProductIncludeVAT(){
        double amount = 0;
        for (Object object : listOrderMedia) {
            OrderMedia om = (OrderMedia) object;
            amount += om.getPrice();
        }
        return (int) (amount + (Configs.PERCENT_VAT/100)*amount);
    }

    // Method to calculate total product price without VAT
    public int calculateTotalProductNoVAT(){
        double amount = 0;
        for (Object object : listOrderMedia) {
            OrderMedia om = (OrderMedia) object;
            amount += om.getPrice();
        }
        return (int) (amount);
    }

    // Method to get the number of rush shipping products
    public int getNumberOfRushShippingProduct(){
        int count = 0;
        for(Object object : listOrderMedia){
            OrderMedia om = (OrderMedia) object;
            System.out.println(om.getMedia().isSupportRushShipping());
            if(om.getMedia().isSupportRushShipping()) count++;
        }
        return count;
    }
    
    // Method to get the maximum weight among ordered media
    public double getMaxWeight(){
        int max = 0;
        for(Object object : listOrderMedia){
            OrderMedia om = (OrderMedia) object;
            if(om.getMedia().getWeight() > max) max = om.getMedia().getWeight();
        }
        return max;
    }



    public void saveInvoice(){
        //data coupling with Invoice use data from Order
        //Communication Cohesion relate to Invoice and Order
    }
}

//Vi phạm tiêu chí SOLID
//SRP:Class Invoice có nhiều trách nhiệm (quản lý thông tin Invoice,tương tác với Order)
//DIP: Class Invoice phụ thuộc trực tiếp vào Order,nếu thay đổi Order sẽ có thể ảnh hưởng Invoice
//OCP:Class Invoice không có khả năng mở rộng
//Solution
//SRP:Tách Class Invoice thành các lớp nhỏ hơn
//DIP:Thay vì tạo Order bên trong Invoice,inject Order từ bên ngoài
//OCP:Định nghĩa interface hoặc abstract class cho Invoice
