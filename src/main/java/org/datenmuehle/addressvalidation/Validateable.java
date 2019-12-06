package org.datenmuehle.addressvalidation;

import org.codehaus.plexus.util.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public abstract class Validateable implements Serializable
{
  protected abstract String getId();

  public void validate() {
    BusinessLogic.get().validate(this);
  }

  public void setValidationResult(String validationMessage) {
    if (StringUtils.isBlank(validationMessage)) {
      return;
    }

    FacesContext.getCurrentInstance().addMessage(getId(),
      new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler: ", I18NBundle.get().get(validationMessage)));
  }
}
