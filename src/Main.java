public class Main {
    public static void main(String[] args) {
        DictionaryBST bst = new DictionaryBST();
        StrBSTPrinter printer = new StrBSTPrinter();

        print("Testies... Testies... 1, 2, shree!");
        print();

//        print("Attempting to insert values \"M, O, N, L, P, Q, H\"");
//        bst.insert("M");
//        bst.insert("O");
//        bst.insert("N");
//        bst.insert("L");
//        bst.insert("P");
//        bst.insert("Q");
//        bst.insert("H");
        bst.insert("small", "");
        bst.insert("FIFTY", "A rather valuable number");
        bst.insert("Long", "The size of my penis");
        bst.insert("big", "A synonym for the size of my penis");
        bst.insert("young", "The age I wish I was");

        bst.printDictionaryItem("");
        bst.printDictionaryItem("youNg");
        bst.printDictionaryItem("FiftY");
        bst.printDictionaryItem("Long");
        bst.printDictionaryItem("BIG");
        bst.printDictionaryItem("small");
        bst.printDictionaryItem("hehehehe");

        bst.search("LoNg");
        bst.search("big");
        print();

        bst.remove("FIFty");
        //printer.printNode(bst.root);
        print();

        bst.remove("small");
        //printer.printNode(bst.root);
        print();

        bst.print();

//        print("Compare Test: (0 = Equal, null or empty || -1 = string1 < string1 || 1 = string1 > string2)");
//        print("z vs. Z = " + Test.compareTo("z","Z"));
//        print("a vs. Z = " + Test.compareTo("a","Z"));
//        print("A vs. z = " + Test.compareTo("A","z"));
//        print("\"\" vs. null = " + Test.compareTo("", null));
//        print("null vs. null = " + Test.compareTo(null,null));
//        print("\"\" vs. \"\" = " + Test.compareTo("",""));
//        print("test vs. testicle = " + Test.compareTo("test","testicle"));
//        print("testicle vs. testicle = " + Test.compareTo("testicle", "testicle"));
//        print("testicle vs. test = " + Test.compareTo("testicle", "test"));


    } // end void

    public static void print() {
        print("");

    } // end void
    public static void print(String msg) {
        System.out.println(msg);

    } // end void

} // end class