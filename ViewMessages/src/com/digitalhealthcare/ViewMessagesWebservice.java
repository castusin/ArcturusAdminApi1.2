
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class ViewMessagesWebservice {

	public CISResults viewMessages(ViewMessagesModel viewMessages) {
		 ViewMessagesBL viewMessagesBL = new ViewMessagesBL();
		 Logger logger = Logger.getLogger(ViewMessagesWebservice.class);
		 CISResults cisResult = viewMessagesBL.viewMessages(viewMessages);
		 logger.info("  view messages webservice :"+cisResult);
		return cisResult;
	}

}
