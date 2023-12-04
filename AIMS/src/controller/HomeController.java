//low coupling (data coupling) 
//HomeController sử dụng lớp Media để lấy danh sách tất cả các phương tiện từ cơ sở dữ liệu, nhưng cũng không có mức độ phụ thuộc cao vào Media đối với HomeController.

package controller;

import java.sql.SQLException;
import java.util.List;

import entity.cart.Cart;
import entity.media.Media;

/**
 * This class controls the flow of events in homescreen
 * @author nguyenlm
 */
public class HomeController extends BaseController{


    /**
     * this method gets all Media in DB and return back to home to display
     * @return List[Media]
     * @throws SQLException
     */
    public List getAllMedia() throws SQLException{
        return new Media().getAllMedia();
    }

}
