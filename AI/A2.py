import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, LabelEncoder
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix

print("=====Exercise 1=====")

#Load dataset
data_path = "C:/Users/pierc/Desktop/Code/Python/AI/studentData.csv"
df = pd.read_csv(data_path, sep=";")

#Prepare data | drop unneeded columns
df["pass"] = df["G3"].apply(lambda x: 1 if x >= 10 else 0)
X = df.drop(columns=["G1", "G2", "G3", "pass"])
y = df["pass"]

#Encode categorical vars
for col in X.select_dtypes(include=['object']).columns:
    X[col] = LabelEncoder().fit_transform(X[col])

#Split and scale data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
scaler = StandardScaler()
X_train, X_test = scaler.fit_transform(X_train), scaler.transform(X_test)

#Train and eval model
model = LogisticRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)

print(f"Model Accuracy: {accuracy_score(y_test, y_pred):.2f}")
print(classification_report(y_test, y_pred))

#Plot confusion matrix
sns.heatmap(confusion_matrix(y_test, y_pred), annot=True, fmt="d", cmap="Blues")
plt.xlabel("Predicted")
plt.ylabel("Actual")
plt.show()





print("=============================")
#===========Exercise 2=================
print("=====Exercise 2=====")


import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.svm import SVC
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
from sklearn.model_selection import train_test_split
from sklearn.datasets import fetch_openml
from sklearn.preprocessing import StandardScaler

#Load MNIST dataset | The provided dataset link was not working...
mnist = fetch_openml("mnist_784", version=1, as_frame=False)
X, y = mnist.data.astype(np.float32), mnist.target.astype(np.int64)  # Convert X to float32 and y to int64

#Normalize
X /= 255.0

#Using a smaller sample size for faster training
sample_size = 10000
X_train, X_test, y_train, y_test = train_test_split(X[:sample_size], y[:sample_size], test_size=0.2, random_state=42)

#Standardize features
scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_test = scaler.transform(X_test)

#Support Vector Machine Classifier
svm_model = SVC(kernel="linear", C=1.0)
svm_model.fit(X_train, y_train)
y_pred_svm = svm_model.predict(X_test)

#Eval the SVM model
svm_accuracy = accuracy_score(y_test, y_pred_svm)
print(f"SVM Model Accuracy: {svm_accuracy:.4f}")
print("SVM Classification Report:\n", classification_report(y_test, y_pred_svm))

#Logistic Regression Classifier
log_model = LogisticRegression(max_iter=1000)
log_model.fit(X_train, y_train)
y_pred_log = log_model.predict(X_test)

#Evaluate Logistic Regression model
log_accuracy = accuracy_score(y_test, y_pred_log)
print(f"Logistic Regression Accuracy: {log_accuracy:.4f}")
print("Logistic Regression Classification Report:\n", classification_report(y_test, y_pred_log))

#Compare models
print(f"\nComparison:\nSVM Accuracy: {svm_accuracy:.4f}\nLogistic Regression Accuracy: {log_accuracy:.4f}")

#Confusion matrix for SVM
plt.figure(figsize=(10,4))
plt.subplot(1,2,1)
sns.heatmap(confusion_matrix(y_test, y_pred_svm), annot=False, cmap="Blues")
plt.title("SVM Confusion Matrix")

#Confusion matrix for Logistic Regression
plt.subplot(1,2,2)
sns.heatmap(confusion_matrix(y_test, y_pred_log), annot=False, cmap="Reds")
plt.title("Logistic Regression Confusion Matrix")
plt.show()



