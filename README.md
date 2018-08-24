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
25
Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```

The first line of the scenario file contains the number of times the simulation is run. Each following line describes an aircraft that is part of the simulation with the following format: TYPE NAME LONGITUDE LATITUDE HEIGHT. 

Below is an example of a simulation outcome:

```bash
$ java Simulator scenario.txt
$ cat simulation.txt
Tower says: Baloon#B1(1) registered to weather tower.
Tower says: JetPlane#J1(2) registered to weather tower.
Tower says: Helicopter#H1(3) registered to weather tower.
Tower says: Helicopter#H4(4) registered to weather tower.
Baloon#B1(1): Let's enjoy the good weather and take some pics.
JetPlane#J1(2): It's raining. Better watch out for lightings.
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!
Baloon#B1(1): Damn you rain! You messed up my baloon.
JetPlane#J1(2): OMG! Winter is coming!
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!
Baloon#B1(1): It's snowing. We're gonna crash.
JetPlane#J1(2): It's raining. Better watch out for lightings.
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!
Baloon#B1(1): Damn you rain! You messed up my baloon.
Baloon#B1(1) landing.
Tower says: Baloon#B1(1) unregistered from weather tower.
JetPlane#J1(2): OMG! Winter is coming!
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!
```

<a href="#top">↥ back to top</a>