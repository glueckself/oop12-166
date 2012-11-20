/**
 * ElapsedTime interface
 *
 * @author Julian Grosshauser
 */
interface ElapsedTime extends Shorter<ElapsedTime> {
    int count();    
    double shorterValue();
}
