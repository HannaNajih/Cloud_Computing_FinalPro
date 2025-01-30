package com.hanna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class GeneticAlgorithm {
    List<PhysicalMachine> physicalMachines;
    List<VirtualMachine> virtualMachines;
    int populationSize;
    int generations;

    GeneticAlgorithm(List<PhysicalMachine> pms, List<VirtualMachine> vms, int populationSize, int generations) {
        this.physicalMachines = pms;
        this.virtualMachines = vms;
        this.populationSize = populationSize;
        this.generations = generations;
    }

    public List<List<Integer>> initializePopulation() {
        List<List<Integer>> population = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < populationSize; i++) {
            List<Integer> individual = new ArrayList<>();
            for (int j = 0; j < virtualMachines.size(); j++) {
                individual.add(rand.nextInt(physicalMachines.size()));
            }
            population.add(individual);
        }
        return population;
    }

    public double fitness(List<Integer> individual) {
        double totalEnergy = 0;
        for (int i = 0; i < physicalMachines.size(); i++) {
            int totalMips = 0;
            int totalMemory = 0;
            for (int j = 0; j < virtualMachines.size(); j++) {
                if (individual.get(j) == i) {
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

    public List<List<Integer>> select(List<List<Integer>> population) {
        Collections.sort(population, (a, b) -> Double.compare(fitness(a), fitness(b)));
        return population.subList(0, populationSize / 2);
    }

    public List<Integer> crossover(List<Integer> parent1, List<Integer> parent2) {
        Random rand = new Random();
        int crossoverPoint = rand.nextInt(parent1.size());
        List<Integer> child = new ArrayList<>();
        for (int i = 0; i < parent1.size(); i++) {
            if (i < crossoverPoint) {
                child.add(parent1.get(i));
            } else {
                child.add(parent2.get(i));
            }
        }
        return child;
    }

    public List<Integer> mutate(List<Integer> individual) {
        Random rand = new Random();
        int mutationPoint = rand.nextInt(individual.size());
        individual.set(mutationPoint, rand.nextInt(physicalMachines.size()));
        return individual;
    }

    public List<Integer> run() {
        List<List<Integer>> population = initializePopulation();
        for (int gen = 0; gen < generations; gen++) {
            List<List<Integer>> selected = select(population);
            List<List<Integer>> newPopulation = new ArrayList<>(selected);
            while (newPopulation.size() < populationSize) {
                Random rand = new Random();
                List<Integer> parent1 = selected.get(rand.nextInt(selected.size()));
                List<Integer> parent2 = selected.get(rand.nextInt(selected.size()));
                List<Integer> child = crossover(parent1, parent2);
                if (rand.nextDouble() < 0.1) {
                    mutate(child);
                }
                newPopulation.add(child);
            }
            population = newPopulation;
        }
        return population.get(0);
    }
}