/**
 * BeruehrungssensitiveSkin
 */

class BeruehrungssensitiveSkin extends Skin {
    public BeruehrungssensitiveSkin() {
	name = "BeruehrungssensitiveSkin";
    }
	
    public void allowed(Bediener bediener) {
	bediener.skin = this;
    }

    public void allowed(Schwerarbeiter schwerarbeiter) {
	schwerarbeiter.skin = this;
    }

    public void allowed(Beschuetzer beschuetzer) {
	beschuetzer.skin = this;
    }
}
