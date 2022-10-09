public class Basket {
    public int price[];
    public String products[];
    public int cart[];
    public int total = 0;

    public Basket(int price[], String products[]) {
        this.price = price;
        this.products = products;
        cart = new int[products.length];
    }

    public void cart(){
        System.out.println("Ваша корзина:");
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != 0) {
                System.out.println(products[i] + " " + cart[i] + " шт " + price[i] + " руб/шт " + cart[i] * price[i] + " руб в сумме");
            }
        }
        System.out.println("Итого: " + total + " руб");
    }

    protected void addCart(int productCount, int productNumber) {
        cart[productNumber] += productCount;
        total += productCount * price[productNumber];
    }

}
