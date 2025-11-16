from textblob import TextBlob

# txt = TextBlob("Hello, World!")

# print(txt.tags)

txt = TextBlob("go north")

parsedTags = txt.tags

for word in parsedTags:
    if word[1] == 'VB':
        if word[0] == 'go':
            continue
        else:
            print("Error, no verb. Start with a verb and then noun.")
    elif word[1] == 'JJ':
        if word[0] == 'north':
            print("You've went north.")
        else:
            print("Error, no noun. Start with a verb and then noun.")

