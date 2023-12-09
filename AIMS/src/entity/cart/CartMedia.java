//Mức Độ Coupling: Low
//Tất cả dữ liệu (media, quantity, price) được giữ bên trong lớp CartMedia và được truy cập thông qua các phương thức getter và setter

// functional cohesion
// Lớp CartMedia chứa các thuộc tính và phương thức liên quan chặt chẽ đến thông tin của một mục trong giỏ hàng, bao gồm đối tượng Media, số lượng và giá. Các phương thức và thuộc tính đều liên quan đến chức năng và thông tin của một mục trong giỏ hàng.
package entity.cart;

import entity.media.Media;

public class CartMedia {
    
    private Media media;
    private int quantity;
    private int price;

    public CartMedia(){

    }

    public CartMedia(Media media, Cart cart, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Media getMedia() {
        return this.media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" 
            + " media='" + media + "'" 
            + ", quantity='" + quantity + "'" 
            + "}";
    }

}

    
