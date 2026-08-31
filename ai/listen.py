import os

print("🎤 Nexora Listening...")

os.system("termux-speech-to-text > speech.json")

try:
    with open("speech.json","r") as f:
        print("You said:", f.read())
except:
    print("Couldn't hear anything.")
