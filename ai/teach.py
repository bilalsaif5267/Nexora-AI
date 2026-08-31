import json

file = "data/knowledge.json"

with open(file, "r") as f:
    knowledge = json.load(f)

key = input("Teach word: ").lower()
value = input("Meaning: ")

knowledge[key] = value

with open(file, "w") as f:
    json.dump(knowledge, f, indent=2)

print("✅ Nexora learned:", key)
