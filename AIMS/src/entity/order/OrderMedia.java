package entity.order;

import entity.media.Media;

public class OrderMedia {//Functional Cohesion:manage information about OrderMedia,Procedural Cohesion
    
    private Media media;
    private int price;
    private int quantity;

    public OrderMedia(Media media, int quantity, int price) { //OrderMedia and Media datacoupling through media variable
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "{" +
            "  media='" + media + "'" +
            ", quantity='" + quantity + "'" +
            ", price='" + price + "'" +
            "}";
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

}
//Không vi phạm tiêu chí SOLID nào
