package inheritance.fromatest;

public class TextDataApproachOne implements MyTextData {

    // first set of approaches to generating data

    @Override
    public String removeSpacesFrom(String text) {
        return text.replace(" ", "");
    }
}
