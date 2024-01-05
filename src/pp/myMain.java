package pp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class myMain {
	
	public static Mazzo mazzo = new Mazzo();
	
	public static Carta briscola = new Carta(mazzo.getBriscola());
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Carta[] giocata = new Carta[2];
		int indexVincitore=0;		
		List<Entity> giocatori = new ArrayList<>();
		
		System.out.print("Inserisci il tuo nick: ");
		giocatori.add(new Player(in.nextLine()));	//player index 0
		giocatori.add(new Bot());					//bot index 1
		
		System.out.println("\n<>--------------- INIZIO PARTITA ---------------<>");
		while(giocatori.get(0).isInGame() && giocatori.get(1).isInGame()) {
			int index = indexVincitore;
			for(int i=0; i < 2; i++) {
				
				giocata[i] = giocatori.get(index).gioca();
				
				if(++index == 2) {
					index = 0;
				}
			}
			
			if(giocata[0].getSeme().equals(giocata[1].getSeme())) {		
				if(giocata[0].getValue() >= giocata[1].getValue()) {
					indexVincitore = indexVincitore;
				} else {
					if(++indexVincitore == 2) {
						indexVincitore = 0;
					}
				}
			} else {
				if(giocata[0].getSeme().equals(briscola.getSeme())) {
					indexVincitore = indexVincitore;
				} else if(giocata[1].getSeme().equals(briscola.getSeme())) {
					if(++indexVincitore == 2) {
						indexVincitore = 0;
					}
				} else {
					indexVincitore = indexVincitore;
				}
			}
			
			System.out.println("\t     <>------ Giocata ------<>");
			System.out.println("\t\t   "+giocata[0]);
			System.out.println("\t\t   "+giocata[1]);
			
			
			System.out.println("\t\tGiocata vinta da "+ giocatori.get(indexVincitore).getNome()+"!\n\n");		
			giocatori.get(indexVincitore).vintoGiocata(giocata[0].getValue() + giocata[1].getValue());
			giocata[0] = null;
			giocata[1] = null;
				
			giocatori.get(0).fineTurno();
			giocatori.get(1).fineTurno();
		}
		
		System.out.println("\n<>-------------- PARTITA CONCLUSA --------------<>");
		if(giocatori.get(0).getPunti() > giocatori.get(1).getPunti()) {
			indexVincitore = 0;
		} else {
			indexVincitore = 1;
		}
		System.out.println("\t\t  Vincitore: "+ giocatori.get(indexVincitore).getNome());
		System.out.println("\t\t  Punteggio: "+ giocatori.get(indexVincitore).getPunti());
	}
}