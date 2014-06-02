package aliensAndHumans;

/**
 * Alien Class - is a bean class which has the getters and setters for all the attributes of each alien object.
 * @author Atulya Rastogi
 *
 */
public class Alien {

	private String alienCode;
	private String alienBloodColor;
	private String alienAntennas;
	private String alienLegs;
	private String alienHomePlanet;
	
	public Alien(String code, String color,String antennas, String legs, String planet){
		this.alienCode=code;
		this.alienBloodColor=color;
		this.alienAntennas=antennas;
		this.alienLegs=legs;
		this.alienHomePlanet=planet;
	}
	
	
	public String getAlienCode() {
		return alienCode;
	}

	public void setAlienCode(String alienCode) {
		this.alienCode = alienCode;
	}

	public String getAlienBloodColor() {
		return alienBloodColor;
	}

	public void setAlienBloodColor(String alienBloodColor) {
		this.alienBloodColor = alienBloodColor;
	}

	public String getAlienLegs() {
		return alienLegs;
	}

	public void setAlienLegs(String alienLegs) {
		this.alienLegs = alienLegs;
	}
	
	public String getAlienAntennas() {
		return alienAntennas;
	}

	public void setAlienAntennas(String alienAntennas) {
		this.alienAntennas = alienAntennas;
	}

	public String getAlienHomePlanet() {
		return alienHomePlanet;
	}

	public void setAlienHomePlanet(String alienHomePlanet) {
		this.alienHomePlanet = alienHomePlanet;
	}

}
