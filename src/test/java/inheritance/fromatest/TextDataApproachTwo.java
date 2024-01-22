package inheritance.fromatest;

public class TextDataApproachTwo implements MyTextData {
    @Override
    public String removeSpacesFrom(String text) {
        StringBuilder retString = new StringBuilder();

        for(char t : text.toCharArray() ){
            if(t != ' '){
                retString.append(t);
            }
        }
        return retString.toString();
    }
}
