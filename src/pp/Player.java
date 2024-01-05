package pp;

import java.util.Scanner;

public class Player extends Entity{
	Scanner in = new Scanner(System.in);
	
	public Player(String nome) {
		super(nome);
	}
	
	@Override
	public Carta gioca() {
		
		System.out.println("\n\t\tBriscola: " + myMain.briscola.getSeme());
		System.out.println("\t     <>------- MANO -------<>");
		for(int i=0; i < super.getMano().getMano().size(); i++) {
			System.out.println("\t\t["+(i+1)+"] | "+ super.getMano().getMano().get(i));
		}
		System.out.print("\t\t\tScegli: ");
		int index = in.nextInt()-1;
		in.nextLine();
		
		Carta giocata = super.getMano().getMano().get(index);
		super.getMano().getMano().remove(giocata);
		return giocata;
	}

}
