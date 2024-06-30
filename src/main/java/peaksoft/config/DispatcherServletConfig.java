package peaksoft.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
//    @Override
//    public  void onStartup(ServletContext servletContext)throws ServletException{
//        super.onStartup(servletContext);
//        registerHiddenFieldFilter(servletContext);
//    }
//
//    private void registerHiddenFieldFilter(ServletContext servletContext) {
//   servletContext.addFilter("hiddenHttpMethodFilter",new HiddenHttpMethodFilter())
//           .addMappingForUrlPatterns(null,true,"/*");
//    }


}
