package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CD extends Media {//Functional Cohesion:manage information about CD,Procedural Cohesion

    String artist;
    String recordLabel;
    String musicType;
    Date releasedDate;

    public CD() throws SQLException{

    }

    public CD(int id, String title, String category, int price, int quantity, String type, String artist,
            String recordLabel, String musicType, Date releasedDate) throws SQLException{
        super(id, title, category, price, quantity, type);
        this.artist = artist;
        this.recordLabel = recordLabel;
        this.musicType = musicType;
        this.releasedDate = releasedDate;
    }

    public String getArtist() {
        return this.artist;
    }

    public CD setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public String getRecordLabel() {
        return this.recordLabel;
    }

    public CD setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
        return this;
    }

    public String getMusicType() {
        return this.musicType;
    }

    public CD setMusicType(String musicType) {
        this.musicType = musicType;
        return this;
    }

    public Date getReleasedDate() {
        return this.releasedDate;
    }

    public CD setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + " artist='" + artist + "'" + ", recordLabel='" + recordLabel + "'"
                + "'" + ", musicType='" + musicType + "'" + ", releasedDate='"
                + releasedDate + "'" + "}";
    }

    @Override
    public Media getMediaById(int id) throws SQLException {//CD and Media data coupling through getMediaById
        String sql = "SELECT * FROM "+                     //Communicational Cohesion:comunicate with database
                     "aims.CD " +
                     "INNER JOIN aims.Media " +
                     "ON Media.id = CD.id " +
                     "where Media.id = " + id + ";";
        ResultSet res = stm.executeQuery(sql); //CD and ResultSet data coupling through getMediaById
		if(res.next()) {
            
            // from media table
            String title = "";
            String type = res.getString("type"); 
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from CD table
            String artist = res.getString("artist");
            String recordLabel = res.getString("recordLabel");
            String musicType = res.getString("musicType");
            Date releasedDate = res.getDate("releasedDate");
           
            return new CD(id, title, category, price, quantity, type, 
                          artist, recordLabel, musicType, releasedDate);
            
		} else {
			throw new SQLException();
		}
    }

    @Override
    public List getAllMedia() {
        return null;
    }

}
//Vi phạm tiêu chí SOLID
//SRP:Class CD thực hiện nhiều trách nhiệm,quản lý CD,tương tác với Database thông qua 'getMediaById'
//DIP:Class CD phụ thuộc trực tiếp 'ResultSet' và 'stm' => khó tái sử dụng và khó kiểm thử 
//Solution:
//SRP:Tách class CD thành các lớp nhỏ hơn
//DIP:Sử dụng Dependency Injection để cung cấp 'ResultSet' và 'stm' từ bên ngoài 