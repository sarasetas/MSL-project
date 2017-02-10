package persistence.service;

import org.springframework.stereotype.Component;

import bo.GenericBo;
import model.Receipt;

/**
 * This interface describes the methods that expose all SC's business objects.
 * The implementer class is SCPersistenceServiceImpl in the following package
 * pt.victoria.sc.service.SCPersistenceServiceImpl in the sc-persistence-service project
 * 
 * When a new BO is created a new method should be added here and implemented in the impl class.
 * 
 * @author nturkman@maksen.com
 *
 */
@Component
public interface PersistenceService {
	
	
	/** Exposes Receipt entity business object **/
	GenericBo<Receipt, Integer> getReceiptBo();
	
	
	GenericBo<Object, Integer> getXlsErrorListBo();
}
