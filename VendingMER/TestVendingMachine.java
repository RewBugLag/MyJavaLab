/**
 * TestVendingMachine
 */
public class TestVendingMachine {

    public static void main(String[] args) {
        VendingMachine vendA = new VendingMachine(10);
        // admin session
        System.out.println("[ admin session test ]\n");
        // setting up
        System.out.println("set maximum to: " + vendA.getMaximum());
        /*
        vendA.setAll(0, "orange", 10, 1000);
        System.out.println("set product: " + vendA.getProductTypeAd());
        System.out.println("set price to: " + vendA.getProductPriceAd());
        System.out.println("set total to: " + vendA.getProductTotalAd());
        System.out.println();
        */
        vendA.setProductType(0, "orange");
        System.out.println("set product: " + vendA.getProductTypeAd());
        vendA.setProductType(4, "grape");
        System.out.println("set product: " + vendA.getProductTypeAd());
        System.out.println();

        vendA.setProductPrice(10, "orange");
        System.out.println("set price to: " + vendA.getProductPriceAd());
        vendA.setProductTotal(1000, "orange");
        System.out.println("set total to: " + vendA.getProductTotalAd());
        System.out.println();

        vendA.setProductPrice(20, "grape");
        System.out.println("set price to: " + vendA.getProductPriceAd());
        vendA.setProductTotal(4000, "grape");
        System.out.println("set total to: " + vendA.getProductTotalAd());
        System.out.println();
        /*
        vendA.setAll(4, "grape", 40, 4000);
        System.out.println("set product: " + vendA.getProductTypeAd());
        System.out.println("set price to: " + vendA.getProductPriceAd());
        System.out.println("set total to: " + vendA.getProductTotalAd());
        System.out.println();
        */
        /*
        System.out.println(vendA.productType[4]);
        vendA.setProductType(4, "grape"); // index = 4 = grape
        System.out.println(vendA.getProductTypeAd());// index = orange = -1 not found // need get productType index for admin
        vendA.setProductType(0, "orange");
        System.out.println(vendA.getProductTypeAd());// index = orange

        System.out.println(vendA.productPrice[4]);
        vendA.setProductPrice(30, "grape");
        System.out.println(vendA.getProductPriceAd());// index = orange
        
        System.out.println(vendA.productTotal[4]);
        vendA.setProductTotal(1000, "grape");
        System.out.println(vendA.productTotal[0]);
        System.out.println(vendA.getProductTotalAd());// index = orange still... it's get (product)

        System.out.println(); // (product) still "orange" index still "orange" in get

        vendA.setProductType(0, "orange"); // index change from grape to orange
        vendA.setProductType(4, "grape"); // just change the index not product | index and product are pointer
        
        System.out.println(vendA.getProductType());
        vendA.setProductPrice(10, "orange");
        System.out.println("set price to: " + vendA.getProductPrice());
        vendA.setProductTotal(1000, "orange");
        System.out.println("set product to: " + vendA.getProductTotal());
        vendA.setMoney(100);
        System.out.println("set money to: " + vendA.getVendingMoney() + "\n");
        */
        // user session
        System.out.println("[ user session test ]\n");
        System.out.println("current money inserted: " + vendA.getMoneyInserted());
        System.out.println(vendA);
        vendA.receiveMoney(20); // insert more 20 baths
        System.out.println(vendA);
        System.out.println("second inserted: " + vendA.getMoneyInserted());
        //vendA.setProductPrice(10, "grape");
        vendA.chooseProduct("grape");
        System.out.println("Choosing product: " + vendA.getProductType());
        System.out.println("product price: " + vendA.getProductPrice());
        System.out.println("request for product with เงินทอน: " + vendA.giveProduct());
        System.out.println();
        System.out.println("error log: { -1 = 0 product, -2 = !enough money, -3 = 404 product not found }");
        System.out.println("\n----------Machine side-----------");
        System.out.println("current product: " + vendA.getProductType());
        System.out.println("current product amount: " + vendA.getProductTotal());
        System.out.println("current money in machine: " + vendA.getVendingMoney());
        System.out.println("---------------------------------\n");
        System.out.println("cancel request: " + vendA.cancel());        
    }
}

// what if central set method?