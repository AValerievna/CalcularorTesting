import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Alexandra on 20.08.2017.
 */
@RunWith(Parameterized.class)
public class DoOpBadArgs {
    XmlParsing xp;
    private String op;
    private double num1;
    private double num2;

    @Before
    public void toStart() {
        xp = new XmlParsing();
    }

    public DoOpBadArgs(String op, double num1, double num2) {
        this.op = op;
        this.num1 = num1;
        this.num2 = num2;
    }

    @Parameterized.Parameters
    public static Collection arguments() {
        return Arrays.asList(new Object[][]{
                { "MUL" , Double.MAX_VALUE , Double.MAX_VALUE  },
                { "DIV" , 1 , 0},
                { "DIV" , Double.MAX_VALUE , Double.MIN_VALUE},
                { "DIV" , -Double.MAX_VALUE, -1 },
                { "SUM" , Double.MAX_VALUE , Double.MAX_VALUE },
                { "SUB" , Double.MAX_VALUE , -Double.MAX_VALUE },
        });
    }

    @Test(expected = Exception.class)
    public void doOpWithGoodArgs() throws Exception {
        xp.doOp(op,num1,num2);
    }


}

