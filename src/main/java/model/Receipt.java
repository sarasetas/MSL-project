package model;

import java.io.Serializable;

public class Receipt implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int receiptSequence;
	
	private String originalReceiptNumber;
	
	public int getReceiptSequence() {
		return receiptSequence;
	}

	public void setReceiptSequence(int receiptSequence) {
		this.receiptSequence = receiptSequence;
	}

	public String getOriginalReceiptNumber() {
		return originalReceiptNumber;
	}

	public void setOriginalReceiptNumber(String originalReceiptNumber) {
		this.originalReceiptNumber = originalReceiptNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
