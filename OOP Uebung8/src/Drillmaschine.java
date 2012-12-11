@Member("Alex Huber")
class Drillmaschine implements Role {
    private int saeschare;
    
    @Member("Alex Huber")
    Drillmaschine(int saeschaere) {
        this.saeschare = saeschaere;
    }
    
    @Member("Alex Huber")
    public int getSaeschare() {
        return this.saeschare;
    }

}
