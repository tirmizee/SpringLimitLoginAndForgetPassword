package com.tirmizee.backend.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.tirmizee.backend.dao.MemberImageDao;
import com.tirmizee.backend.service.StorageImageServiceImpl;
import com.tirmizee.core.annotaion.CurrentUser;
import com.tirmizee.core.annotaion.GetMappingPdf;
import com.tirmizee.core.component.ResourceHelper;
import com.tirmizee.core.security.UserProfile;

import net.sf.jasperreports.engine.JREmptyDataSource;

@Controller
@RequestMapping("file")
public class FileController {
	
	@Autowired
	private MemberImageDao memberImageDao;
	
	@Autowired 
	private ApplicationContext appContext;
	
	@GetMappingPdf(path = "/pdf")
	public ModelAndView generatePdf(){
		Map<String, Object> params = new HashMap<>();
		params.put("firstname", "Pratya");
		params.put("datasource", new JREmptyDataSource());
		params.put("net.sf.jasperreports.default.pdf.encoding", "Identity-H");
		params.put("logo", ResourceHelper.getPath("picture/checkbox-true.png"));
		JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:report/payment.jrxml");
	    view.setApplicationContext(appContext);
	    return new ModelAndView(view, params);
	}
	
	@ResponseBody
	@GetMapping( value = "/resource/img/profile", produces = { MediaType.IMAGE_JPEG_VALUE,	MediaType.IMAGE_PNG_VALUE })
	public Resource imageProfile(@CurrentUser UserProfile profile) throws NoHandlerFoundException {
		String imgName = memberImageDao.findOne(profile.getFkMemberImgId()).getImgName();
		Resource resource = new FileSystemResource( StorageImageServiceImpl.UPLOAD_PATH + imgName + ".png");
		return resource;
	}
	
	
	
}
