package utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("yValidator")
public class YValidator implements Validator {

    private final double Y_MIN = -3;
    private final double Y_MAX = 5;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null){
            FacesMessage msg = new FacesMessage("Y must not be null");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        try{
            double y = Double.parseDouble(value.toString());
            if (y <= Y_MIN || y >= Y_MAX) {
                FacesMessage msg = new FacesMessage(
                        "Y должен быть в пределах от " + Y_MIN + " до " + Y_MAX + " невключительно"
                        );
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }

        }
        catch (NumberFormatException e){
            FacesMessage msg = new FacesMessage("Y должен быть числом");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
