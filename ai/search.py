import requests

query = input("Ask Nexora: ")

url = "https://api.duckduckgo.com/"

params = {
    "q": query,
    "format": "json",
    "no_html": 1,
    "skip_disambig": 1
}

data = requests.get(url, params=params,
                    headers={"User-Agent": "NexoraAI/1.0"}).json()

answer = data.get("AbstractText") or data.get("Heading") or "No instant answer found."

print("\n🤖 Nexora Search Result:\n")
print(answer)
