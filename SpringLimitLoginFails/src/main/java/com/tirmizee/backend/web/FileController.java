package com.tirmizee.backend.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.tirmizee.core.annotaion.GetMappingPdf;
import com.tirmizee.core.component.ResourceHelper;

import net.sf.jasperreports.engine.JREmptyDataSource;

@Controller
@RequestMapping("file")
public class FileController {
	
	@Autowired 
	private ApplicationContext appContext;
	
	@Autowired 
	private ServletContext servletContext;
	
	@GetMappingPdf(path = "/pdf")
	public ModelAndView generatePdf(){
		Map<String, Object> params = new HashMap<>();
		params.put("firstname", "Pratya");
		params.put("datasource", new JREmptyDataSource());
		params.put("logo", ResourceHelper.getPath("picture/logo.jpg"));
		JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:report/payment.jrxml");
	    view.setApplicationContext(appContext);
	    return new ModelAndView(view, params);
	}
	
	@ResponseBody
	@RequestMapping( value = "/image-resource", method = RequestMethod.GET,produces = { MediaType.IMAGE_JPEG_VALUE,	MediaType.IMAGE_PNG_VALUE })
	public Resource getImageAsResource() {
	   return new ServletContextResource(servletContext, "/WEB-INF/images/rin.png");
	}
	
}
