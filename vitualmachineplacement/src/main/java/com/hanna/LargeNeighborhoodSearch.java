package com.hanna;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class LargeNeighborhoodSearch {
    List<PhysicalMachine> physicalMachines;
    List<VirtualMachine> virtualMachines;
    int iterations;

    LargeNeighborhoodSearch(List<PhysicalMachine> pms, List<VirtualMachine> vms, int iterations) {
        this.physicalMachines = pms;
        this.virtualMachines = vms;
        this.iterations = iterations;
    }

    public List<Integer> initializeSolution() {
        List<Integer> solution = new ArrayList<>();
        Random rand = new Random();
        for (VirtualMachine virtualMachine : virtualMachines) {
            solution.add(rand.nextInt(physicalMachines.size()));
        }
        return solution;
    }

    public double fitness(List<Integer> solution) {
        double totalEnergy = 0;
        for (int i = 0; i < physicalMachines.size(); i++) {
            int totalMips = 0;
            int totalMemory = 0;
            for (int j = 0; j < virtualMachines.size(); j++) {
                if (solution.get(j) == i) {
                    totalMips += virtualMachines.get(j).mips;
                    totalMemory += virtualMachines.get(j).memory;
                }
            }
            if (totalMips > 0 && totalMemory > 0) {
                totalEnergy += physicalMachines.get(i).powerFullLoad * (totalMips / (double) physicalMachines.get(i).mips);
            } else {
                totalEnergy += physicalMachines.get(i).powerIdle;
            }
        }
        return totalEnergy;
    }

    public List<Integer> perturb(List<Integer> solution) {
        Random rand = new Random();
        int perturbPoint = rand.nextInt(solution.size());
        solution.set(perturbPoint, rand.nextInt(physicalMachines.size()));
        return solution;
    }

    public List<Integer> run() {
        List<Integer> bestSolution = initializeSolution();
        double bestFitness = fitness(bestSolution);

        for (int iter = 0; iter < iterations; iter++) {
            List<Integer> newSolution = new ArrayList<>(bestSolution);
            newSolution = perturb(newSolution);
            double newFitness = fitness(newSolution);
            if (newFitness < bestFitness) {
                bestSolution = newSolution;
                bestFitness = newFitness;
            }
        }
        return bestSolution;
    }
}