package ÜbungFurkan.Polymorphie;

public class Regal {

	public RegalBrett[] regalBraetter;

	
	public Regal(RegalBrett brett1, RegalBrett brett2) {
		regalBraetter = new RegalBrett[10];
		regalBraetter[0] = brett1;
		regalBraetter[1] = brett2;
	}
	
	public boolean furegeHinzu(Medium medium) {
		for(int i = 0; i<regalBraetter.length;i++) {
			if(regalBraetter != null && regalBraetter[i].fuegeHinzu(medium)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean fuegeBrettHinzu(RegalBrett brett) {
		for(int i = 0; i<regalBraetter.length;i++) {
			if(regalBraetter[i] == null) {
				regalBraetter[i] = brett;
				return true;
			}
		}
		return false;
	}

	
	
}
