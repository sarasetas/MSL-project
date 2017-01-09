package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import bo.GenericBo;
import model.Receipt;

@Component
public class ReceiptService {

	@Autowired
	@Qualifier("receiptBo")
	GenericBo<Receipt, Integer> receiptBo;
	
	/** **/
			
	public void saveReceipt(Receipt receipt)
	{
		receiptBo.save(receipt);
	}

	
	 /* Flush and Clear session for batch process
	 */
	public void flushClearSession() {
		receiptBo.getCurrentSession().flush();
		receiptBo.getCurrentSession().clear();
	}

	
}
