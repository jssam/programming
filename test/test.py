
case=int(input())

for num in range(case):
    s=input()

    m=input()
    t=input()
    m=[int(x) for x in m.split()]
    t=[int(x) for x in t.split()]

    one=t[0]
    tw=t[1]

    p1=[]
    p2=[]

    for i in range(len(m)):
        if not p1:
            p1.append(m[one])
        else:
            p1.append(m[p1[i-1]])

        if not p2:
            p2.append(m[tw])
        else:
            p2.append(m[p2[i-1]])

    l=[]
    try:
        for x in p1:
            l.append(p2.index(x))
        ans=p2[min(l)]
    except Exception as e:
        ans = -1

    print(ans)