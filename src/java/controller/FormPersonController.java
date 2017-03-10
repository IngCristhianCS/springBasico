package controller;

import ayudantes.ValidarForm;
import db.Conexion;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Person;
import model.PersonSQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("formPerson.htm")
public class FormPersonController {

    private final ValidarForm validarform;
    PersonSQL personSql;

    public FormPersonController() {
        this.validarform = new ValidarForm();
        personSql = new PersonSQL();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView formPerson(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("formPerson");
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (id > 0) {                
                Person per= this.personSql.persona(id);
                mav.addObject(per);
            } else {
                mav.addObject(new Person());
            }
        } else {
            mav.addObject(new Person());
        }

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    /*public String  formPerson(Person per, ModelMap model){        model.addAttribute("nombre",per.getNombre());
     model.addAttribute("edad",per.getEdad());        model.addAttribute("email",per.getEmail());
     model.addAttribute("pais",per.getPais());        return "exito";    */
    public ModelAndView formPerson(HttpServletRequest request, @ModelAttribute("person") Person per,
            BindingResult result, SessionStatus status) {
        this.validarform.validate(per, result);
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            mav.setViewName("formPerson");
            mav.addObject(new Person());

        } else {
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                if (id > 0) {
                    this.personSql.update(per, id);
                }
            } else {
                this.personSql.insert(per);
            }
            mav.clear();
            mav = new ModelAndView("redirect:/home.htm");
        }
        return mav;
    }

    @ModelAttribute("paisLista")
    public Map<String, String> listadoPaises() {
        Map<String, String> pais = new LinkedHashMap<>();
        pais.put("1", "Argentina");
        pais.put("2", "Mexico");
        pais.put("3", "Nicaragua");
        return pais;
    }

}
