import java.io.*;

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

    public void cart() {
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

    protected void saveTxt(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file.getName(), false)) {
            for (int i = 0; i < cart.length; i++) {
                if (cart[i] != 0) {
                    writer.write(cart[i] + " шт " + price[i] + " руб/шт " + cart[i] * price[i] + " руб в сумме\n");
                }
            }
            writer.write("Итого: " + total + " руб");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected static void loadFromTxtFile(File file, Basket cart) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file.getName()))) {
            String s;
            int product = 0;
            while ((s = br.readLine()) != null) {
                String parse[] = s.split(" ");
                cart.addCart(Integer.parseInt(parse[0]), product);
                product++;
            }
        } catch (IOException ex) {
            ex.getMessage();
        } catch (NumberFormatException ex) {
        }
    }


}
