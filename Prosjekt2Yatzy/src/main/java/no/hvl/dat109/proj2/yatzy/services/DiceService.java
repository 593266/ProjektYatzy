package no.hvl.dat109.proj2.yatzy.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import no.hvl.dat109.proj2.yatzy.entities.Dice;


/**
 * 
 * @author janwi
 * 
 * Dice service rolls a number of dices and sums them up
 */
public class DiceService {
	ArrayList<Integer> list;
	
	public ArrayList<Integer> rollDice(int antallTerninger) {
		list = new ArrayList<Integer>();
		
		//change 1 to number of dice if required
		for(int i = 0; i < antallTerninger; i++) {
			Dice dice = new Dice();
			dice = roll();
			list.add(dice.getValue());
			Collections.sort(list);
		}
		return list;
//			return list.stream().map(dice -> dice.getValue()).reduce(0, Integer::sum);
	}	
	
	private Dice roll() {
		Dice dice = new Dice();
		dice.setValue(ThreadLocalRandom.current().nextInt(1, 6 + 1));
		return dice;
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	
	
}
