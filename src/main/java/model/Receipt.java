package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receipt", propOrder = {
		"receiptSequence", "originalReceiptNumberCode", "lastUpdateTimestamp"})
@XmlRootElement
public class Receipt implements Serializable  {

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "ReceiptSequence")
	 private int receiptSequence;
	
	@XmlElement(name = "OriginalReceiptNumberCode")
	private String originalReceiptNumberCode;
	
	@XmlElement(name = "LastUpdateTimestamp")
	private Date lastUpdateTimestamp;
	
	public Receipt(){
		super();
	}
	
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

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastUpdateTimestamp(){
		return lastUpdateTimestamp;
	}
	
	public void setLastUpdateTimestamp(Date lastUpdateTimestamp){
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
