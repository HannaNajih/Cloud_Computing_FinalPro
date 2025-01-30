# Virtual Machine Placement (VMP) Optimization

## Project Overview

This project aims to optimize the placement of Virtual Machines (VMs) on Physical Machines (PMs) to minimize total energy consumption. The project leverages advanced algorithms like Genetic Algorithm (GA) and Large Neighborhood Search (LNS) to solve the Virtual Machine Placement (VMP) problem efficiently.

## Objectives

The primary objectives of this project are:
1. **Energy Optimization**: Instead of just optimizing for the number of physical machines used, the objective is to minimize the total energy consumption of the physical machines.
2. **Memory Constraints**: Incorporate memory constraints in addition to computational capacity constraints for each physical machine and virtual machine.
3. **Advanced Algorithms**: Implement and compare two advanced optimization algorithms:
   - Genetic Algorithm (GA)
   - Large Neighborhood Search (LNS)
4. **Scalability**: Test the scalability of the algorithms by varying the number of virtual and physical machines.

## Project Structure
VMP-Project/
├── src/ <br>
│ ├── main/<br>
│ │ ├── java/<br>
│ │ │ ├── VirtualMachine.java<br>
│ │ │ ├── PhysicalMachine.java<br>
│ │ │ ├── GeneticAlgorithm.java<br>
│ │ │ ├── LargeNeighborhoodSearch.java<br>
│ │ │ └── VMP.java<br>
│ └── test/<br>
│ └── java/<br>
├── lib/<br>
├── .gitignore<br>
├── README.md<br>
└── pom.xml<br>
### Explanation of Project Structure

- **src/main/java**: Contains the main application code.
  - **VirtualMachine.java**: Defines the `VirtualMachine` class with properties like MIPS and memory requirements.
  - **PhysicalMachine.java**: Defines the `PhysicalMachine` class with properties like computational capacity, memory capacity, and power consumption.
  - **GeneticAlgorithm.java**: Implements the Genetic Algorithm for VM placement optimization.
  - **LargeNeighborhoodSearch.java**: Implements the Large Neighborhood Search algorithm for VM placement optimization.
  - **VMP.java**: Contains the main class to run the project and execute scenarios for comparison.
- **src/test/java**: Placeholder for unit tests (if any).
- **lib/**: Directory for external libraries (if needed).
- **.gitignore**: Specifies files and directories to be ignored by Git.
- **README.md**: This file, providing an overview and instructions for the project.
- **pom.xml**: Maven configuration file for managing project dependencies and build configurations.

## Importance of the Project

Virtual Machine Placement (VMP) is a critical problem in cloud computing environments. Efficient VMP can lead to significant improvements in resource utilization and energy efficiency. Here are some key reasons why this project is important:

1. **Energy Efficiency**: Data centers consume a significant amount of energy. By optimizing VM placement to minimize energy consumption, this project contributes to reducing the carbon footprint of data centers.
2. **Resource Utilization**: Efficient VM placement ensures that physical resources (CPU, memory) are utilized optimally, leading to better performance and cost savings.
3. **Scalability**: As cloud environments scale, the ability to efficiently place VMs becomes increasingly complex. This project explores advanced algorithms that can handle scalability challenges.
4. **Advanced Algorithms**: By implementing and comparing Genetic Algorithm and Large Neighborhood Search, this project showcases the effectiveness of different optimization techniques in solving complex problems.

## How to Run the Project

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven

### Steps to Run

1. **Clone the Repository**:
   ```sh
   git clone (https://github.com/HannaNajih/Cloud_Computing_FinalPro.git)
   cd virtualmachineplacement

   Scenarios
The project includes two scenarios to test the scalability and performance of the algorithms:

Scenario One: Increase the number of virtual machines from 50 to 250 in increments of 50, keeping the number of physical machines fixed at 100.
Scenario Two: Increase the number of physical machines from 50 to 150 in increments of 25, keeping the number of virtual machines fixed at 200.
The results from these scenarios, including the number of active physical machines and total energy consumption, will be compared and analyzed.

## Conclusion
This project provides valuable insights into optimizing virtual machine placement in cloud computing environments. By reducing energy consumption and improving resource utilization, it contributes to more sustainable and cost-effective data center operations.

Feel free to contribute to this project by submitting issues or pull requests on GitHub.

Thank you for using this project! If you have any questions or feedback, contact me.
