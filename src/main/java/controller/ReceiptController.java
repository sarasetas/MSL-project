package controller;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Receipt;
import operation.ReceiptOperation;
 
@Controller
public class ReceiptController {
 
    @Autowired
    private ReceiptOperation receiptOperation;

	Receipt receipt = new Receipt();
	
    @RequestMapping(value="/receipt")
    public ModelAndView receipt(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
        	receipt.setReceiptSequence(123456779);
        	receipt.setOriginalReceiptNumberCode(name);
        	receiptOperation.insertReceipt(receipt);
        // Prepare the result view (guest.jsp):
        return new ModelAndView("receipt.jsp");
    }
}