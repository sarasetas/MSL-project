package main;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import model.Receipt;
import operation.ReceiptOperation;

@Component
public class MainApp {
	
	@Autowired
	private ReceiptOperation receiptOperation;
	
	/** Program logger **/
	private static final Logger LOG = LoggerFactory.getLogger(MainApp.class);
	private static ApplicationContext appContext =  new ClassPathXmlApplicationContext("META-INF/spring/config/bean-location.xml");
	
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// to define static
	 //	MainApp mainApp = appContext.getBean(MainApp.class);
		
		//GenericBo receiptBo = (GenericBo)appContext.getBean("receiptBo");

		    	/** insert **/
		    	Receipt receipt = new Receipt();
		    	
		    	receipt.setReceiptSequence(123456);
		    	receipt.setOriginalReceiptNumberCode("XPTO2");
		    	
		    	try{ 
		    		mainApp.receiptOperation.insertReceipt(receipt);
		    	//	receiptBo.save(receipt);
		    		System.out.println("receipt inserted:" + receipt.getReceiptSequence() + ", " + receipt.getOriginalReceiptNumberCode());
		    		}
		    	catch(Exception e){
		    		LOG.error(ExceptionUtils.getStackTrace(e));
		    		System.out.println(receipt.getOriginalReceiptNumberCode() + receipt.getReceiptSequence() + ExceptionUtils.getStackTrace(e));
		    	}
		  
	}

}
