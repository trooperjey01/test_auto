package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object URL_HomePage
     
    /**
     * <p></p>
     */
    public static Object Timeout_Small
     
    /**
     * <p></p>
     */
    public static Object URL_Cart
     
    /**
     * <p></p>
     */
    public static Object URL_Checkout
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            URL_HomePage = selectedVariables['URL_HomePage']
            Timeout_Small = selectedVariables['Timeout_Small']
            URL_Cart = selectedVariables['URL_Cart']
            URL_Checkout = selectedVariables['URL_Checkout']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
