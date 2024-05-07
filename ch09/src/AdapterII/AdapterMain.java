package AdapterII;

import AdapterI.PrintBanner;

public class AdapterMain {
    public static void main(String[] args) {
        PrintBanner pb = new PrintBanner("Test");

        pb.printWeak();
        pb.printStrong();
    }
}