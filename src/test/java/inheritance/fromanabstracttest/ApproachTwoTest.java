package inheritance.fromanabstracttest;

public class ApproachTwoTest extends ApproachOneTest {

    public MyTextData getObjectUnderTest(){
        return new TextDataApproachTwo();
    }

}
