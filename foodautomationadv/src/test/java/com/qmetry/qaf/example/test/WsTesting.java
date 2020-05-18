package com.qmetry.qaf.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ws.rest.RestWSTestCase;
import com.sun.jersey.api.client.ClientResponse;

public class WsTesting extends RestWSTestCase {

	@Test(description = "Validate Get Result")
	public void getCallTest() {
		getWebResource("/todos/1").getRequestBuilder().header("accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.method("GET");
		System.out.println("****Message Response ******* " + getResponse().getStatus());
		Assert.assertEquals(getResponse().getStatus().toString(), ClientResponse.Status.OK.toString());
	}

}
