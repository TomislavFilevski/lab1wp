package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ChefDetailsServlet", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {

    private final ChefService chefService;
    private final SpringTemplateEngine springTemplateEngine;

    public ChefDetailsServlet(ChefService chefService, SpringTemplateEngine springTemplateEngine) {
        this.chefService = chefService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String chefIdParam = req.getParameter("chefId");
        String dishId = req.getParameter("dishId");

        if (chefIdParam == null || dishId == null || chefIdParam.isEmpty() || dishId.isEmpty()) {
            resp.sendRedirect("/listChefs");
            return;
        }

        Long chefId = Long.parseLong(chefIdParam);

        Chef updatedChef = chefService.addDishToChef(chefId, dishId);

        if (updatedChef == null) {
            resp.sendRedirect("/listChefs");
            return;
        }

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("chef", updatedChef);

        springTemplateEngine.process("chefDetails.html", context, resp.getWriter());
    }
}