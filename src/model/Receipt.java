package model;

import javax.persistence.Table;

@Table(name="Receipt")
public class Receipt {

	private int receiptSequence;
	
	public String receiptNumber;
	
	public Receipt() {};
	
	public Receipt(int receiptSequence, String receiptNumber) {
		this.receiptSequence = receiptSequence;
		this.receiptNumber = receiptNumber;
	}
	
	public int getReceiptSequence() {
		return receiptSequence;
	}
	
	public String getReceiptNumber() {
		return receiptNumber;
	}
	
	public void setReceiptSequence(int receiptSequence) {
		this.receiptSequence = receiptSequence;
	}
	
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

}

