import json

with open("data/config.json", "r") as f:
    config = json.load(f)

print("🌍 Nexora AI Core v1")
print("Name:", config["name"])
print("Version:", config["version"])
print("Mode:", config["mode"])
print("Languages:", ", ".join(config["languages"]))
