package br.brainshare.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.brainshare.model.UserBean;

public class LoginFilter implements Filter {

    private final static String FILTER_APPLIED = "_security_filter_applied";

    public LoginFilter() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hreq = (HttpServletRequest) request;
        HttpServletResponse hresp = (HttpServletResponse) response;
        HttpSession session = hreq.getSession();

        hreq.getPathInfo();
        String paginaAtual = new String(hreq.getRequestURL());
        System.out.println(">>>>>>>" + paginaAtual);

        if ((request.getAttribute(FILTER_APPLIED) == null) 
                && paginaAtual != null 
                && (!paginaAtual.endsWith("login.jsf")) 
                && (paginaAtual.endsWith(".jsf"))) {
            request.setAttribute(FILTER_APPLIED, Boolean.TRUE);

            String user = null;
            if (((UserBean) session.getAttribute("usuarioLogado")) != null) {
                user = ((UserBean) session.getAttribute("usuarioLogado")).getUsername();
            }

            if ((user == null) || (user.equals(""))) {
                hresp.sendRedirect("login.jsf");
                return;
            }
            System.out.println(">>>>>> " + user);

        }
        // entrega a requisição para o proximo filtro  
        chain.doFilter(request, response);
    }
}
