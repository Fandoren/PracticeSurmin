package Exercise3;

public class Car implements Printable{

    String brand;
    String model;
    String configuration;
    int price;
    int year;

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public String getConfiguration(){
        return configuration;
    }

    public int getYear(){
        return year;
    }

    public Car(String brand, String model, String configuration, int price, int year){
        this.brand = brand;
        this.model = model;
        this.configuration = configuration;
        this.price = price;
        this.year = year;
    }

    @Override
    public void println() {
        System.out.println("Автомобиль марки: " + brand +
                " Модель: " + model +
                " Конфигурация: " + configuration +
                " Цена: " + price +
                " Год выпуска: " + year);
    }
}
