data=open('Customer Churn Model.txt', 'r')

cols=data.readline().strip().split(',')

no_cols=len(cols)

print(no_cols)

#### Finding the number of rows

counter=0
main_dict={}
for col in cols:
    main_dict[col]=[]
    print(main_dict)
for line in data:
    values = line.strip().split(',')
    for i in range(len(cols)):
        main_dict[cols[i]].append(values[i])
    counter += 1
print ("The dataset has %d rows and %d columns" % (counter,no_cols))

import pandas as pd

df_pierce=pd.DataFrame(main_dict)

print (df_pierce.head(15))


import pandas as pd
import os
path = ""
filename = 'titanic.csv'
fullpath = os.path.join(path,filename)
## read
data_pierce = pd.read_csv(fullpath)
print (data_pierce.head(10))


import pandas as pd
medal_data_pierce=pd.read_csv('https://raw.githubusercontent.com/lukes/ISO-3166-Countries-with-Regional-Codes/master/all/all.csv')
print (medal_data_pierce.head(5))