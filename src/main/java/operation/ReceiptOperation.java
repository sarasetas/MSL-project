package operation;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Receipt;
import service.ReceiptService;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class, SQLException.class })
public class ReceiptOperation {

	@Autowired
	private ReceiptService receiptService;
	
	public void insertReceipt(Receipt receipt) {
		receiptService.saveReceipt(receipt);
	}
	
}
