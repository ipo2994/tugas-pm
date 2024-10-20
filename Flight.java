public class Flight {
    
    private class Passenger {
        String name;
        Passenger next;

        public Passenger(String name) {
            this.name = name;
            this.next = null;
        }
    }

    private Passenger head;

    public Flight() {
        this.head = null;
    }

    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);

        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        Passenger current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Penumpang dengan nama " + name + " tidak ditemukan.");
        } else {
            current.next = current.next.next;
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Tidak ada penumpang.");
            return;
        }

        Passenger current = head;
        while (current != null) {
            System.out.println("Penumpang: " + current.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();
        
        flight.addPassenger("Rijan");
        flight.addPassenger("Madan");
        flight.addPassenger("Naufal");
        
        System.out.println("Daftar Penumpang:");
        flight.displayPassengers();

        System.out.println("\nMenghapus penumpang 'Naufal':");
        flight.removePassenger("Naufal");
        flight.displayPassengers();
    }
}
