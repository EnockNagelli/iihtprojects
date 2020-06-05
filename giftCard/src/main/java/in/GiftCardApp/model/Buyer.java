package in.GiftCardApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "Buyer")
public class Buyer {	
		@Id
		@Column(name = "buyerId")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int buyerId;

		@Column(name = "buyerFirstName")
		private String buyerFirstName;
		
		@Column(name = "buyerLastName")
		private String buyerLastName;
		
		@Column(name = "buyerName")
		private String buyerName;
		
		@Column(name = "password")
		private String password;
				
		@Column(name = "buyerPhoneNo")
		private String buyerPhoneNo;
		
		@Column(name = "buyerEmailId")
		private String buyerEmailId;

		public int getBuyerId() {
			return buyerId;
		}

		public void setBuyerId(int buyerId) {
			this.buyerId = buyerId;
		}

		public String getBuyerFirstName() {
			return buyerFirstName;
		}

		public void setBuyerFirstName(String buyerFirstName) {
			this.buyerFirstName = buyerFirstName;
		}

		public String getBuyerLastName() {
			return buyerLastName;
		}

		public void setBuyerLastName(String buyerLastName) {
			this.buyerLastName = buyerLastName;
		}

		public String getBuyerName() {
			return buyerName;
		}

		public void setBuyerName(String buyerName) {
			this.buyerName = buyerName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getBuyerPhoneNo() {
			return buyerPhoneNo;
		}

		public void setBuyerPhoneNo(String buyerPhoneNo) {
			this.buyerPhoneNo = buyerPhoneNo;
		}

		public String getBuyerEmailId() {
			return buyerEmailId;
		}

		public void setBuyerEmailId(String buyerEmailId) {
			this.buyerEmailId = buyerEmailId;
		}

		
}
