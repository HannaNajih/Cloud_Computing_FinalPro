package com.hanna;
import java.util.Random;

class VirtualMachine {
    int id;
    int mips;
    int memory;

    VirtualMachine(int id) {
        Random rand = new Random();
        this.id = id;
        this.mips = 500 + rand.nextInt(3501); // Random value between 500 and 4000
        this.memory = 1 + rand.nextInt(8); // Random value between 1 and 8 GB
    }
}
