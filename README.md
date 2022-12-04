# Advent of Code 2022

My attempt at [Advent of Code 2022](https://adventofcode.com/) in
[Scala 2.13.10](https://www.scala-lang.org/download/2.13.10.html).

## --- Day 1: Calorie Counting ---

Suppose the Elves finish writing their items' Calories and end up with the following list:

```text
1000
2000
3000

4000

5000
6000

7000
8000
9000

10000
```

This list represents the Calories of the food carried by five Elves:

- The second Elf is carrying one food item with **4000** Calories.
- The third Elf is carrying food with **5000** and **6000** Calories, a total of 11000 Calories.
- The fourth Elf is carrying food with **7000**, **8000**, and **9000** Calories, a total of 24000 Calories.
- The fifth Elf is carrying one food item with **10000** Calories.

In case the Elves get hungry and need extra snacks, they need to know which Elf to ask: 
they'd like to know how many Calories are being carried by the Elf carrying the most Calories. 

In the example above, this is **24000** (carried by the fourth Elf).

Find the Elf carrying the most Calories. **How many total Calories is that Elf carrying?**
