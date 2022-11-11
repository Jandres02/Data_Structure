order = [8,5,2,6,9,3,1,4,0,7]

for i in range(len(order)):
    menor = i
    for  j in range(i+1,len(order)):
        if order[j] < order[menor]:
            menor = j
    if menor != i:
        order[i], order[menor] = order[menor], order[i]

print("La lista ordenada es:")
print(order)


