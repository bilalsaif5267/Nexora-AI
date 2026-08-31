import time
import sys

def nexora_reply(text):
    print("🤖 Nexora:", end=" ", flush=True)
    for ch in text:
        print(ch, end="", flush=True)
        time.sleep(0.03)
    print()

nexora_reply("Hello Bilal! Welcome back to Nexora AI 💜")
