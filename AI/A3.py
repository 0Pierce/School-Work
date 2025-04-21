import os

#Just disables warnings inside console for better viewing
os.environ['TF_ENABLE_ONEDNN_OPTS'] = '0'

import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, LabelEncoder
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Dropout, Input
from tensorflow.keras.callbacks import EarlyStopping
from tensorflow.keras.optimizers import Adam

#Loading file
try:
    data = pd.read_csv("student-mat.csv", sep=";")
    print("File loaded")
except FileNotFoundError:
    print("No file found")
    exit()


#Including features that may be helpful for predictions
rel_features = ['G1', 'G2', 'studytime', 'failures', 'absences', 'school', 'sex', 'age']
X = data[rel_features].copy()
y = data["G3"]

#categorical vars loaded
cat_cols = X.select_dtypes(include=["object"]).columns
for col in cat_cols:
    le = LabelEncoder()
    X.loc[:, col] = le.fit_transform(X[col])

#Normalize features
scaler = StandardScaler()
X = scaler.fit_transform(X)

#Split the data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

#Building the model and its parameters. Trying to maximize Accuracy
model = Sequential([
    Input(shape=(X_train.shape[1],)),
    Dense(512, activation="relu"),
    Dropout(0.2),
    Dense(256, activation="relu"),
    Dropout(0.2),
    Dense(128, activation="relu"),
    Dropout(0.2),
    Dense(1)
])
model.compile(optimizer=Adam(learning_rate=0.0005), loss="mse", metrics=["mae"])  # Lower learning rate

#Train model
early_stop = EarlyStopping(monitor="val_loss", patience=20)
model.fit(X_train, y_train, validation_split=0.2, epochs=200, batch_size=32,
          callbacks=[early_stop], verbose=1)

#Eval model
loss, mae = model.evaluate(X_test, y_test)
print(f"MAE value: {mae:.2f}")

#Predict and calculate accuracy -rounding predictions
y_pred = model.predict(X_test, verbose=0).flatten()
y_pred_rounded = np.round(y_pred)
accuracy = np.mean(np.abs(y_pred_rounded - y_test) <= 1) * 100
print(f"=====Accuracy (+-1, rounded): {accuracy:.2f}% =====")

#Testing with new data - rounded
new_data = X_test[:5]
new_pred = model.predict(new_data, verbose=0).flatten()
new_pred_rounded = np.round(new_pred)
print("New data predictions (rounded):", new_pred_rounded)
print("Actual values:", y_test[:5].values)

#Checking with a +-2 treshhold as well
accuracy_2 = np.mean(np.abs(y_pred_rounded - y_test) <= 2) * 100
print("For testing purposes:")
print(f"Accuracy (+-2, rounded): {accuracy_2:.2f}%")


#============Exercise 2============
print("\n===Exercise 2===")

import tensorflow as tf
from tensorflow.keras import Sequential
from tensorflow.keras.layers import Dense, Dropout
from tensorflow.keras.utils import to_categorical

# Load and preprocess MNIST data
(X_train, y_train), (X_test, y_test) = tf.keras.datasets.mnist.load_data()
X_train = X_train.reshape(-1, 784) / 255.0  # Flatten and normalize
X_test = X_test.reshape(-1, 784) / 255.0
y_train = to_categorical(y_train, 10)  # One-hot encode
y_test = to_categorical(y_test, 10)

# Build MLP model
model = Sequential([
    Dense(128, activation="relu", input_shape=(784,)),
    Dropout(0.2),
    Dense(64, activation="relu"),
    Dropout(0.2),
    Dense(10, activation="softmax")
])
model.compile(optimizer="adam", loss="categorical_crossentropy", metrics=["accuracy"])

#Train model
model.fit(X_train, y_train, validation_split=0.2, epochs=10, batch_size=128)

#Eval model
loss, accuracy = model.evaluate(X_test, y_test)
print(f"Test Accuracy: {accuracy * 100:.2f}%")

#Comparison with Assignment 2 (Numbers are from assignment 2)
print("Comparison with Lab Assignment 2:")
print(f"MLP Accuracy: {accuracy * 100:.2f}%")
print("\nAssignment 2:")
print("Logistic Regression Accuracy: 90.01% ")
print("SVM Accuracy: 93.3%")