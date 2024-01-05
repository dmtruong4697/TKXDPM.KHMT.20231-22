//low coupling (data coupling)

package common.exception;;

//functional cohesion
//Đây là một lớp ngoại lệ chuyển đổi từ PaymentException để biểu diễn một lỗi ngoại lệ liên quan đến lỗi máy chủ nội bộ.
public class InternalServerErrorException extends PaymentException {

	public InternalServerErrorException() {
		super("ERROR: Internal Server Error!");
	}

}
