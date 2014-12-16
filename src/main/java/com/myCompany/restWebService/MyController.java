package com.myCompany.restWebService;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.myCompany.soapWebService.MyWebService;

//import com.myCompany.soapWebService.MyWebService;

@Component
@Controller
@RequestMapping("/myCompany")
public class MyController {
	
	MyWebService myWebService;
	
	public MyWebService getMyWebService() {
		return myWebService;
	}

	public void setMyWebService(MyWebService myWebService) {
		this.myWebService = myWebService;
	}

	@RequestMapping(value = "/myService", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String get() {
		String s = myWebService.methode();
		return s;
	}
}
