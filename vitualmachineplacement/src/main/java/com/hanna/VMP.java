package com.hanna;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.List;

public class VMP {
    public static void main(String[] args) {
        // Scenario One: Increase the number of virtual machines
        for (int vmCount = 50; vmCount <= 250; vmCount += 50) {
            List<VirtualMachine> vms = new ArrayList<>();
            for (int i = 0; i < vmCount; i++) {
                vms.add(new VirtualMachine(i));
            }

            List<PhysicalMachine> pms = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                pms.add(new PhysicalMachine(i));
            }

            GeneticAlgorithm ga = new GeneticAlgorithm(pms, vms, 50, 100);
            List<Integer> gaSolution = ga.run();
            double gaFitness = ga.fitness(gaSolution);

            LargeNeighborhoodSearch lns = new LargeNeighborhoodSearch(pms, vms, 1000);
            List<Integer> lnsSolution = lns.run();
            double lnsFitness = lns.fitness(lnsSolution);

            System.out.println("Scenario One - VMs: " + vmCount);
            System.out.println("GA Fitness: " + gaFitness);
            System.out.println("LNS Fitness: " + lnsFitness);
            System.out.println();
        }

        // Scenario Two: Increase the number of physical machines
        for (int pmCount = 50; pmCount <= 150; pmCount += 25) {
            List<VirtualMachine> vms = new ArrayList<>();
            for (int i = 0; i < 200; i++) {
                vms.add(new VirtualMachine(i));
            }

            List<PhysicalMachine> pms = new ArrayList<>();
            for (int i = 0; i < pmCount; i++) {
                pms.add(new PhysicalMachine(i));
            }

            GeneticAlgorithm ga = new GeneticAlgorithm(pms, vms, 50, 100);
            List<Integer> gaSolution = ga.run();
            double gaFitness = ga.fitness(gaSolution);

            LargeNeighborhoodSearch lns = new LargeNeighborhoodSearch(pms, vms, 1000);
            List<Integer> lnsSolution = lns.run();
            double lnsFitness = lns.fitness(lnsSolution);

            System.out.println("Scenario Two - PMs: " + pmCount);
            System.out.println("GA Fitness: " + gaFitness);
            System.out.println("LNS Fitness: " + lnsFitness);
            System.out.println();
        }
    }
}