package com.consulting.fuse.poc.event;

import java.util.EventObject;

import org.apache.camel.management.event.CamelContextStartedEvent;
import org.apache.camel.management.event.CamelContextStartingEvent;
import org.apache.camel.management.event.CamelContextStoppedEvent;
import org.apache.camel.management.event.CamelContextStoppingEvent;
import org.apache.camel.management.event.ExchangeCompletedEvent;
import org.apache.camel.management.event.ExchangeCreatedEvent;
import org.apache.camel.management.event.ExchangeFailedEvent;
import org.apache.camel.management.event.ExchangeFailureHandledEvent;
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
			
			((ExchangeCreatedEvent) event).getExchange().getIn().setBody("EDITED");
			LOGGER.info("### ExchangeCreatedEvent executed" + eventSequence);
			
		} else if (event instanceof CamelContextStartingEvent) {	
			
			LOGGER.info("### CamelContextStartingEvent" + eventSequence);			
		
		} else if (event instanceof CamelContextStartedEvent) {	
			
			LOGGER.info("### CamelContextStartedEvent executed " + eventSequence);			
			
		} else if (event instanceof RouteAddedEvent) {
						
			LOGGER.info("### RouteAddedEvent executed" + eventSequence);	
			
		} else if (event instanceof RouteStartedEvent) {
			
			LOGGER.info("### RouteStartedEvent executed" + eventSequence);	
			
		} else if (event instanceof RouteStoppedEvent) {
			
			LOGGER.info("### RouteStoppedEvent executed" + eventSequence);				
			
		} else if (event instanceof ExchangeSendingEvent) {		
			
			LOGGER.info("### ExchangeSendingEvent executed" + eventSequence);
			
		} else if (event instanceof ExchangeSentEvent) {	
			
			LOGGER.info("### ExchangeSentEvent executed" + eventSequence);
		
		} else if (event instanceof ExchangeCompletedEvent) {
						
			LOGGER.info("### ExchangeCompletedEvent executed" + eventSequence);
			
		} else if (event instanceof ExchangeFailedEvent) {
			
			LOGGER.info("### ExchangeFailedEvent executed" + eventSequence);
		
		} else if (event instanceof ExchangeFailureHandledEvent ) {
			
			LOGGER.info("### ExchangeFailedEvent executed" + eventSequence);
						
		} else if (event instanceof CamelContextStoppedEvent) {
			
			LOGGER.info("### CamelContextStoppedEvent executed " + eventSequence);
			
		} else if (event instanceof CamelContextStoppingEvent) {
			
			LOGGER.info("### CamelContextStoppingEvent executed " + eventSequence);
		
		} else if (event instanceof CamelContextStoppedEvent) {
			
			LOGGER.info("### CamelContextStoppedEvent executed " + eventSequence);
			
		} else {	
			
			LOGGER.info("### unknown event " + event.getSource().getClass().toGenericString());
		
		}	
		
		eventSequence++;
		
	}

	@Override
	public boolean isEnabled(EventObject event) {
		// TODO Auto-generated method stub
		return true;
	}

}
