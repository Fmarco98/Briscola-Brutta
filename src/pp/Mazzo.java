package pp;

import java.util.ArrayList;
import java.util.List;

public class Mazzo {
	
	private List<Carta> mazzo = new ArrayList<>();
	private Carta briscola;
	
	public Mazzo() {
		String[] semi = {"Spade", "Denari", "Bastoni", "Coppe"};
		for(String seme : semi) {
			for(int index = 1; index <= 10; index++) {
				mazzo.add(new Carta(index, seme));
			}
		}
		
		this.briscola = this.pesca();
	}

	public List<Carta> getMazzo() {
		return mazzo;
	}
	public void setMazzo(List<Carta> mazzo) {
		this.mazzo = mazzo;
	}
	public Carta getBriscola() {
		return this.briscola;
	}
	
	public Carta pesca() {
		int index = (int)(Math.random()*this.mazzo.size());
		
		Carta c = this.mazzo.get(index);
		this.mazzo.remove(c);
		return c;
	}
	
	public Carta pescaBriscola() {
		if(this.briscola != null) {
			Carta c = this.briscola;
			this.briscola = null;
			return c;			
		}
		return null;
	}
	
	public int size() {
		return this.mazzo.size();
	}
	
	public String toString() {
		String s = "";
		
		for(Carta c : this.mazzo) {
			s += c.toString()+"\n";
		}
		
		return s;
	}
}
