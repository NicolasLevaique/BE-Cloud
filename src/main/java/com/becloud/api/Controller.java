package com.becloud.api;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class Controller {
	
	private static Logger LOGGER = Logger.getLogger(Controller.class);
	
	/**
	 * Constructor. Connect to the DB
	 */
	public Controller() {
	}

	@RequestMapping(value="/templates", method=RequestMethod.GET)
	public String getTemplates() {
		LOGGER.info("Get templates called!");
		LOGGER.info("Returns list of templates");
		JSONObject listTemplates = new JSONObject();
		JSONArray templates = new JSONArray();
		templates.put("ubuntu");
		templates.put("windows");
		listTemplates.put("templates", templates);
		return listTemplates.toString();
	}
	
	@RequestMapping(value="/rights", method=RequestMethod.GET)
	public String getUserRights() {
		LOGGER.info("Get user rights called!");
		LOGGER.info("Returns list of user rights");
		JSONObject listUserRights = new JSONObject();
		JSONObject userRights = new JSONObject();
		userRights.put("admin", "create VM, delete VM, create subnet");
		userRights.put("user", "start VM, stop VM");
		listUserRights.put("userRights", userRights);
		return listUserRights.toString();
	}
	
	@RequestMapping(value="/vm", method=RequestMethod.POST)
	public String createVM(String nodename, String machineTemplate, Integer rightsId) {
		LOGGER.info("Creating a VM with nodename : [" + nodename + "], machine template : [" + machineTemplate + "] and rightsId : [" + rightsId + "]");
		JSONObject result = new JSONObject();
		
		// simulate error cases
		if (Math.random() > 0.9) {
			if (Math.random() > 0.5)
				result.put("error", "bad bug !");
			else
				result.put("rightsError", "You have no rights here !");
		}
		else {
			// generates vmId between min and max
			int min = 1;
			int max = 10000;
			int vmId = min + (int) (Math.random() * ((max - min) + 1));
			result.put("vmId", vmId);
			result.put("ipAdress", "192.168.2.1");
		}
		
		return result.toString();
	}
	
	@RequestMapping(value="/vm/{vmId}", method=RequestMethod.DELETE)
	public String deleteVM(@PathVariable("vmId") String vmId, Integer rightsId) {
		LOGGER.info("Deleting a VM with vmId : [" + vmId + "] and rightsId : [" + rightsId + "]");
		JSONObject result = new JSONObject();
		
		// simulate error cases
		if (Math.random() > 0.9) {
			if (Math.random() > 0.5)
				result.put("error", "bad bug !");
			else
				result.put("rightsError", "You have no rights here !");
		}
		else {
			result.put("success", "true");
		}
		
		return result.toString();
	}
	
	@RequestMapping(value="/vm/{vmId}/start", method=RequestMethod.POST)
	public String startVM(@PathVariable("vmId") String vmId, Integer rightsId) {
		LOGGER.info("Starting a VM with vmId : [" + vmId + "] and rightsId : [" + rightsId + "]");
		JSONObject result = new JSONObject();
		
		// simulate error cases
		if (Math.random() > 0.9) {
			if (Math.random() > 0.5)
				result.put("error", "bad bug !");
			else
				result.put("rightsError", "You have no rights here !");
		}
		else {
			result.put("success", "true");
		}
		
		return result.toString();
	}
	
	@RequestMapping(value="/vm/{vmId}/stop", method=RequestMethod.POST)
	public String stopVM(@PathVariable("vmId") String vmId, Integer rightsId) {
		LOGGER.info("Stoping a VM with vmId : [" + vmId + "] and rightsId : [" + rightsId + "]");
		JSONObject result = new JSONObject();
		
		// simulate error cases
		if (Math.random() > 0.9) {
			if (Math.random() > 0.5)
				result.put("error", "bad bug !");
			else
				result.put("rightsError", "You have no rights here !");
		}
		else {
			result.put("success", "true");
		}
		
		return result.toString();
	}
	
	@RequestMapping(value="/subnet", method=RequestMethod.POST)
	public String createSubnet(String vmTemplate, Integer vmNb) {
		LOGGER.info("Creating a subnet with vmTemplate : [" + vmTemplate + "] and vmNb : [" + vmNb + "]");
		JSONObject result = new JSONObject();
		
		// simulate error cases
		if (Math.random() > 0.9) {
			if (Math.random() > 0.5)
				result.put("error", "bad bug !");
			else
				result.put("rightsError", "You have no rights here !");
		}
		else {
			// generates vmId between min and max
			int min = 1;
			int max = 10000;
			int subId = min + (int) (Math.random() * ((max - min) + 1));
			result.put("subId", subId);
			JSONArray listIpAddresses = new JSONArray();
			for (int i=0; i<vmNb; i++) {
				listIpAddresses.put("192.168.2."+i);
			}
			result.put("ipAdressList", listIpAddresses);
		}
		
		return result.toString();
	}

}