import json

history = json.load(open("data/chat_history.json"))

print("💜 Welcome back Bilal!")

if history:
    print("\n🕒 Last Conversations:\n")
    for chat in history[-5:]:
        print("You:", chat["user"])
        print("Nexora:", chat["nexora"])
        print("-" * 20)
else:
    print("No previous conversation found.")
