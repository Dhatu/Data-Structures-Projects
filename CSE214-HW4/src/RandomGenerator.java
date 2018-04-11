public class RandomGenerator {
	public RandomGenerator(){}
	public static Ride selectRide(Ride[] rides){
		double prob = Math.random();
		if ( prob >= .01 & prob < .25){
			return rides[0];
		}
		if ( prob >= .25 & prob < .51){
			return rides[1];
		}
		if ( prob >= .51 & prob < .75){
			return rides[2];
		}
		if ( prob >= .75 & prob <= .99){
			return rides[3];
		}
		return null;
	}
} 
