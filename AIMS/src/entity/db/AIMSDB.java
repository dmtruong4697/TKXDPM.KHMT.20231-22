//Mức Độ Coupling: Moderate (control coupling)
//Lớp AIMSDB chịu trách nhiệm khởi tạo và duy trì kết nối đến cơ sở dữ liệu SQLite.
//Sự phụ thuộc này được thể hiện trong phương thức getConnection, nơi mà lớp này kiểm soát quá trình thiết lập kết nối và trả về đối tượng kết nối.

// control cohesion
// Lớp AIMSDB chịu trách nhiệm cho việc quản lý kết nối đến cơ sở dữ liệu. Phương thức getConnection() tạo và trả về một đối tượng Connection đến cơ sở dữ liệu SQLite. Cả lớp liên quan đến việc quản lý kết nối và thực hiện các thao tác cơ bản liên quan đến cơ sở dữ liệu.
package entity.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import java.sql.Connection;
import utils.*;

public class AIMSDB {

	private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
	private static Connection connect;

    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
			Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:assets/db/aims.db";
            connect = DriverManager.getConnection(url);
            LOGGER.info("Connect database successfully");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } 
        return connect;
    }
    

    public static void main(String[] args) {
        AIMSDB.getConnection();
    }
}
