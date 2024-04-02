
package Product;

import java.util.*;
import java.time.*;


public class MainBoard extends iProduct {
   
    private String cpu;
    private String memory;    
    private String disk;

    public MainBoard(String maker, int totalquantity, int price) {   	
    	setMaker(maker);
    	setKind("MAINBOARD");
    	setPrice(price);
    	setTotalquantity(totalquantity);
    	cpu = "i6";
    }
    
    public String getCpu() {
        return cpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }
    public void showitem() {
    	System.out.println(kind + ":" + maker+  ":" + totalquantity +  ":" +price + " cpu : " + cpu);
   
    }

}