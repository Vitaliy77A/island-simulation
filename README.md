Island Simulation Project

A multithreaded ecosystem simulation featuring animals and plants.
An educational project for the JavaRush course.

Description

The island is represented as a grid of locations (a matrix). Each location contains various species of animals (predators and herbivores) as well as plants.
Every animal has its own life cycle, executed in separate threads.

Core mechanics:

Feeding: Predators hunt herbivores; herbivores eat plants. Each hunt has its own success chance.

Reproduction: Animals reproduce when a pair is available and there is free space.

Movement: Animals roam between neighboring cells.

Death: Animals die from hunger or old age.

Technologies

Java Core (Collections, OOP)

Multithreading (ExecutorService, ScheduledExecutorService, Callable)

Thread Safety (ConcurrentHashMap, CopyOnWriteArrayList, Atomic types)

How to Run

Clone the repository.

Open the project in IntelliJ IDEA.

Find the Main.java class (path: src/main/java/.../island/Main.java).

Run the main() method.

Configuration

Simulation parameters (birth chance, weight, speed, max population, etc.) can be customized in:
src/main/java/.../island/utilits/factory/OrganismConfig.java

Statistics

The console prints updated statistics every second, showing the current number of animals on the island.
The simulation stops automatically if all animals die out, or you can stop it manually at any moment.