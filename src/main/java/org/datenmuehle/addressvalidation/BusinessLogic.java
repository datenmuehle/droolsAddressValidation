package org.datenmuehle.addressvalidation;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BusinessLogic
{
  private static BusinessLogic INSTANCE;

  private RuleBase ruleBase;

  private BusinessLogic() {}

  public static synchronized BusinessLogic get() {
    if (INSTANCE != null) {
      return INSTANCE;
    }

    try {
      BusinessLogic logic = new BusinessLogic();
      PackageBuilder packageBuilder = new PackageBuilder();
      String ruleFile = "/com/rule/addressvalidation.drl";
      InputStream resourceAsStream = logic.getClass().getResourceAsStream(ruleFile);
      Reader reader = new InputStreamReader(resourceAsStream);
      packageBuilder.addPackageFromDrl(reader);
      org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
      RuleBase ruleBase = RuleBaseFactory.newRuleBase();
      ruleBase.addPackage(rulesPackage);

      logic.ruleBase = ruleBase;

      INSTANCE = logic;
    } catch (DroolsParserException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return INSTANCE;
  }

  public void validate(Object o) {
    WorkingMemory workingMemory = ruleBase.newStatefulSession();
    workingMemory.insert(o);
    workingMemory.fireAllRules();
  }
}
