package com.consulting.fuse.poc.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.consulting.fuse.poc.exception.HandledException;
import com.consulting.fuse.poc.exception.NonHandledException;

@Component
public class RouteBuilderLog extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		onException(HandledException.class).handled(true).log("${body}");
		
		/*
		 * The  focus of this route is to demonstrate the below events:
		 * ExchangeCreatedEvent
		 * ExchangeSendingEvent
		 * ExchangeSentEvent
		 * ExchangeCompletedEvent
		 */
		from("file:trigger/?fileName=test-a.txt&noop=false")
		.routeId("route-a")		
		.to("bean:processorA")			
		.log("### :: The step to(\"bean:processorA\") was executed")
		;
		
		/*The  focus of this route is to demonstrate the below events:	 
		 * ExchangeFailedEvent
		 */
		from("file:trigger/?fileName=no-handled-exception.txt&noop=false&moveFailed=failed")
		.routeId("route-non-handled-exception")
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
			
				if (null == exchange.getIn().getHeader("fooHeader")) {
					
					throw new NonHandledException("Exception throwed to test");
					
				}			

			}
		})
		.log("NonHandledException occur ")
		;
		
		/*The  focus of this route is to demonstrate the below events:	 
		 * ExchangeFailureHandlingEvent
		 * ExchangeFailedEvent
		 */
		from("file:trigger/?fileName=handled-exception.txt&noop=false&moveFailed=failed")
		.routeId("route-handled-exception")
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
			
				if (null == exchange.getIn().getHeader("fooHeader")) {
					
					throw new HandledException("Exception throwed to test");
					
				}			

			}
		})
		;

		
	}

}
