package com.tirmizee.backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.api.product.data.ProductDTO;
import com.tirmizee.backend.api.product.data.SearchProductDTO;
import com.tirmizee.core.repository.ProductRepositoryImpl;

@Repository
public class ProductDaoImpl extends ProductRepositoryImpl implements ProductDao{
	
	public static final RowMapper<ProductDTO> PRODUCT_MAPPER = new RowMapper<ProductDTO>() {
		@Override
		public ProductDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(rs.getLong(COL_PRODUCTID));
			productDTO.setProductCode(rs.getString(COL_PRODUCTCODE));
			productDTO.setProductName(rs.getString(COL_PRODUCTNAME));
			productDTO.setProductDesc(rs.getString(COL_PRODUCTDESC));
			productDTO.setProductImage(rs.getString(COL_PRODUCTIMAGE));
			productDTO.setProductPrice(rs.getBigDecimal(COL_PRODUCTPRICE));
			productDTO.setCreateDate(rs.getDate(COL_CREATEDATE));
			return productDTO;
		}
	};

	@Override
	public Page<ProductDTO> findByCritria(SearchProductDTO search, Pageable pageable) {
		
		List<Object> params = new LinkedList<>();
		
		StringBuilder statement = new StringBuilder()
			.append(" SELECT ")
				.append(COL_PRODUCTID).append(" , ")
				.append(COL_PRODUCTCODE).append(" , ")
				.append(COL_PRODUCTNAME).append(" , ")
				.append(COL_PRODUCTDESC).append(" , ")
				.append(COL_PRODUCTPRICE).append(" , ")
				.append(COL_PRODUCTIMAGE).append(" , ")
				.append(COL_CREATEDATE)
			.append(" FROM ").append(TABLE_PRODUCTS)
			.append(" WHERE ").append(COL_PRODUCTID).append(" IS NOT NULL ");
		if (search.getProductCode() != null) {
			statement.append(" AND ").append(COL_PRODUCTCODE).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getProductCode()) + "%");
		}
		if (search.getProductName() != null) {
			statement.append(" AND ").append(COL_PRODUCTNAME).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getProductName()) + "%");
		}
		if (search.getProductPrice() != null) {
			statement.append(" AND ").append(COL_PRODUCTPRICE);
			switch (search.getProductPrice()) {
				case "1" : statement.append(" < 1000"); break;
				case "2" : statement.append(" BETWEEN 1000 AND 10000 "); break;
				case "3" : statement.append(" BETWEEN 10000 AND 50000 "); break;
				case "4" : statement.append(" BETWEEN 50000 AND 100000 "); break;
				case "5" : statement.append(" > 100000"); break;
				default :  statement.append(" > 0"); break;
			}
		}
		
		String statementPage = getSqlGenerator().selectAll(getTable(), statement, pageable);
		List<ProductDTO> content = getJdbcOps().query(statementPage, params.toArray(),PRODUCT_MAPPER );
		Long total = count(statement.toString(), params.toArray());
		
		return new PageImpl<>(content, pageable, total);
	}

	@Override
	public Boolean existsImageName(String imgName) {
		StringBuilder select = new StringBuilder()
			.append("SELECT COUNT(*) FROM ").append(TABLE_PRODUCTS)
			.append(" WHERE ").append(COL_PRODUCTIMAGE)
			.append(" = ? ");
		Long count = getJdbcOps().queryForObject(select.toString(), Long.class, params(imgName));
		return count > 0;
	}
	
}
