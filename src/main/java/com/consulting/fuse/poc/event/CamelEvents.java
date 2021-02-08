package com.consulting.fuse.poc.event;

import java.util.EventObject;

import org.apache.camel.management.event.CamelContextStartedEvent;
import org.apache.camel.management.event.CamelContextStartingEvent;
import org.apache.camel.management.event.CamelContextStartupFailureEvent;
import org.apache.camel.management.event.CamelContextStoppedEvent;
import org.apache.camel.management.event.CamelContextStoppingEvent;
import org.apache.camel.management.event.ExchangeCompletedEvent;
import org.apache.camel.management.event.ExchangeCreatedEvent;
import org.apache.camel.management.event.ExchangeFailedEvent;
import org.apache.camel.management.event.ExchangeFailureHandledEvent;
import org.apache.camel.management.event.ExchangeFailureHandlingEvent;
import org.apache.camel.management.event.ExchangeSendingEvent;
import org.apache.camel.management.event.ExchangeSentEvent;
import org.apache.camel.management.event.RouteAddedEvent;
import org.apache.camel.management.event.RouteStartedEvent;
import org.apache.camel.management.event.RouteStoppedEvent;
import org.apache.camel.support.EventNotifierSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CamelEvents extends EventNotifierSupport {

	public static final Logger LOGGER = LoggerFactory.getLogger(CamelEvents.class);
	
	private Integer eventSequence = 1;
	
	@Override
	public void notify(EventObject event) throws Exception {
		
		if (event instanceof ExchangeCreatedEvent) {
			eventSequence = 1;
			LOGGER.info("### [EVENT] ExchangeCreatedEvent executed. Execution order:  " + eventSequence);
			
		} else if (event instanceof CamelContextStartingEvent) {	
			
			LOGGER.info("### [EVENT] CamelContextStartingEvent executed" + eventSequence);			
		
		} else if (event instanceof CamelContextStartedEvent) {	
			
			LOGGER.info("### [EVENT] CamelContextStartedEvent executed. Execution order:  " + eventSequence);			

		} else if (event instanceof CamelContextStartupFailureEvent) {	
			
			LOGGER.info("### [EVENT] CamelContextStartupFailureEvent" + eventSequence);			
			
		} else if (event instanceof RouteAddedEvent) {
						
			LOGGER.info("### [EVENT] RouteAddedEvent executed" + eventSequence);	
			
		} else if (event instanceof RouteStartedEvent) {
			
			LOGGER.info("### [EVENT] RouteStartedEvent executed" + eventSequence);	
			
		} else if (event instanceof RouteStoppedEvent) {
			
			LOGGER.info("### [EVENT] RouteStoppedEvent executed" + eventSequence);				
			
		} else if (event instanceof ExchangeSendingEvent) {		
			
			LOGGER.info("### [EVENT] ExchangeSendingEvent executed" + eventSequence);
			
		} else if (event instanceof ExchangeSentEvent) {	
			
			String body = ((ExchangeSentEvent) event).getExchange().getIn().getBody(String.class);
			((ExchangeSentEvent) event).getExchange().getIn().setBody("BODY EDITED BY EVENT");
			LOGGER.info("### [EVENT] ExchangeSentEvent executed" + eventSequence + " ::  Change  Value:" + body + " to " + " BODY EDITED BY EVENT");
		
		} else if (event instanceof ExchangeCompletedEvent) {
						
			LOGGER.info("### [EVENT] ExchangeCompletedEvent executed" + eventSequence);
			
		} else if (event instanceof ExchangeFailedEvent) {
			
			LOGGER.info("### [EVENT] ExchangeFailedEvent executed" + eventSequence);
		
		} else if (event instanceof ExchangeFailureHandlingEvent ) {			
			
			LOGGER.info("### [EVENT] ExchangeFailureHandlingEvent executed" + eventSequence);
			
		} else if (event instanceof ExchangeFailureHandledEvent ) {
			
			LOGGER.info("### [EVENT] ExchangeFailedEvent executed" + eventSequence);
						
		} else if (event instanceof CamelContextStoppedEvent) {
			
			LOGGER.info("### [EVENT] CamelContextStoppedEvent executed. Execution order:  " + eventSequence);
			
		} else if (event instanceof CamelContextStoppingEvent) {
			
			LOGGER.info("### [EVENT] CamelContextStoppingEvent executed. Execution order:  " + eventSequence);
		
		} else if (event instanceof CamelContextStoppedEvent) {
			
			LOGGER.info("### [EVENT] CamelContextStoppedEvent executed. Execution order:  " + eventSequence);
			
		} else {	
			
			LOGGER.info("### [EVENT] unknown event " + event.getSource().getClass().toGenericString());
		
		}	
		
		eventSequence++;
		
	}

	@Override
	public boolean isEnabled(EventObject event) {
		return true;
	}

}
