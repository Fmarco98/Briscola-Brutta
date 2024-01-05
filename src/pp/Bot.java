package pp;

public class Bot extends Entity{
	
	public Bot() {
		super("bot");
	}

	@Override
	public Carta gioca() {
		Carta briscola = myMain.briscola;
		
		for(Carta c : super.getMano().getMano()) {
			if(c.getSeme() == briscola.getSeme()) {
				super.getMano().getMano().remove(c);
				return c;
			}
		}
		
		Carta giocata = super.getMano().getMano().get((int)(Math.random()*super.getMano().getMano().size()));
		super.getMano().getMano().remove(giocata);
		return giocata;
	}

}
