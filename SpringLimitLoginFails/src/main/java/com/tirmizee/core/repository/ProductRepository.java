package com.tirmizee.core.repository;

import com.tirmizee.core.domain.Product;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface ProductRepository extends JdbcRepository<Product, Long> {
	
	public static final String TABLE_PRODUCTS = "Products";
	public static final String COL_PRODUCTID = "ProductId";
	public static final String COL_PRODUCTCODE = "ProductCode";
	public static final String COL_PRODUCTNAME = "ProductName";
	public static final String COL_PRODUCTDESC = "ProductDesc";
	public static final String COL_PRODUCTIMAGE = "ProductImage";
	public static final String COL_PRODUCTPRICE = "ProductPrice";
	public static final String COL_CREATEDATE = "CreateDate";
	public static final String COL_UPDATEDATE = "UpdateDate";

	public static final String PRODUCTID = "Products.ProductId";
	public static final String PRODUCTCODE = "Products.ProductCode";
	public static final String PRODUCTNAME = "Products.ProductName";
	public static final String PRODUCTDESC = "Products.ProductDesc";
	public static final String PRODUCTIMAGE = "Products.ProductImage";
	public static final String PRODUCTPRICE = "Products.ProductPrice";
	public static final String CREATEDATE = "Products.CreateDate";
	public static final String UPDATEDATE = "Products.UpdateDate";

}
