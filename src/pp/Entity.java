package pp;

public abstract class Entity {
	
	private int punti;
	private String nome;
	private Mano mano;
	
	public Entity(String nome) {
		this.punti = 0;
		this.nome = nome;
		this.mano = new Mano();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Mano getMano() {
		return mano;
	}
	public void setMano(Mano mano) {
		this.mano = mano;
	}
	public int getPunti() {
		return punti;
	}
	
	public abstract Carta gioca();
	
	public void fineTurno() {
		if(myMain.mazzo.size() != 0) {			
			this.mano.pesca();
		} else {
			this.mano.pescaBriscola();
		}
	}
	public void vintoGiocata(int punti) {
		this.punti += punti;
	}
	public boolean isInGame() {
		if(this.mano.getMano().size() != 0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.mano.toString();
	}
}
