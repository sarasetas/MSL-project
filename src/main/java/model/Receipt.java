package model;

import java.io.Serializable;

public class Receipt implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int receiptSequence;
	
	private String originalReceiptNumberCode;
	
	public int getReceiptSequence() {
		return receiptSequence;
	}

	public void setReceiptSequence(int receiptSequence) {
		this.receiptSequence = receiptSequence;
	}

	public String getOriginalReceiptNumberCode() {
		return originalReceiptNumberCode;
	}

	public void setOriginalReceiptNumberCode(String originalReceiptNumber) {
		this.originalReceiptNumberCode = originalReceiptNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
