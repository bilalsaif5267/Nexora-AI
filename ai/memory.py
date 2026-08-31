import json

with open("data/user_memory.json","r") as f:
    user = json.load(f)

print("🤖 NEXORA MEMORY")
print("Welcome back,", user["name"])
print("Favorite Color:", user["favorite_color"])
print("Project:", user["project"])
