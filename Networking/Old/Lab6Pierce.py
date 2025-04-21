import pandas as pd
import os
path = "C:/A_COMP309/data/"
filename = 'titanic.csv'
fullpath = os.path.join(path,filename)
## read
data_viji = pd.read_csv(fullpath)
print (data_viji.head(10))



import pandas as pd
data1_viji = pd.read_csv('C:\A_COMP309\data\Customer Churn Model.txt')
data1_viji.columns.values
print(data1_viji.columns.values)
data1_viji.dtypes
for col in data1_viji.columns:
print(col)
4- Read line by line below the code, change my firstname to your firstname::
data=open('C:\A_COMP309\data\Customer Churn Model.txt','r')
cols=data.readline().strip().split(',')
no_cols=len(cols)
