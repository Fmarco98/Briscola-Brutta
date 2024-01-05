package pp;

import java.util.ArrayList;
import java.util.List;

public class Mano {
	
	private List<Carta> mano = new ArrayList<>();
		
	public Mano() {
		for(int i=0; i < 3; i++) {
			this.mano.add(myMain.mazzo.pesca());
		}
	}

	public List<Carta> getMano() {
		return mano;
	}
	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}
	
	public void pesca() {
		this.mano.add(myMain.mazzo.pesca());
	}
	public void pescaBriscola() {
		Carta c = myMain.mazzo.pescaBriscola();
		if(c != null) {			
			this.mano.add(c);
		}
	}
	
	@Override
	public String toString() {
		String s="";
		
		for(Carta c : this.mano) {
			s += c.toString()+"\n";
		}
		
		return s;
	}
}
