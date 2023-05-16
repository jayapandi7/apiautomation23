package com.manager;

import com.payload.Addresspayload;
import com.payload.ProductPayLoad;

public class PayloadManager {
	
	private Addresspayload addresspayload;
	private ProductPayLoad productPayLoad;
	
	public Addresspayload getAddresspayload() {
		return (addresspayload==null) ? addresspayload=new Addresspayload():addresspayload;
	}
	public ProductPayLoad getProductPayLoad() {
		return (productPayLoad==null) ? productPayLoad=new ProductPayLoad():productPayLoad;
	}

}
