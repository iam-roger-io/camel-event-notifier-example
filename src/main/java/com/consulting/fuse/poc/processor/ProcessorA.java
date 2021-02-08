package com.consulting.fuse.poc.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProcessorA  implements Processor {

	public static final Logger LOGGER = LoggerFactory.getLogger(ProcessorA.class);
	
	public void process(Exchange exchange) throws Exception {
		
		LOGGER.info("### :: ProcessorA executed :) ");
				
	}

}
