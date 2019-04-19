package com.hcl.cloud.product.datatranslator;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import com.hcl.cloud.product.request.CreateproductReq;
import com.hcl.cloud.product.response.ViewproductRes;

/**
 * 
 * @author BrijendraK
 *
 */
public class ViewProductsResponseTranslator {
	static Logger log = LoggerFactory.getLogger(ViewProductsResponseTranslator.class);

	/**
	 * This method is used as translator from backend to frontend.
	 * 
	 * @param pList
	 * @param env
	 * @return
	 */
	public ViewproductRes viewProductsResponseTranslator(List<CreateproductReq> pList, Environment env) {
		log.info("Response translation from backend to frontend start");
		List<CreateproductReq> productsList = new ArrayList<CreateproductReq>();
		ViewproductRes viewproductRes = new ViewproductRes();
		for (CreateproductReq products : pList) {
			if (products.isIs_deleted() == false) {
				productsList.add(products);
			}
		}
		viewproductRes.setProductList(productsList);
		log.info("Response translation from backend to frontend end");
		return viewproductRes;

	}

}
