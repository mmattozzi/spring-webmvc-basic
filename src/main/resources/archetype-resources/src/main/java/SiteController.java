package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SiteController {

    private static Logger LOG = LoggerFactory.getLogger(SiteController.class);

    protected String welcomeMessage;

    @Required
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void init() {
        LOG.info("Called init on {}", this.getClass().getSimpleName());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("title", String.format("%s Index Page", this.getClass().getSimpleName()));
        modelMap.put("welcomeMessage", welcomeMessage);
        return new ModelAndView("index", modelMap);
    }

    @RequestMapping(value = "/requestInfo", method = RequestMethod.GET)
    public void requestInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().println("RequestURI = " + request.getRequestURI());
        response.getWriter().println("RequestURL = " + request.getRequestURL());
        response.getWriter().println("ContextPath = " + request.getContextPath());
        response.getWriter().println("PathTranslated = " + request.getPathTranslated());
        response.getWriter().println("ServletPath = " + request.getServletPath());
        response.getWriter().println("PathInfo = " + request.getPathInfo());
    }

}
