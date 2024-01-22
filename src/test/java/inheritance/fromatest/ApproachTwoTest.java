package inheritance.fromatest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ApproachTwoTest extends ApproachOneTest{

    public MyTextData getObjectUnderTest(){
        return new TextDataApproachTwo();
    }

}
