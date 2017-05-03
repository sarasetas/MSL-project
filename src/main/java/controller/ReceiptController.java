	package controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Receipt;
import service.ReceiptService;
 
@Controller
public class ReceiptController {
 

   private ReceiptService receiptService;
   
   @RequestMapping(value = "/test", method = RequestMethod.GET)
   public String test (@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
	   model.addAttribute("name", name);
	   return "test";
   }
   
   @RequestMapping(value = "/receipts", method = RequestMethod.GET)
	public String listReceipts(Model model) {
		model.addAttribute("receipt", new Receipt());
//		model.addAttribute("listReceipts", this.receiptService.listReceipts());
		return "receipt";
	}
   
	@RequestMapping(value = "/receipt/add", method = RequestMethod.POST)
	public String addReceipt(Receipt receipt){
		if (receipt.getReceiptSequence() == 0) {
			receiptService.saveReceipt(receipt);
		}else{
			receiptService.updateReceipt(receipt);
		}
		
	return "redirect:/receipts";
	}
	
	
}	