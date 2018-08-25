# <a name="top">Avaj-Launcher</a>
A program that simulates aircraft behavior due to weather changes. Implemented based on a given UML class diagram and required designed patterns.

## Contents

[Language & Design Patterns Used](#language_patterns) | [Project Requirements](#requirements) | [Usage & Examples](#usage_examples)

## <a name="Language_patterns">Language & Design Patterns Used</a>

The Avaj-Launcher program is written entirely in Java, implementing the following design patterns:

* Singleton
* Factory
* Observer

<a href="#top">↥ back to top</a>

## <a name="requirements">Project Requirements</a>

The simulator program was created based on the following UML diagram:

<img src="uml_diagram.jpg" width="800" height="500">

<a href="#top">↥ back to top</a>

## <a name="usage_examples">Usage & Examples</a>

The program takes the name of a scenario file as input from the command line and outputs a simulation.txt file with the simulation outcomes.

```bash
$ cat scenario.txt
4
Baloon B1 2 3 20
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
```

The first line of the scenario file contains the number of times the simulation is run. Each following line describes an aircraft that is part of the simulation with the following format: TYPE NAME LONGITUDE LATITUDE HEIGHT. 

A Makefile is provided for cleaning .class files, compiling .java files and executing the program.

```bash
$ python3 Makefile.py
usage: python3 Makefile.py [make | run | clean | makere] (filename)
$ python3 Makefile.py makere
Cleaning and recompiling...
$ python3 Makefile.py run scenario.txt
Executing...
```

Below is an example of a simulation outcome:

```bash
$ cat simulation.txt
Tower says: Balloon#B1(1) registered to weather tower.
Tower says: JetPlane#J1(2) registered to weather tower.
Tower says: Helicopter#H1(3) registered to weather tower.
Tower says: Helicopter#H2(4) registered to weather tower.
Balloon#B1(1): This is way too cold.
JetPlane#J1(2): It's raining. Better watch out for lightnings.
Helicopter#H1(3): My rotor is going to freeze!
Helicopter#H2(4): This is hot.
Balloon#B1(1): landing at 2, 3, 0 (long, lat, ht).
Tower says: Balloon#B1(1) unregistered from weather tower.
JetPlane#J1(2): It's raining. Better watch out for lightnings.
Helicopter#H1(3): I love rain.
Helicopter#H2(4): This is hot.
JetPlane#J1(2): It's raining. Better watch out for lightnings.
Helicopter#H1(3): I love rain.
Helicopter#H2(4): My rotor is going to freeze!
JetPlane#J1(2): It's raining. Better watch out for lightnings.
Helicopter#H1(3): I love rain.
Helicopter#H2(4): My rotor is going to freeze!
```

<a href="#top">↥ back to top</a>