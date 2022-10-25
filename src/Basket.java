import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Basket {
    private int price[];
    private String[] products;
    private int cart[];
    private int total = 0;

    public Basket(int[] price, String[] products) {
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
            for (int priceTxt : price) {
                writer.write(priceTxt + " ");
            }
            writer.write("\n");
            for (String productsTxt : products) {
                writer.write(productsTxt + " ");
            }
            writer.write("\n");
            for (int cartTxt : cart) {
                writer.write(cartTxt + " ");
            }

            /*for (int i = 0; i < cart.length; i++) {
                if (cart[i] != 0) {
                    writer.write(products[i] + " " + cart[i] + " шт " + price[i] + " руб/шт " + cart[i] * price[i] + " руб в сумме\n");
                }
            }
            writer.write("Итого: " + total + " руб");*/

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

/*    protected static Basket loadFromTxtFile(File file) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String s;
        List<String> product = new ArrayList<>();
        List<String> total = new ArrayList<>();
        List<Integer> price = new ArrayList<>();
        //Basket cart = new Basket(null, new String[]{"null"});
        while ((s = br.readLine()) != null) {
            String productCartFile[] = s.split(" ");
            if (!productCartFile[0].equals("Итого:")) {
                product.add(productCartFile[0]);
                total.add(productCartFile[1]);
                price.add(Integer.parseInt(productCartFile[3]));

            }
        }
        Integer[] fff = price.toArray(new Integer[0]);
        String priseInt = Arrays.toString(new List[]{price});
        Basket cart = new Basket(fff.length, new String[]{pro;

        //.addCart(Integer.parseInt(parse[0]), product);
//            product++;
        return null;
    }*/


}
