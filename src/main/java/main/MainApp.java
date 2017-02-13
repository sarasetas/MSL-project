package main;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import model.Receipt;
import operation.ReceiptOperation;

@Component
public class MainApp {
	
/** Program logger **/
private static final Logger LOG = LoggerFactory.getLogger(MainApp.class);
	
//@Autowired
//private ReceiptOperation receiptOperation;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		Date today = new Date(cal.getTimeInMillis()); 
				    	
		try{ 
			
			ApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/spring/config/bean-location.xml");
			//MainApp mainApp = appContext.getBean(MainApp.class);
			ReceiptOperation receiptOperation = (ReceiptOperation) appContext.getBean("receiptOperation");		    

		     /** insert **/
		     Receipt receipt = new Receipt();
		    		    	
		     receipt.setReceiptSequence(123456158);
		     receipt.setOriginalReceiptNumberCode("XPTO6");
		     receipt.setLastUpdateTimestamp(today);

		     receiptOperation.insertReceipt(receipt);
		     System.out.println("receipt inserted:" + receipt.getReceiptSequence() + ", " + receipt.getOriginalReceiptNumberCode());
		}
		catch(Exception e){
    		LOG.error(ExceptionUtils.getStackTrace(e));
			System.out.println( ExceptionUtils.getStackTrace(e));
		}
		  
	}

}
