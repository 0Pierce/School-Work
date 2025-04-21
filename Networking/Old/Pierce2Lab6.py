import pandas as pd
data_pierce=pd.read_csv('titanic.csv')
######### get first five records
data_pierce.head(5)
######### get the shape of data
data_pierce.shape
######## get the column values
data_pierce.columns.values
# or
print(data_pierce.columns.values)
# or
for col in data_pierce.columns:
    print(col)
###### create summaries of data
data_pierce.describe()
##### get the types of columns
data_pierce.dtypes

####Imputation
# Fill the missing values with zeros
import pandas as pd
data_pierce=pd.read_csv('C:/A_COMP309/data/titanic.csv')
data_pierce.fillna(0, inplace=True)
data_pierce.head()
# Fill the missing values with "missing"
import pandas as pd
data_pierce=pd.read_csv('C:/A_COMP309/data/titanic.csv')
data_pierce.fillna("missing", inplace=True)
data_pierce.head(30)
# fill only a column
import pandas as pd
data_pierce=pd.read_csv('C:/A_COMP309/data/titanic.csv')
data_pierce['body'].head(30)
##
data_pierce['body'].fillna("missing", inplace=True)
data_pierce['body'].head(30)
# use the average to fill in the missing age
import pandas as pd
data_pierce=pd.read_csv('C:/A_COMP309/data/titanic.csv')
data_pierce['age'].head(30)
## get the age mean
print(data_pierce['age'].mean())
##
data_pierce['age'].fillna(data_pierce['age'].mean(), inplace=True)
data_pierce['age'].head(30)


import pandas as pd
data_pierce=pd.read_csv('titanic.csv')
data_pierce.columns.values
# create dummy dataframe
dummy_sex=pd.get_dummies(data_pierce['sex'], prefix='sex')
print(dummy_sex.head())
dummy_sex.head()
# join the dummy datframe to the original dataset and remove the original column
column_name=data_pierce.columns.values.tolist()
column_name
column_name.remove('sex')
column_name
data_pierce[column_name].join(dummy_sex)
print(data_pierce[column_name].join(dummy_sex))


import matplotlib.pyplot as plt
import pandas as pd
data1_pierce = pd.read_csv('Customer Churn Model.txt')
print(data1_pierce.columns.values)
#create a scatterplot
fig_pierce = data1_pierce.plot(kind='scatter', x='Day Mins', y='Day Charge')
# Save the scatter plot
fig_pierce.figure.savefig('ScatterPlot.pdf')
figure,axs = plt.subplots(2, 2,sharey=True,sharex=True)
data1_pierce.plot(kind='scatter', x='Day Mins', y='Day Charge', ax=axs[0][0])
data1_pierce.plot(kind='scatter', x='Night Mins', y='Night Charge', ax=axs[0][1])
data1_pierce.plot(kind='scatter', x='Day Calls', y='Day Charge', ax=axs[1][0])
data1_pierce.plot(kind='scatter', x='Night Calls', y='Night Charge', ax=axs[1][1])
plt.show()
#plot a histrogram
plt.hist(data1_pierce['Day Calls'], bins=8)
plt.xlabel('Day Calls Value')
plt.ylabel('Frequency')
plt.title('Frequency of Day Calls')
plt.show()
#Plot a histrogram
import matplotlib.pyplot as plt
plt.boxplot(data1_pierce['Day Calls'])
plt.ylabel('Day Calls')
plt.title('Box Plot of Day Calls')
plt.show()


#######################################################
#Sub setting the data slicing and dicing
#######################################################
## Columns
import pandas as pd
import os
path = "data"
filename = 'Customer Churn Model.txt'
fullpath = os.path.join(path,filename)
data_pierce = pd.read_csv(fullpath)
print(data_pierce.columns.values)
# extract one column (i.e. a series)
account_length=data_pierce['Account Length']
print(account_length.head(50))
type(account_length)
#extract many columns into a new dataframe
subdata_pierce = data_pierce[['Account Length', 'VMail Message', 'Day Calls']]
subdata_pierce.head()
type(subdata_pierce)
# Create a list of wanted columns
wanted_columns=['Account Length','VMail Message','Day Calls']
subdata_pierce=data_pierce[wanted_columns]
print(subdata_pierce.head())
## Another way useful when many columns
wanted=['Account Length','VMail Message','Day Calls']
column_list=data_pierce.columns.values.tolist()
sublist=[x for x in column_list if x not in wanted]
subdata=data_pierce[sublist]
subdata_pierce.head()
## Rows
#Select the first 50 rows
data_pierce[:50]
# select 50 rows starting at 25
print(data_pierce[25:75])
# filter the rows that have clocked day Mins to be greater than 350.
sub_data_pierce=data_pierce[data_pierce['Day Mins'] > 350]
sub_data_pierce.shape
sub_data_pierce
#filter the rows for which the state is VA:
sub_data_pierce=data_pierce[data_pierce['State'] == 'VA']
sub_data_pierce.shape
sub_data_pierce
#filter the rows that have clocked day Mins to be greater than 150 and the state value is VA
sub_data_pierce=data_pierce[(data_pierce['Day Mins'] > 150) & (data_pierce['State'] == 'VA')]
sub_data_pierce.shape
sub_data_pierce[['State', 'Day Mins']]
## Create a new column for total minutes
data_pierce['Total Mins']= data_pierce['Day Mins'] + data_pierce['Eve Mins'] + data_pierce['Night Mins']