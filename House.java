public final class House {
    private final String address;
    private final int floors;
    private final int rooms;
    private final double area;
    private final boolean garage;

    private House(Builder b) {
        this.address = b.address;
        this.floors = b.floors;
        this.rooms = b.rooms;
        this.area = b.area;
        this.garage = b.garage;
    }

    public String getAddress() { return address; }
    public int getFloors() { return floors; }
    public int getRooms() { return rooms; }
    public double getArea() { return area; }
    public boolean hasGarage() { return garage; }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", floors=" + floors +
                ", rooms=" + rooms +
                ", area=" + area +
                ", garage=" + garage +
                '}';
    }

    public static class Builder {
        private final String address;
        private final int floors;
        private int rooms = 1;
        private double area = 50.0;
        private boolean garage = false;

        public Builder(String address, int floors) {
            this.address = address;
            this.floors = floors;
        }

        public Builder rooms(int rooms) {
            this.rooms = rooms;
            return this;
        }

        public Builder area(double area) {
            this.area = area;
            return this;
        }

        public Builder garage(boolean garage) {
            this.garage = garage;
            return this;
        }

        private void validate() {
            if (address == null || address.isBlank()) {
                throw new IllegalStateException("Address must be provided and not blank.");
            }
            if (floors < 1) {
                throw new IllegalStateException("Floors must be >= 1.");
            }
            if (rooms < 1) {
                throw new IllegalStateException("Rooms must be >= 1.");
            }
            if (area <= 0) {
                throw new IllegalStateException("Area must be > 0.");
            }
        }

        public House build() {
            validate();
            return new House(this);
        }
    }

    public static void main(String[] args) {
        House simple = new House.Builder("100 Main St", 1).build();
        System.out.println("Simple house: " + simple);

        House full = new House.Builder("55 River Rd", 2)
                .rooms(4)
                .area(180.5)
                .garage(true)
                .build();
        System.out.println("Full house:   " + full);
    }
}
