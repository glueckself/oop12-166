@Member("Alex Huber")
class Duengerstreuer implements Role {
    private double kapazitaet;
    
    @Member("Alex Huber")
    Duengerstreuer(double kapazitaet) {
        this.kapazitaet = kapazitaet;
    }
    
    @Member("Alex Huber")
    public double getKapazitaet() {
        return this.kapazitaet;
    }

}
