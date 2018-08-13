package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Emma on 2018/8/13.
 */

@WebFilter("/FilterStation")
public class FilterStation extends HttpServlet implements Filter {
    private FilterConfig filterConfig;

    public FilterStation() {
        super();
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session=((HttpServletRequest)request).getSession();
        response.setCharacterEncoding("gb2312");
        if(session.getAttribute("name")==null){
            PrintWriter out=response.getWriter();
            out.print("<script>alert('请登录！');location.href='../login.jsp'</script>");
        }
        else{
            chain.doFilter(request, response);
        }
    }

}
