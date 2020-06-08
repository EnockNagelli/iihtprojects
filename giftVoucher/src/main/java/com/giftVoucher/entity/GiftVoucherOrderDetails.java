package com.giftVoucher.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.hibernate.exception.ConstraintViolationException;
//import org.hibernate.validator.constraints.Email;

/**
 * @author Nagelli Enock
 */

@Entity
@Table(name = "GiftVoucherOrderDetails")
public class GiftVoucherOrderDetails implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private int orderId;

	@Size(min = 5, max = 30)
	@Column(name = "buyerFirstName")
	private String buyerFirstName;

	@Size(min = 3, max = 25)
	@Column(name = "buyerLastName")
	private String buyerLastName;

	@Size(min = 5, max = 30)
	@Column(name = "recipientFirstName")
	private String recipientFirstName;

	@Size(min = 3, max = 25)
	@Column(name = "recipientLastName")
	private String recipienLastName;

	@NotNull
	@Min(0L)
	@Column(name = "giftAmount")
	private Long giftAmount;
	
	@NotNull
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@NotNull
	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shippingId")
	private ShippingAddress shippingId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public String getRecipientFirstName() {
		return recipientFirstName;
	}

	public void setRecipientFirstName(String recipientFirstName) {

		this.recipientFirstName = recipientFirstName;
	}

	public String getRecipienLastName() {
		return recipienLastName;
	}

	public void setRecipienLastName(String recipienLastName) {
		this.recipienLastName = recipienLastName;
	}

	public Long getGiftAmount() {
		return giftAmount;
	}

	public void setGiftAmount(Long giftAmount) {
		this.giftAmount = giftAmount;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ShippingAddress getShippingId() {
		return shippingId;
	}

	public void setShippingId(ShippingAddress shippingId) {
		this.shippingId = shippingId;
	}
}