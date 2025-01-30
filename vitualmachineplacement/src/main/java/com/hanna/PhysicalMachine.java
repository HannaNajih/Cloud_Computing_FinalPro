package com.hanna;

import java.util.Random;

class PhysicalMachine {
    int id;
    int mips;
    int memory;
    int powerFullLoad;
    int powerIdle;

    PhysicalMachine(int id) {
        Random rand = new Random();
        this.id = id;
        this.mips = 8000 + rand.nextInt(24001); // Random value between 8000 and 32000
        this.memory = 32 + rand.nextInt(97); // Random value between 32 and 128 GB
        this.powerFullLoad = 400 + rand.nextInt(401); // Random value between 400 and 800 watts
        this.powerIdle = (int)(this.powerFullLoad * (0.60 + (0.10 * rand.nextDouble()))); // 60% to 70% of full load power
    }

    public PhysicalMachine() {
    }
}