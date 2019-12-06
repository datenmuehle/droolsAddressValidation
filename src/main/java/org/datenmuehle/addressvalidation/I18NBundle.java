package org.datenmuehle.addressvalidation;

import javax.faces.bean.ManagedBean;
import java.util.ResourceBundle;

@ManagedBean
public class I18NBundle
{
  private final static ResourceBundle bundle;
  private static I18NBundle INSTANCE;

  static {
    bundle = ResourceBundle.getBundle("ApplicationMessages_de_DE");
    INSTANCE = new I18NBundle();
  }

  public String get(String key)
  {
    return bundle.getString(key);
  }

  public static I18NBundle get() {
    return INSTANCE;
  }

}
