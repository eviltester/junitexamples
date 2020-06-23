package coverageexample;

public class CoverMeWithJUnit4Tests {
    private final int lower;
    private final int upper;

    public CoverMeWithJUnit4Tests(final int lower, final int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int evaluate(final int where) {

        if(where<lower && where>0){
            return -1;
        }
        if(where>upper){
            return 1;
        }
        if(where==lower || where==upper){
            return where;
        }

        if(where>lower && where<upper){
            return 0;
        }

        if(where<0){
            throw new IllegalArgumentException("No negativity please");
        }

        return 0;
    }
}
