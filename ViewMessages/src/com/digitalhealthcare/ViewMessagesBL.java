
package com.digitalhealthcare;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class ViewMessagesBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ViewMessagesDAO viewMessagesDAO=(ViewMessagesDAO)ctx.getBean("viewMessages");


	public CISResults viewMessages(ViewMessagesModel viewMessages) {
		final Logger logger = Logger.getLogger(ViewMessagesBL.class);
		
		CISResults cisResult = viewMessagesDAO.viewMessages(viewMessages.getUserId(),viewMessages.getPatientId(),viewMessages.getMessageId(),viewMessages.getAptId(),viewMessages.getMessageText(),viewMessages.getPhoneNumber(),viewMessages.getEmailId(),viewMessages.getCreateDate(),viewMessages.getMessageType());
		logger.info("DigitalHealthCare:view messages BL  service" +cisResult );
		return cisResult;
	}
	

}
