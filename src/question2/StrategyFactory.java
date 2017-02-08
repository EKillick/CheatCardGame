package question2;

/**
 *
 * @author 6277497
 */
public class StrategyFactory {

    Strategy returnStrategy;
    public Strategy getStrategy(char input){
        switch(input){
            case 'b':
                returnStrategy = new BasicStrategy();
                break;
            case 'm':
                returnStrategy = new MyStrategy();
                break;
            case 't':
                returnStrategy = new ThinkerStrategy();
                break;
            default:
                System.out.println("Invalid input");               
        }
        return returnStrategy;
    }
}
