package ayudantes;

import model.Person;
import model.PersonSQL;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Cristhian
 */
public class ValidarForm implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Person.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Validaciones val = new Validaciones();
        PersonSQL personSql = new PersonSQL();
        Person per = (Person) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "nombre", "required.nombre", "El campo Nombre es Requerido"
        );
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "email", "required.email", "El campo Email es Requerido"
        );
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "edad", "required.edad", "El campo Edad es Requerido"
        );
        if (per.getPais() == 0) {
            errors.rejectValue("pais", "pais.incorrect", "Selecciona Un Pais Por Favor");
        }
        if (per.getEdad() < 18) {
            errors.rejectValue("edad", "edad.incorrect", "Lo Sentimos Eres menor de Edad");
        }
        if(!val.email(per.getEmail())){
           errors.rejectValue("email", "email.incorrect", "E-mail no permitido");  
        }
        if (per.getId()>0) {
            if (!personSql.emailInsert(per.getEmail())) {
                if(!personSql.emailUpdate(per.getId(), per.getEmail())){
                  errors.rejectValue("email", "email.incorrect", "Lo Sentimos email ocupado");   
                }
            }
        }else{
            if(!personSql.emailInsert(per.getEmail())){
              errors.rejectValue("email", "email.incorrect", "Lo Sentimos email ocupado");  
            }
        }

    }
}
