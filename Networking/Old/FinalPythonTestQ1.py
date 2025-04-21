#Imports
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.model_selection import train_test_split, cross_val_score
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import confusion_matrix, accuracy_score

#Load the dataset into dataframe
df_pierce = pd.read_csv('customer_churn_dataset.csv')

#1 Print all the data inside the dataset
print("1. Column Names:")
print(df_pierce.columns)

print("\n 2. Column Types:")
print(df_pierce.dtypes)

print("\n 3. Unique Values in Each Column:")
for column in df_pierce.columns:
    print(f"{column}: {df_pierce[column].nunique()}")

print("\n 4. Statistics of Numeric Columns:")
print(df_pierce.describe())

print("\n 5. First Four Records:")
print(df_pierce.head(4))

print("\n 6. Missing Values Summary:")
print(df_pierce.isnull().sum())

#Counts unique values for specific columns
print("\n 7. Count of Unique Values in 'Contract Length' Column:")
print(df_pierce['Contract Length'].value_counts())

print("\n 8. Count of Unique Values in 'Subscription Type' Column:")
print(df_pierce['Subscription Type'].value_counts())

#2 Visualize the Data
#Histogram for 'Age' with 10 bins
#Graphs are being saved locally since I am not open to visualize the graphs due to a pycharm error
plt.figure(figsize=(10, 6))
plt.hist(df_pierce['Age'], bins=10, color='blue', edgecolor='black')
plt.xlabel('Age')
plt.ylabel('Frequency')
plt.title('pierce_Age')
plt.savefig('pierce_Age.png')
plt.close()

#Scatter plot for 'Age' vs 'Total Spend'
plt.figure(figsize=(10, 6))
plt.scatter(df_pierce['Age'], df_pierce['Total Spend'])
plt.xlabel('Age')
plt.ylabel('Total Spend')
plt.title('pierce_Age_scatter')
plt.savefig('pierce_Age_scatter.png')
plt.close()

#Scatter matrix
numeric_columns = df_pierce.select_dtypes(include=['number']).columns
sns.pairplot(df_pierce[numeric_columns], diag_kind='kde')
plt.savefig('scatter_matrix.png')
plt.close()

#3 Pre-process the Data
#Drop the column with the most missing values (Assuming there is one) But there is
df_pierce_cleaned = df_pierce.dropna(axis=1, thresh=int(df_pierce.shape[0] * 0.5), inplace=False)

#Replace missing values in Total Spend with the mean
df_pierce_cleaned['Total Spend'].fillna(df_pierce_cleaned['Total Spend'].mean(), inplace=True)

#Check for more missing values
print("\n Missing Values After Cleaning:")
print(df_pierce_cleaned.isnull().sum())

#Convert columns to numeric
categorical_columns = ['Gender', 'Subscription Type', 'Contract Length']
df_pierce_numeric = pd.get_dummies(df_pierce_cleaned, columns=categorical_columns, drop_first=True)

#Makes sure its numeric
df_pierce_numeric = df_pierce_numeric.select_dtypes(include=['number'])

#4 Build a Model and Validate
#Splits data into 30% and 70% (test_size = 30%) so remaining is 70%
X = df_pierce_numeric.drop('Churn', axis=1)
y = df_pierce_numeric['Churn']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

#Init Decision Tree Class
dt_pierce = DecisionTreeClassifier(criterion='entropy', max_depth=6, min_samples_split=15, random_state=42)

#Perform cross-val
cv_scores = cross_val_score(dt_pierce, X_train, y_train, cv=8)
print("\nMean Accuracy of 8-fold Cross-Validation:", cv_scores.mean())

#Train the model
dt_pierce.fit(X_train, y_train)

#Test the model
y_pred = dt_pierce.predict(X_test)

#Eval the model
print("\n Accuracy of the Test:", accuracy_score(y_test, y_pred))

#Confusion matrix
conf_matrix = confusion_matrix(y_test, y_pred)
print("\n Confusion Matrix:")
print(conf_matrix)

#5 Prune the tree and vary the max depth using entropy
depths = range(1, 9)
for depth in depths:
    dt_pierce_pruned = DecisionTreeClassifier(criterion='entropy', max_depth=depth, min_samples_split=15, random_state=42)
    cv_scores_pruned = cross_val_score(dt_pierce_pruned, X_train, y_train, cv=8)
    print(f"\n Mean Accuracy for Max Depth {depth}: {cv_scores_pruned.mean()}")

