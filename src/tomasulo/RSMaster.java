package tomasulo;

import instructions.Instruction;

public class RSMaster {
	private static int numInstructions;
	private static int rsCount;
	private static ReservationStation[] rStations;
	
	public static void stepForth() {
		// TODO: Execute logic for all reservation stations
	}
	
	public static synchronized int size() {
		return rsCount;
	}

	public static synchronized void resize(int rsCount) {
		RSMaster.rsCount = rsCount;
		rStations = new ReservationStation[rsCount];
	}
	
	public static ReservationStation getRS(int num) {
		// One-based indexing
		return rStations[num-1];
	}

	public static boolean isEmpty() {
		return numInstructions == 0;
	}
	
	public static boolean issue(Instruction instruction) {
		for(int i = 0; i < rsCount; i++)
			if(rStations[i].free() && rStations[i].getType() == instruction.getType()) {
				// TODO: binding logic
				return true;
			}
		return false;
	}
	
}