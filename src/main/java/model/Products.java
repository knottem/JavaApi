package model;

public class Products {

    private final int id;
    private final String title;
    private final double price;
    private final String description;
    private final String category;
    private final String image;
    private final Rating rating;

    private record Rating(double rate, int count) {}

    public Products(int id, String title, double price, String description, String category, String image, double rate, int count) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = new Rating(rate, count);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public double getRating() {
        return rating.rate;
    }

    public int getRatingCount() {
        return rating.count;
    }

    @Override
    public String toString() {
        return "Product \nid: " + id +
                "\ntitle: " + title +
                "\nprice: " + price +
                "\ndescription: " + description +
                "\ncategory: " + category +
                "\nimage: " + image +
                "\nrating: " + getRating()  +
                "\nrating count: " + getRatingCount();
    }
}
