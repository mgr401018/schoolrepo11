import java.util.List;

public abstract class Building {
    private String adress;
    private List<Place> places;

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        if(adress.isEmpty())
            throw new IllegalArgumentException("Place cannot be empty");
        this.adress = adress;
    }

    public double calculateTotalArea(){
        double total = 0;
        for(Place place : places){
            total += place.getArea();
        }
        return total;
//        places.stream().map(Place::getArea).reduce(0.0, Double::sum);
    }

    public abstract double getPricePerMonth();

    public double estimateReturn(int months) {
        return months * getPricePerMonth() * calculateTotalArea();
    }

    public abstract double estimateExpense(int months);

    public double estimateNetReturn(int months) {
        return estimateReturn(months) - estimateExpense(months);
    }
}
