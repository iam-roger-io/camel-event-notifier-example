package com.consulting.fuse.poc.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.consulting.fuse.poc.event.CamelEvents;

@Component
public class Test1Processor  implements Processor {

	public static final Logger LOGGER = LoggerFactory.getLogger(CamelEvents.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
	
		System.out.println("TESTE 1");
		exchange.getIn().setBody("BODY EDITADO STEP 1");
		

	}

}
