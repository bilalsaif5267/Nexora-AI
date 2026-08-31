import json

memory_file = "data/user_memory.json"

with open(memory_file, "r") as f:
    memory = json.load(f)

key = input("Remember what? ")
value = input("Value: ")

memory[key] = value

with open(memory_file, "w") as f:
    json.dump(memory, f, indent=2)

print("✅ Memory saved!")
