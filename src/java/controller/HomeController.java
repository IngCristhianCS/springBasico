package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.PersonSQL;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    ModelAndView mav ;
    PersonSQL personSql;
    public HomeController(){
        personSql = new PersonSQL();
    }
    
    @RequestMapping("home.htm")
    public ModelAndView home(HttpServletRequest request){        
        if(request.getParameter("id") != null){
            int id=Integer.parseInt(request.getParameter("id"));
            if(id>0){              
               this.personSql.delete(id);
               mav =  new ModelAndView("redirect:/home.htm");
            }
        }else{
           List usuarios=this.personSql.personas();
            mav =  new ModelAndView();
            mav.setViewName("home");        
            mav.addObject("usuarios",usuarios); 
        }
        return mav;
    }
}