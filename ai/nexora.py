import json

history_file = "data/chat_history.json"

try:
    history = json.load(open(history_file))
except:
    history = []

while True:
    msg = input("You: ")

    if msg.lower() == "exit":
        break

    reply = f"You said: {msg}"

    history.append({"user": msg, "nexora": reply})
    json.dump(history, open(history_file, "w"), indent=2)

    print("Nexora:", reply)
