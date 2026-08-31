import json

knowledge = json.load(open("data/knowledge.json"))
memory = json.load(open("data/user_memory.json"))

print(f"🤖 Welcome back, {memory['name']}!")

while True:
    msg = input("You: ").lower()

    if msg == "exit":
        print(f"Nexora: Allah Hafiz, {memory['name']}! 👋")
        break

    elif msg in knowledge:
        print("Nexora:", knowledge[msg])

    else:
        print("Nexora: I don't know this yet. Teach me in the future.")
