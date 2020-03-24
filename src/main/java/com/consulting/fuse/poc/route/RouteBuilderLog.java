package com.consulting.fuse.poc.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RouteBuilderLog extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		onException(Exception.class).handled(true).to("mock:exception");
		
		from("file:trigger/?fileName=testa.txt&noop=false")
		.routeId("route-a")
				
		.log("next step to(\"bean:test1Processor\") will be executed")	
		.to("bean:test1Processor")			
		.log("next step to(\"bean:test1Processor\") executed")
		;

		from("file:trigger/?fileName=testb.txt&noop=false&moveFailed=trigger/tmp/failed.txt")
		.routeId("route-b")
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
			
				if (null == exchange.getIn().getHeader("fooHeader")) {
					
					throw new Exception("Exception throwed to test");
					
				}
				

			}
		})

		.to("mock:route-b");
		
	}

}
