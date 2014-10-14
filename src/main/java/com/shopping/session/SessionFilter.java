package com.shopping.session;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class SessionFilter implements Filter {
 
    private ArrayList<String> urlList;
     
    public void destroy() {
    }
 
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String contextPath = request.getContextPath();
        String jerssyPath = request.getServletPath();
        String url = contextPath+jerssyPath+request.getPathInfo();
        boolean allowedRequest = false;
         
//        if(urlList.contains(url)) {
//            allowedRequest = true;
//        }
             
        if (!allowedRequest) {
            HttpSession session = request.getSession(false);
            String ipaddress = null;
            try{
             ipaddress=(String)session.getAttribute("ipaddress");	
            }
            catch(Exception e){
                if (ipaddress == null) {
                	System.out.println("CCCCCCCCCCCCCCCCC");
                	HttpSession httpsession=request.getSession();  
                	httpsession.setAttribute("ipaddress",request.getRemoteHost()); 
                    chain.doFilter(req, res);
//                    response.sendRedirect("index.html");
                }
            }

        }
         
        chain.doFilter(req, res);
    }
 
    public void init(FilterConfig config) throws ServletException {
        String urls = config.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");
 
        urlList = new ArrayList<String>();
 
        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
 
        }
    }
}