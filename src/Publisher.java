import java.util.Objects;

public class Publisher {
    private String publisherName;
    private String publisherAddress;
    private double publisherNumber;

    public Publisher(String publisherName, String publisherAddress, double publisherNumber) {
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
        this.publisherNumber = publisherNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Double.compare(publisher.publisherNumber, publisherNumber) == 0 &&
                publisherName.equals(publisher.publisherName) &&
                publisherAddress.equals(publisher.publisherAddress);
    }

}
