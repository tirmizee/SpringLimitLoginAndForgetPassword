package com.tirmizee.backend.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.tirmizee.backend.dao.MemberImageDao;
import com.tirmizee.backend.dao.ProductDao;
import com.tirmizee.backend.service.StorageProfileImageServiceImpl;
import com.tirmizee.core.annotaion.CurrentUser;
import com.tirmizee.core.annotaion.GetMappingImage;
import com.tirmizee.core.annotaion.GetMappingPdf;
import com.tirmizee.core.component.ResourceHelper;
import com.tirmizee.core.exception.UrlNotFoundException;
import com.tirmizee.core.security.UserProfile;

import net.sf.jasperreports.engine.JREmptyDataSource;

@Controller
@RequestMapping("file")
public class FileController {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private MemberImageDao memberImageDao;

	@Autowired 
	private ApplicationContext appContext;
	
	@GetMappingPdf(path = "/pdf")
	public ModelAndView generatePdf(){
		Map<String, Object> params = new HashMap<>();
		params.put("firstname", "Pratya");
		params.put("datasource", new JREmptyDataSource());
		params.put("logo", ResourceHelper.getPath("picture/checkbox-true.png"));
		JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:report/CS461report.jrxml");
	    view.setApplicationContext(appContext);
	    return new ModelAndView(view, params);
	}
	
	@ResponseBody
	@GetMappingImage( value = "/resource/img/profile")
	public Resource imageProfile(@CurrentUser UserProfile profile) throws NoHandlerFoundException{
		String imgName = memberImageDao.findOne(profile.getFkMemberImgId()).getImgOriginalName();
		Resource resource = new FileSystemResource( StorageProfileImageServiceImpl.UPLOAD_PATH + imgName);
		return resource;
	}
	
	@ResponseBody
	@GetMappingImage( value = "/resource/img/product/{productImgName:.+}")
	public Resource imageProduct(@PathVariable String productImgName) {
		final String PATH = "D:\\ProjectSpring\\images\\product\\";
		if (!productDao.existsImageName(productImgName)) {
			throw new UrlNotFoundException();
		}
		return new FileSystemResource( PATH + productImgName );
	}
	
	@ResponseBody
	@GetMappingImage( value = "/resource/img/skin/{skinImgName:.+}")
	public Resource imageSkin(@PathVariable String skinImgName) {
		final String PATH = "D:\\ProjectSpring\\images\\skin\\";
		FileSystemResource file = new FileSystemResource(PATH + skinImgName);
		if (!file.exists()) {
			throw new UrlNotFoundException();
		}
 		return file;
	}
	
}
