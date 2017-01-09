package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bo.GenericBo;
import model.Receipt;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext =  new ClassPathXmlApplicationContext("META-INF/spring/config/bean-location.xml");

		
				GenericBo<Receipt, Integer> receiptBo = (GenericBo)appContext.getBean("ReceiptBo");

		    	/** insert **/
		    	Receipt receipt = new Receipt();
		    	
		    	receipt.setReceiptSequence(12345);
		    	receipt.setOriginalReceiptNumberCode("XPTO");
		    	
		    	try{ 
		    		receiptBo.save(receipt);
		    		System.out.println("receipt inserted:" + receipt.getReceiptSequence() + ", " + receipt.getOriginalReceiptNumberCode());
		    		}
		    	catch(Exception e){
		    		System.out.println(e);
		    	}
		  
		    	
		    	
		    	
		   
		    	/** select 
		    	Stock stock2 = stockBo.findByStockCode("7668");
		    	System.out.println(stock2);

		    	/** update 
		    	stock2.setStockName("HAIO-1");
		    	stockBo.update(stock2);

		    	/** delete
		    	stockBo.delete(stock2);

		    	System.out.println("Done");
		    	**/
	}

}
