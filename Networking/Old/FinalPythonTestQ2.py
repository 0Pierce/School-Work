#Imports
import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt

#Load the data
df2_pierce = pd.read_csv('MissisaguaDealer.txt', sep='\t')

#1 Explore the data
print("Column names:")
print(df2_pierce.columns)

print("\n Column types:")
print(df2_pierce.dtypes)

print("\n Numeric columns statistics:")
print(df2_pierce.select_dtypes(include=[np.number]).describe(percentiles=[.25, .5, .75]))

print("\n First three records:")
print(df2_pierce.head(3))

print("\n Missing values summary:")
print(df2_pierce.isnull().sum())

#2 Preprocess the data
#Convert categorical columns to numeric
df2_pierce_numeric = pd.get_dummies(df2_pierce, drop_first=True)

#Check for missing values
print("\n Missing values after preprocessing:")
print(df2_pierce_numeric.isnull().sum())

#Standardize the data
scaler = StandardScaler()
df2_pierce_standardized = pd.DataFrame(scaler.fit_transform(df2_pierce_numeric),
                                       columns=df2_pierce_numeric.columns)

print("\n Standardized data statistics:")
print(df2_pierce_standardized.describe(percentiles=[.25, .5, .75]))

#3 Build the model
kmeans = KMeans(n_clusters=5, random_state=42)
df2_pierce_standardized['cluster_pierce'] = kmeans.fit_predict(df2_pierce_standardized)

#Plot histogram of clusters
plt.figure(figsize=(10, 6))
df2_pierce_standardized['cluster_pierce'].hist()
plt.title('pierce_clusters')
plt.xlabel('Cluster')
plt.ylabel('Number of Observations')
plt.savefig('pierce_missisagua_dealer.png')
plt.close()

#Print number of observations in each cluster
print("\n Number of observations in each cluster:")
print(df2_pierce_standardized['cluster_pierce'].value_counts())