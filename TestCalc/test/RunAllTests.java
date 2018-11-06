import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Alexandra on 20.08.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreateResultTest.class,
        DoOpBadArgs.class,
        DoOpGoodArgs.class,
        NullTest.class,
        XmlParsingTest.class,
        FullApplicationTest.class
})

public class RunAllTests{
}

