'''
 IEEEXtreme 14.0 solutions
 Authors: team seaholic - https://github.com/adnaneaabbar
 Verdict: 13.4 points (15%)
'''

a_file = open("input.txt", 'r')
stop_words = next(a_file).replace('\n', '').split(';')
terms = next(a_file).replace('\n', '').split(';')
terms_dict = dict.fromkeys(terms, 0)
xmlstr = ''


from xml.etree import cElementTree as ElementTree
import re

for line in a_file:
    xmlstr += line.rstrip()
    xmlstr += " "
xmlstr = re.sub(r"""</?(?!(?:title|abstract|body)\b)[a-z](?:[^>"']|"[^"]*"|'[^']*')*>""", ' ', xmlstr)

for i in ',.?!':
    xmlstr = xmlstr.replace(i, "")
for i in stop_words:
    xmlstr = xmlstr.replace(i, "")
xmlstr = xmlstr.lower()
xmlstr = '<rami546>'+xmlstr+'</rami546>'
root = ElementTree.fromstring(xmlstr)
L = 0

for e in root.iter('title'):
    words = e.text.split(' ')
    for w in words:
        if len(w) > 3 and (w not in stop_words):
            L += 1
    for t in terms:
        terms_dict[t] += 5*words.count(t)


for e in root.iter('abstract'):
    words = e.text.split(' ')
    for w in words:
        if len(w) > 3 and (w not in stop_words):
            L += 1
    for t in terms:
        terms_dict[t] += 3*words.count(t)


for e in root.iter('body'):
    words = e.text.split(' ')
    for w in words:
        if len(w) > 3 and (w not in stop_words):
            L += 1
    for t in terms:
        terms_dict[t] += words.count(t)


import operator
ans = sorted(terms_dict.items(), key=lambda kv: (-kv[1], kv[0]))
for i in  range(3):
    if ans[i][1] != 0 and i < len(ans):
        print(ans[i][0],end='')
        print(": ", end='')
        print("{0:.8f}".format(100* ans[i][1]/L))
    else:
        break

i = 3
while(i < len(ans)):
    if (ans[2][1] == ans[i][1] and ans[i][1] != 0) :
        print(ans[i][0],end='')
        print(": ", end='')
        print("{0:.8f}".format(100 *ans[i][1]/L))
        i += 1
    else:
        break
