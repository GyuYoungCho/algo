import sys
import re
input = sys.stdin.readline

arr = input().strip()
divs = arr.split('<div title="')
pa = re.compile(r'<[a-z/ ]+>')
for div in divs[1:]:
    p_list = div.split('<p>')
    title = p_list.pop(0)
    print('title :', title[:-2])
    for ps in p_list:
        ps = re.sub(pa, '', ps).strip()

        ps = re.sub(' +', ' ', ps).strip()
        print(ps)