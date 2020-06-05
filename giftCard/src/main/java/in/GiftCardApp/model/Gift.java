package in.GiftCardApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "Gift")
public class Gift {
	@Id
	@Column(name = "giftId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int giftId;

	@Column(name = "giftName")
	private String giftName;
	
	@Column(name = "giftCardPrice")
	private long giftCardPrice;

	public int getGiftId() {
		return giftId;
	}

	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public long getGiftCardPrice() {
		return giftCardPrice;
	}

	public void setGiftCardPrice(long giftCardPrice) {
		this.giftCardPrice = giftCardPrice;
	}
}
