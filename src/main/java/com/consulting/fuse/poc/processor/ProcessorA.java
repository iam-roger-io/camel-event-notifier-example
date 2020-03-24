package com.consulting.fuse.poc.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.consulting.fuse.poc.event.CamelEvents;

public class ProcessorA  implements Processor {

	public static final Logger LOGGER = LoggerFactory.getLogger(CamelEvents.class);
	
	public void process(Exchange arg0) throws Exception {
		
		LOGGER.info(" processor executed :) ");
		
	}

}
