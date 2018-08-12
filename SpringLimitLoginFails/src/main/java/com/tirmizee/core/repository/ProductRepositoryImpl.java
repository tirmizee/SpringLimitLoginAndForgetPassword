package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Product;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("ProductRepository")
public class ProductRepositoryImpl extends AbstractMssqlRepository<Product, Long> implements ProductRepository {
	
	public ProductRepositoryImpl() {
		this(TABLE_PRODUCTS);
	}

	public ProductRepositoryImpl( String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_PRODUCTID);
	}
	
	public static final RowMapper<Product> ROW_MAPPER = new RowMapper<Product>() {
		@Override
		public Product mapRow(ResultSet rs, int arg1) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getLong(COL_PRODUCTID));
			product.setProductCode(rs.getString(COL_PRODUCTCODE));
			product.setProductName(rs.getString(COL_PRODUCTNAME));
			product.setProductDesc(rs.getString(COL_PRODUCTDESC));
			product.setProductImage(rs.getString(COL_PRODUCTIMAGE));
			product.setProductPrice(rs.getBigDecimal(COL_PRODUCTPRICE));
			product.setCreateDate(rs.getDate(COL_CREATEDATE));
			product.setUpdateDate(rs.getDate(COL_UPDATEDATE));
			return product;
		}
	};
	
	public static final RowUnmapper<Product> ROW_UNMAPPER = new RowUnmapper<Product>() {
		@Override
		public Map<String, Object> mapColumns(Product param) {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(COL_PRODUCTID , param.getProductId());
			map.put(COL_PRODUCTCODE , param.getProductCode());
			map.put(COL_PRODUCTNAME , param.getProductName());
			map.put(COL_PRODUCTDESC , param.getProductDesc());
			map.put(COL_PRODUCTIMAGE , param.getProductImage());
			map.put(COL_PRODUCTPRICE , param.getProductPrice());
			map.put(COL_CREATEDATE , param.getCreateDate());
			map.put(COL_UPDATEDATE , param.getUpdateDate());
			return map;
		}
	};

	@Override
	protected <S extends Product> S postCreate(S entity, Number generatedId) {
		entity.setProductId(generatedId.longValue());
		return entity;
	}

}
