package entity.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.Configs;

public class Order {//Functional Cohesion:manage information about,Procedural Cohesion
    
    private int shippingFees;
    private List lstOrderMedia;//Order and OrderMedia datacoupling through 1stOrderMedia variable 
    private HashMap<String, String> deliveryInfo;

    public Order(){
        this.lstOrderMedia = new ArrayList<>();
    }

    public Order(List lstOrderMedia) {
        this.lstOrderMedia = lstOrderMedia;
    }

    public void addOrderMedia(OrderMedia om){
        this.lstOrderMedia.add(om);
    }

    public void removeOrderMedia(OrderMedia om){
        this.lstOrderMedia.remove(om);
    }

    public List getlstOrderMedia() {
        return this.lstOrderMedia;
    }

    public void setlstOrderMedia(List lstOrderMedia) {
        this.lstOrderMedia = lstOrderMedia;
    }

    public void setShippingFees(int shippingFees) {
        this.shippingFees = shippingFees;
    }

    public int getShippingFees() {
        return shippingFees;
    }

    public HashMap getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(HashMap deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public int getAmount(){//Communicational Cohesion:Configs to get 'PERCENT_VAT',link with OrderMedia through 1stOrderMedia,Hashmap through deliveryInfo
        double amount = 0;
        for (Object object : lstOrderMedia) {
            OrderMedia om = (OrderMedia) object;
            amount += om.getPrice();
        }
        return (int) (amount + (Configs.PERCENT_VAT/100)*amount);//Order and Configs datacoupling through getAmount 
    }

}
//Vi phạm tiêu chí SOLID
//SRP:Lớp Order có vẻ thực hiện nhiều trách nhiệm, bao gồm quản lý thông tin đơn hàng, tương tác với danh sách sản phẩm đơn hàng (lstOrderMedia), tính toán tổng số tiền (getAmount), và quản lý thông tin giao hàng (deliveryInfo). Điều này làm giảm tính rõ ràng và dễ bảo trì của lớp.
//DIP:Lớp Order phụ thuộc trực tiếp vào OrderMedia thông qua lstOrderMedia, và cũng phụ thuộc vào Configs
//Solution
//SRP:Tách chức năng của lớp Order thành các lớp nhỏ hơn với mỗi lớp có một trách nhiệm cụ thể
//DIP:Sử dụng Dependency Injection (DI) để cung cấp các phụ thuộc từ bên ngoài vào lớp Order, thay vì tạo ngay tại bên trong lớp.Sử dụng Interface để đại diện cho các phụ thuộc, giúp giảm sự phụ thuộc cụ thể và tăng tính linh hoạt.
