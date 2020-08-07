package kr.co.jhta.vo;

public class Delivery {

	private int no;
	private String username;
	private String tel;
	private String address;
	private String status;
	private long orderNo;
	
	public Delivery() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "Delivery [no=" + no + ", username=" + username + ", tel=" + tel + ", address=" + address + ", status="
				+ status + ", orderNo=" + orderNo + "]";
	}
	
}
