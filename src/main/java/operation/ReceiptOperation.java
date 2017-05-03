package operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Receipt;
import service.ReceiptService;

@Component
public class ReceiptOperation {

	@Autowired
	private ReceiptService receiptService;
	
	public void insertReceipt(Receipt receipt) {
		receiptService.saveReceipt(receipt);
		
	}
	
	public void removeReceipt (Receipt receipt){
		receiptService.removeReceipt(receipt);
	}
	
	public void updateReceipt (Receipt receipt){
		receiptService.updateReceipt(receipt);
	}
}
