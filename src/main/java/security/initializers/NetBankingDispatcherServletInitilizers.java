package security.initializers;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import security.config.RootConfig;
import security.config.SecurityConfig;
import security.config.WebMvcConfig;


public class NetBankingDispatcherServletInitilizers extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {RootConfig.class,SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.htm"};
	}

}


