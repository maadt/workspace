public class Drink {//オブジェクトの情報を保持、各情報をカプセル化する
private String name;
private int price;
private int stocks;

public class Drink {
    public Drink(String name, int price, int stocks) {
        this.name = name;
        this.price = price;
        this.stocks = stocks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStocks() {
        return stocks;
    }
    public void setStocks(int stocks) {
        this.stocks = stocks;
    }
}
