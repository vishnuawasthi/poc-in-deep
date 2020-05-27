package com.app.utils;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class DynamicRouteDeciderBean {

	public String routetoInvoke(@Header(Exchange.SLIP_ENDPOINT) String previousRoute,@Header("processName") String processName) {

		if (null == previousRoute) {
			return "direct:dynamicRouteDesitinationOne";
		} else if ("StepTwo".equalsIgnoreCase(processName)) {
			return "direct:dynamicRouteDesitinationStepTwo";
		} else if ("StepFinal".equalsIgnoreCase(processName)) {
			return "direct:dynamicRouteDesitinationStepFinal";
		}else if("Over".equalsIgnoreCase(processName)) {
			return null;
		}
		return null;
	}
}
