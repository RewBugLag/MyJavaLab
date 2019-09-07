/*
-1 = no product | invalid index
-2 = !enough
-3 = 404 product not found
*/
import java.util.Arrays;
import java.util.Scanner;

public class VendingMachine {
    // instance's input
    private int moneyInserted;
    private String product;
    // local instance
    private int index;
    private int indexAd;
    private int maximum;
    private int vendingMoney;
    private boolean inserted;
    // productDB
    /* this was just for ez test at first | now you can set it by yourself
    int[] productPrice = {10, 20, 30, 40};
    String[] productType = {"orange", "grape", "apple", "banana"};
    int[] productTotal = {1, 2, 3, 4};
    */ 
    int[] productPrice;
    String[] productType;
    int[] productTotal;

    public VendingMachine(int moneyInserted, String product) {
        this.moneyInserted = moneyInserted;
        this.product = product;
        
    }

    public int setMaximumStorage(int maximum) {
        this.maximum = maximum;
        productPrice = new int[maximum];
        productType = new String[maximum];
        productTotal = new int[maximum];
        return maximum;

    }

    public int getMaximum() {
        return maximum;
    }
    /////////////////////////////////[Get Specified]/////////////////////////////////
    public int getSpecProductPrice(String yProduct) {
        findingProduct(yProduct);
        if (index == -1) {
            return -3;
        }
        return productPrice[index];
    }

    public int getSpecProductTotal(String yProduct) {
        findingProduct(yProduct);
        if (index == -1) {
            return -3;
        }
        return productTotal[index];
    }
    ///////////////////////[Get to display for admin when set]///////////////////////
    public int getProductPriceAd() {
        if (indexAd == -1) {
            return -3;
        }
        return productPrice[indexAd];
    }

    public String getProductTypeAd() {
        if (indexAd == -1) {
            return null;
        }
        return productType[indexAd];
    }

    public int getProductTotalAd() {
        if (indexAd == -1) {
            return -3;
        }
        return productTotal[indexAd];
    }
    ////////////////////////////[Get to display for user]////////////////////////////
    public int getProductPrice() {
        findingProduct(product);
        if (index == -1) {
            return -3;
        }
        return productPrice[index];
    }

    public String getProductType() {
        findingProduct(product);
        if (index == -1) {
            return null;
        }
        return productType[index];
    }

    public int getProductTotal() {
        findingProduct(product);
        if (index == -1) {
            return -3;
        }
        return productTotal[index];
    }
    /////////////////////////////////[Just Get]/////////////////////////////////
    public int getVendingMoney() {
        return vendingMoney;
    }

    public int getMoneyInserted() {
        return moneyInserted;
    }
    /////////////////////////////[User-side Processing]/////////////////////////////

    public boolean receiveMoney(int amount) {
        if (amount < 0) {
            return false;

        } else {
            moneyInserted += amount;
            inserted = true;
            return true;
        }
    }

    // need implementation for Arrays data type
    public int giveProduct() {
        findingProduct(product);
        if (index == -1) {
            return -3; // product not found

        } else if (productTotal[index] == 0) {
            return -1; // no product

        } else if (moneyInserted < productPrice[index]) {
            return -2; // !enough money

        } else if (moneyInserted == productPrice[index]) {
            productTotal[index]--;
            vendingMoney += productPrice[index];
            return 0; // no เงินทอน

        } else {
            productTotal[index]--; // product decreased by 1 as the order can be only 1 each
            vendingMoney += productPrice[index]; // money in machine increased
            return returnMoney();
        }
    }

    public int returnMoney() {
        return moneyInserted - productPrice[index]; // calculate เงินทอน
    }

    public int cancel() {
        return moneyInserted;
    }
    /////////////////////////////////[Set section]/////////////////////////////////

    // need implementation for Array[index]
    public void setAll(int i, String yProduct, int price, int total) { // for first time setting
        setProductType(i, yProduct);
        setProductPrice(price, yProduct);
        setProductTotal(total, yProduct);
    }

    public boolean setProductType(int i, String yProduct) {
        if (yProduct == null || i < 0 || i >= maximum) { // productType.length
            indexAd = -1; // invalid index input
            return false;

        } else {
            productType[i] = yProduct;
            indexAd = i; //
            return true;
        }
    }

    public boolean setProductPrice(int amount, String yProduct) {
        if (amount < 0) {
            return false;
        } else {
            findingProduct(yProduct);
            indexAd = index;
            productPrice[index] = amount;
            return true;
        }
    }

    public boolean setProductTotal(int amount, String yProduct) {
        if (amount < 0) {
            return false;
        } else {
            findingProduct(yProduct);
            indexAd = index;
            productTotal[index] = amount;
            return true;
        }
    }

    public boolean setMoney(int amount) {
        if (amount < 0) {
            return false;
        } else {
            vendingMoney = amount;
            return true;
        }
    }
    /////////////////////////////////[Processing]/////////////////////////////////

    // This is product finder [indexOf]
    public boolean findingProduct(String xProduct) {
        for (int i = 0; i < productType.length; i++) {
            if (xProduct == productType[i]) {
                index = i;
                return true;
            }
        }
        index = -1;
        return false;
    }

    public String toString() {
        StringBuilder vendingString = new StringBuilder();
        vendingString.append("{ Current money : ");
        if (inserted) {
            vendingString.append(this.moneyInserted);
            vendingString.append(" bath, Current order : ");
            vendingString.append(this.product);
        } else {
            vendingString.append("0 bath, Current order : none");
        }
        
        vendingString.append(" }\n");
        return vendingString.toString();
    }
}