from ast import List
import math

with open("E:\\Code\\VSCode\\Temp\\temp.txt", "r", encoding="utf-8") as file:
    text = file.read()

entries = text.split("-")

with open("E:\\Code\\VSCode\\Temp\\output.txt", "w", encoding="utf-8") as output_file:
    for entry in entries:
        parts = entry.split("&")
        print(parts)
        if len(parts) == 2:
            word, definition = map(str.strip, parts)
            formatted_line = f'Insert into cet4 VALUES("{word}", "{definition}");\n'
            output_file.write(formatted_line)
