package test.gudyna.validatortest;

import com.gudyna.balls.validator.BallValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BallValidatorTest {
    BallValidator ballValidator;

    @BeforeMethod
    public void setUp() {
        ballValidator = new BallValidator();
    }

    @Test
    public void checkWeightTestPositive() {
        double weight = 13.3;
        boolean condition = ballValidator.checkWeight(weight);
        assertTrue(condition);
    }

    @Test
    public void checkWeightTestNegative() {
        double weight = 31.6;
        boolean condition = ballValidator.checkWeight(weight);
        assertFalse(condition);
    }
}
