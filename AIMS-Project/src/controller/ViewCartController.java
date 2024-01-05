package controller;

//low coupling (data coupling) 
//Việc sử dụng các đối tượng như Cart và CartMedia không gây ảnh hưởng lớn đến ViewCartController vì chúng được sử dụng như các đối tượng hỗ trợ, không làm giảm tính độc lập của ViewCartController.

//functional cohesion
//Cả hai phương thức checkAvailabilityOfProduct() và getCartSubtotal() đều liên quan đến quá trình quản lý và tính toán trên đối tượng Cart, chúng cùng chịu trách nhiệm cho các chức năng cụ thể trong ngữ cảnh xem

import java.sql.SQLException;
import java.util.List;

import entity.invoice.Invoice;
import entity.media.Media;
import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.order.Order;

/**
 * This class controls the flow of events when users view the Cart
 * @author nguyenlm
 */
public class ViewCartController extends BaseController{
    
    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */
    public void checkAvailabilityOfProduct() throws SQLException{
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    public int getCartSubtotal(){
        int subtotal = Cart.getCart().calSubtotal();
        return subtotal;
    }
    public Invoice createInvoice() {
        return new Invoice(Cart.getCart().getListMedia());
    }

}
