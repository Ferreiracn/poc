package com.myorg.tutorial.epmproducts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.cloud.sdk.service.prov.api.operations.Query;
import com.sap.cloud.sdk.service.prov.api.request.QueryRequest;
import com.sap.cloud.sdk.service.prov.api.response.ErrorResponse;
import com.sap.cloud.sdk.service.prov.api.response.QueryResponse;

public class EPMSampleService {
	public List<Map<String, Object>> getSampleProducts() {
		List<Map<String, Object>> products = new ArrayList<Map<String, Object>>();

		Map<String, Object> productEntity1 = new HashMap<String, Object>();
		productEntity1.put("ProductID", 1);
		productEntity1.put("Name", "Laptop");
		productEntity1.put("Description", "Professional Laptop");
		productEntity1.put("Category", "Computers");
		products.add(productEntity1);

		Map<String, Object> productEntity2 = new HashMap<String, Object>();
		productEntity2.put("ProductID", 2);
		productEntity2.put("Name", "Monitor");
		productEntity2.put("Description", "24-inch Desktop Monitor");
		productEntity1.put("Category", "Display Monitors");
		products.add(productEntity2);

		return products;
	}
	
	// HTTP Status Code
		private static final int INTERNAL_SERVER_ERROR = 500;

		/*
		 * This method implements the query operation on the Products entity set of
		 * the EPMSampleService OData service.
		 */
		@Query(serviceName = "EPMSampleService", entity = "Products")
		public QueryResponse getEPMProducts(QueryRequest queryRequest) {
			try {

				List<Map<String, Object>> sampleData = this.getSampleProducts();
				return QueryResponse.setSuccess().setData(sampleData).response();
			} catch (Exception e) {
				ErrorResponse errorResponse = ErrorResponse.getBuilder().setMessage(e.getMessage())
						.setStatusCode(INTERNAL_SERVER_ERROR).setCause(e).response();
				return QueryResponse.setError(errorResponse);
			}
		}

}
