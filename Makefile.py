import os, sys

filename = ""
clean = 'find . -name "*.class" -type f -print0 | xargs -0 /bin/rm -f'
make = 'javac launcher/avaj/simulator/Simulator.java'
run = 'java launcher/avaj/simulator/Simulator '
usage = "usage: python3 Makefile.py [make | run | clean | makere] (filename)"

if len(sys.argv) >= 3:
	filename = sys.argv[2]

if len(sys.argv) >= 2:
	if sys.argv[1] == "make":
		print("Compiling...")
		os.system(make)	
	elif sys.argv[1] =="run":
		print("Executing...")
		os.system(run + filename)	
	elif sys.argv[1] == "clean":
		print("Cleaning...")
		os.system(clean)
	elif sys.argv[1] == "makere":
		print("Cleaning and compiling...")
		os.system(clean + "&&" + make)
	else:
		print(usage)
else:
	print(usage)



