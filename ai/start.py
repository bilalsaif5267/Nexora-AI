import json

personality = json.load(open("data/personality.json"))
memory = json.load(open("data/user_memory.json"))

print(f"💜 Welcome back, {memory['name']}!")
print(f"🤖 I am {personality['name']}")
print(f"🌍 Mission: {personality['mission']}")
print(f"🎨 Theme: {personality['theme']}")
