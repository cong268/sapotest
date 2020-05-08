* Mô tả tưng bước để chạy :
  + Import project vào eclipse với Maven project
  + Run Application.java hoặc run project với Spring Boot
  + API chỉnh sửa cấu hình tích điểm :
      - Sử dụng Postman
      - Chạy URL : http://localhost:8081/sapotest/updateConfig?rate=100 với method GET với rate là giá trị cấu hình tích điểm
  + API ghi nhận các giao dịch : 
      - Sử dụng Postman
      - Chạy URL : http://localhost:8081/sapotest/transaction với method POST
      - Body JSON : {
                      	"cardId" : 1,  //Là trường thông tin ID do client truyền vào
	                      "spentNum" : 3040000,   //Giá trị doanh thu
	                      "createOn" : "12/18/2019"   // Ngày giao dịch 
                    } 
   + Chạy Unit Test
      - Run TransactionTest với JUnit Test, kiểm tra dữ liệu trong DB
     
 * Câu hỏi bổ sung :
    + Trong trường hợp cấu hình quy đổi điểm thay đổi : Sửa lại bảng Config, bổ sung thêm fromTime, toTime. Sau đó dựa vào thời gian giao       dịch để lấy ra cấu hình quy đổi điểm tương ứng.
    + Để tăng hiệu năng hệ thống : 
      - Tối ưu logic code để đảm bảo xử lý giao dịch nhanh và chính xác
      - Tối ưu database: cấu trúc các tables, đánh index các trường
      - Tối ưu server: thiết lập load balancing
