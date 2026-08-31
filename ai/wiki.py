import requests

topic = input("Search: ")

url = f"https://en.wikipedia.org/api/rest_v1/page/summary/{topic}"

headers = {
    "User-Agent": "NexoraAI/1.0"
}

try:
    r = requests.get(url, headers=headers, timeout=10)
    if r.status_code == 200:
        data = r.json()
        print("\n🤖 Nexora Found:\n")
        print(data["extract"])
    else:
        print("Error: Wikipedia returned", r.status_code)
except Exception as e:
    print("Error:", e)
