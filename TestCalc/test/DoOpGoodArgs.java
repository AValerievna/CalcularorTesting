import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandra on 20.08.2017.
 */

@RunWith(Parameterized.class)
public class DoOpGoodArgs {
    XmlParsing xp;
    private String op;
    private double num1;
    private double num2;
    private double res;

    @Before
    public void toStart() {
        xp = new XmlParsing();
    }

    public DoOpGoodArgs(String op, double num1, double num2, double res) {
        this.op = op;
        this.num1 = num1;
        this.num2 = num2;
        this.res = res;
    }

    @Parameters
    public static Collection arguments() {
        return Arrays.asList(new Object[][]{
                { "MUL" , 1 , 2 , 2 },
                { "MUL" , 0 , 2 , 0 },
                { "DIV" , 2 , 2 , 1 },
                { "DIV" , 1 , 4 , 0.25 },
                { "SUM" , 1 , 2 , 3 },
                { "SUB" , 3 , 2 , 1 },
        });
    }

    @Test
    public void doOpWithGoodArgs() {
        try {
            assertEquals("Success",res,xp.doOp(op,num1,num2),0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
