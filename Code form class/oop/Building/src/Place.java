public class Place {
    private String tenantName;
    private double area;
    private int floor;

    public Place() {
        tenantName = "";
        area = 0;
        floor = 0;
    }

    public double getArea() {
        return area;
    }

    public String getTenantName() {
        return tenantName;
    }

    public int getFloor() {
        return floor;
    }

    public void setArea(double area) {
        if (area < 0) {
            throw new IllegalArgumentException("Area is negative");
        }
        this.area = area;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setTenantName(String tenantName) {
        if (tenantName.isEmpty()) {
            throw new IllegalArgumentException("Tenant name cannot be empty");
        }
        this.tenantName = tenantName;
    }
}
