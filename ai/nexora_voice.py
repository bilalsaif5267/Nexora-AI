import os

print("🎤 Say something to Nexora...")

os.system("termux-speech-to-text > speech.json")

text = open("speech.json").read().lower()
print("You said:", text)

if "hello" in text:
    reply = "Hello Bilal! I am Nexora AI."
    os.system(f'termux-tts-speak -l en "{reply}"')
elif "salam" in text:
    reply = "السلام علیکم بلال! آپ کیسے ہیں؟"
    os.system(f'termux-tts-speak -l ur "{reply}"')
else:
    reply = "I am still learning."
    os.system(f'termux-tts-speak -l en "{reply}"')

print("Nexora:", reply)
