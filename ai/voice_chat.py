import os

print("🎤 Nexora Voice AI (Urdu + English)")

while True:
    msg = input("You: ")

    if msg.lower() == "exit":
        os.system('termux-tts-speak -l en "Goodbye Bilal!"')
        break

    elif msg.lower() == "hello":
        reply = "Hello Bilal! I am Nexora AI."
        print("Nexora:", reply)
        os.system(f'termux-tts-speak -l en "{reply}"')

    elif msg.lower() == "salam":
        reply = "السلام علیکم بلال، میں نیکسورا ہوں۔"
        print("Nexora:", reply)
        os.system(f'termux-tts-speak -l ur "{reply}"')

    else:
        print("Nexora: I'm still learning.")
