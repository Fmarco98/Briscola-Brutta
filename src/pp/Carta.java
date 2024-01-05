package pp;

public class Carta {
	
	private int index;
	private String seme;
	private int value;
	
	
	public Carta(Carta c) {
		this.index = c.index;
		this.seme = c.seme;
		this.value = c.value;
	}
	public Carta(int index, String seme) {
		int value=0;
		switch(index) {
			case 1:
				value = 11;
				break;
			case 3:
				value = 10;
				break;
			case 8:
				value = 2;
				break;
			case 9:
				value = 3;
				break;
			case 10:
				value = 4;
				break;
			default:
				value = 0;
				break;
		}
		
		this.value = value;
		this.index = index;
		this.seme = seme;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getSeme() {
		return seme;
	}
	public void setSeme(String seme) {
		this.seme = seme;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		String index = "";
		switch(this.index) {
			case 1:
				index = "Asso";
				break;
			case 8:
				index = "Fante";
				break;
			case 9:
				index = "Cavallo";
				break;
			case 10:
				index = "Re";
				break;
			default:
				index = this.index+"";
		}
		
		return index+" di "+this.seme/*+" | Valore: "+ this.value*/;
	}
}