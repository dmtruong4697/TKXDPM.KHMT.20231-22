package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import entity.db.AIMSDB;

public class Book extends Media {//Functional Cohesion:manage information about book,Procedural Cohesion

    String author;
    String coverType;
    String publisher;
    Date publishDate;
    int numOfPages;
    String language;
    String bookCategory;

    public Book() throws SQLException{

    }

    public Book(int id, String title, String category, int price, int quantity, String type, String author,
            String coverType, String publisher, Date publishDate, int numOfPages, String language,
            String bookCategory) throws SQLException{
        super(id, title, category, price, quantity, type);
        this.author = author;
        this.coverType = coverType;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.numOfPages = numOfPages;
        this.language = language;
        this.bookCategory = bookCategory;
    }

    // getter and setter
    public int getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCoverType() {
        return this.coverType;
    }

    public Book setCoverType(String coverType) {
        this.coverType = coverType;
        return this;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Date getPublishDate() {
        return this.publishDate;
    }

    public Book setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public int getNumOfPages() {
        return this.numOfPages;
    }

    public Book setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
        return this;
    }

    public String getLanguage() {
        return this.language;
    }

    public Book setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getBookCategory() {
        return this.bookCategory;
    }

    public Book setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
        return this;
    }

    @Override
    public Media getMediaById(int id) throws SQLException { //Communicational Cohesion:comunicate with database
        String sql = "SELECT * FROM "+
                     "aims.Book " +
                     "INNER JOIN aims.Media " +
                     "ON Media.id = Book.id " +
                     "where Media.id = " + id + ";";
        Statement stm = AIMSDB.getConnection().createStatement();//Book and AIMSDB data coupling through getMediaByID
        ResultSet res = stm.executeQuery(sql); //Book and ResultSet data coupling through getMediaByID
		if(res.next()) {

            // from Media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from Book table
            String author = res.getString("author");
            String coverType = res.getString("coverType");
            String publisher = res.getString("publisher");
            Date publishDate = res.getDate("publishDate");
            int numOfPages = res.getInt("numOfPages");
            String language = res.getString("language");
            String bookCategory = res.getString("bookCategory");
            
            return new Book(id, title, category, price, quantity, type, 
                            author, coverType, publisher, publishDate, numOfPages, language, bookCategory);
            
		} else {
			throw new SQLException();
		}
    }

    @Override
    public List getAllMedia() {
        return null;
    }


    @Override
    public String toString() {
        return "{" +
            super.toString() +
            " author='" + author + "'" +
            ", coverType='" + coverType + "'" +
            ", publisher='" + publisher + "'" +
            ", publishDate='" + publishDate + "'" +
            ", numOfPages='" + numOfPages + "'" +
            ", language='" + language + "'" +
            ", bookCategory='" + bookCategory + "'" +
            "}";
    }
}
//Vi phạm tiêu chí SOLID
//SRP:Class Book có nhiều trách nhiệm,quản lý Book,tương tác với Database thông qua 'getMediaById'
//DIP:Class Book phụ thuộc trực tiếp vào 'Statement' và 'ResultSet' => khó tái sử dụng
//Solution:
//SRP:Tách class Book thành các lớp nhỏ hơn 
//DIP:Sử dụng Dependency Injection để cung cấp 'Statement' và 'ResultSet' từ bên ngoài Book
