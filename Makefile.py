import os, sys

print("Cleaning...")
os.system('find . -name "*.class" -type f -print0 | xargs -0 /bin/rm -f')
print("Recompiling...")
os.system('javac launcher/avaj/simulator/Simulator.java')
print("Executing...")

if len(sys.argv) > 1:
	filename = sys.argv[1]
else:
	filename = ""

os.system('java launcher/avaj/simulator/Simulator ' + filename)
